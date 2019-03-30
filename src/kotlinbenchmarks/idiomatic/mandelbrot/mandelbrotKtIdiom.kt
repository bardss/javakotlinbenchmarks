package kotlinbenchmarks.idiomatic.mandelbrot

import java.io.BufferedOutputStream
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    mandelbrotKtIdiom.execute(args)
}

object mandelbrotKtIdiom {
    private var out: Array<ByteArray> = arrayOf()
    private var yCt = AtomicInteger()
    private var Crb = doubleArrayOf()
    private var Cib = doubleArrayOf()

    private fun getByte(x: Int, y: Int): Int {
        var res = 0
        var i = 0
        while (i < 8) {
            var Zr1 = Crb[x + i]
            var Zi1 = Cib[y]

            var Zr2 = Crb[x + i + 1]
            var Zi2 = Cib[y]

            var b = 0
            var j = 49
            do {
                val nZr1 = Zr1 * Zr1 - Zi1 * Zi1 + Crb[x + i]
                val nZi1 = Zr1 * Zi1 + Zr1 * Zi1 + Cib[y]
                Zr1 = nZr1
                Zi1 = nZi1

                val nZr2 = Zr2 * Zr2 - Zi2 * Zi2 + Crb[x + i + 1]
                val nZi2 = Zr2 * Zi2 + Zr2 * Zi2 + Cib[y]
                Zr2 = nZr2
                Zi2 = nZi2

                if (Zr1 * Zr1 + Zi1 * Zi1 > 4) {
                    b = b or 2
                    if (b == 3) break
                }
                if (Zr2 * Zr2 + Zi2 * Zi2 > 4) {
                    b = b or 1
                    if (b == 3) break
                }
            } while (--j > 0)
            res = (res shl 2) + b
            i += 2
        }
        return res xor -1
    }

    internal fun putLine(y: Int, line: ByteArray) {
        line.indices.forEach { index ->
            line[index] = getByte(index * 8, y).toByte()
        }
    }

    fun execute(args: Array<String>) {
        var N = 6000
        if (args.isNotEmpty()) N = args[0].toInt()

        Crb = DoubleArray(N + 7)
        Cib = DoubleArray(N + 7)
        val invN = 2.0 / N
        for (i in 0 until N) {
            Cib[i] = i * invN - 1.0
            Crb[i] = i * invN - 1.5
        }
        yCt = AtomicInteger()
        out = Array(N) { ByteArray((N + 7) / 8) }

        val pool = arrayOfNulls<Thread>(2 * Runtime.getRuntime().availableProcessors())
        for (i in pool.indices)
            pool[i] = object : Thread() {
                override fun run() {
                    var y: Int = yCt.getAndIncrement()
                    while (y < out.size) {
                        putLine(y, out[y])
                        y = yCt.getAndIncrement()
                    }
                }
            }
        pool.filterNotNull().forEach { thread ->
            thread.start()
            thread.join()
        }

        BufferedOutputStream(System.out).apply {
            write("P4\n$N $N\n".toByteArray())
            for (i in 0 until N) write(out[i])
        }.close()
    }
}