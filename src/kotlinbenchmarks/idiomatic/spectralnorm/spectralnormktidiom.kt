package kotlinbenchmarks.idiomatic.spectralnorm

import java.text.DecimalFormat
import java.util.concurrent.CyclicBarrier

fun main(args: Array<String>) {
    spectralnormktidiom.execute(args)
}

object spectralnormktidiom {
    private val formatter = DecimalFormat("#.000000000")

    fun execute(args: Array<String>) {
        var n = 1000
        if (args.isNotEmpty()) n = args[0].toInt()

        println(formatter.format(spectralnormGame(n)))
    }


    private fun spectralnormGame(n: Int): Double {
        // create unit vector
        val u = DoubleArray(n)
        val v = DoubleArray(n)
        val tmp = DoubleArray(n)

        for (i in 0 until n)
            u[i] = 1.0

        // get available processor, then set up syn object
        val nthread = Runtime.getRuntime().availableProcessors()
        Approximate.barrier = CyclicBarrier(nthread)

        val chunk = n / nthread
        val ap = arrayOfNulls<Approximate>(nthread)

        for (i in 0 until nthread) {
            val r1 = i * chunk
            val r2 = if (i < nthread - 1) r1 + chunk else n

            ap[i] = Approximate(u, v, tmp, r1, r2)
        }


        var vBv = 0.0
        var vv = 0.0
        for (i in 0 until nthread) {
            try {
                ap[i]?.let { approximate ->
                    approximate.join()
                    vBv += approximate.m_vBv
                    vv += approximate.m_vv
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        return Math.sqrt(vBv / vv)
    }


    private class Approximate(private val _u: DoubleArray, private val _v: DoubleArray, private val _tmp: DoubleArray, private val range_begin: Int, private val range_end: Int) : Thread() {
        var m_vBv = 0.0
        var m_vv = 0.0


        init {
            start()
        }

        override fun run() {
            // 20 steps of the power method
            for (i in 0..9) {
                MultiplyAtAv(_u, _tmp, _v)
                MultiplyAtAv(_v, _tmp, _u)
            }

            for (i in range_begin until range_end) {
                m_vBv += _u[i] * _v[i]
                m_vv += _v[i] * _v[i]
            }
        }

        /* multiply vector v by matrix A, each thread evaluate its range only */
        private fun MultiplyAv(v: DoubleArray, Av: DoubleArray) {
            for (i in range_begin until range_end) {
                var sum = 0.0
                for (j in v.indices)
                    sum += eval_A(i, j) * v[j]

                Av[i] = sum
            }
        }

        /* multiply vector v by matrix A transposed */
        private fun MultiplyAtv(v: DoubleArray, Atv: DoubleArray) {
            for (i in range_begin until range_end) {
                var sum = 0.0
                for (j in v.indices)
                    sum += eval_A(j, i) * v[j]

                Atv[i] = sum
            }
        }

        /* multiply vector v by matrix A and then by matrix A transposed */
        private fun MultiplyAtAv(v: DoubleArray, tmp: DoubleArray, AtAv: DoubleArray) {
            try {
                MultiplyAv(v, tmp)
                // all thread must syn at completion
                barrier?.await()
                MultiplyAtv(tmp, AtAv)
                // all thread must syn at completion
                barrier?.await()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        companion object {
            var barrier: CyclicBarrier? = null

            /* return element i,j of infinite matrix A */
            private fun eval_A(i: Int, j: Int): Double {
                val div = ((i + j) * (i + j + 1)).ushr(1) + i + 1
                return 1.0 / div
            }
        }
    }
}