package kotlinbenchmarks.converted

/*
 * The Computer Language Benchmarks Game
 * https://salsa.debian.org/benchmarksgame-team/benchmarksgame/
 *
 * Contributed by Oleg Mazurov, June 2010
 *
 */

import java.util.concurrent.atomic.AtomicInteger

class FannkuchReduxConv : Runnable {

    internal var p: IntArray = intArrayOf()
    internal var pp: IntArray = intArrayOf()
    internal var count: IntArray = intArrayOf()

    internal fun print() {
        for (i in p.indices) {
            print(p[i] + 1)
        }
        println()
    }

    internal fun firstPermutation(idx: Int) {
        var idx = idx
        for (i in p.indices) {
            p[i] = i
        }

        for (i in count.size - 1 downTo 1) {
            val d = idx / Fact!![i]
            count[i] = d
            idx = idx % Fact!![i]

            System.arraycopy(p, 0, pp, 0, i + 1)
            for (j in 0..i) {
                p[j] = if (j + d <= i) pp[j + d] else pp[j + d - i - 1]
            }
        }
    }

    internal fun nextPermutation(): Boolean {
        var first = p[1]
        p[1] = p[0]
        p[0] = first

        var i = 1
        while (++count[i] > i) {
            count[i++] = 0
            p[0] = p[1]
            val next = p[0]
            for (j in 1 until i) {
                p[j] = p[j + 1]
            }
            p[i] = first
            first = next
        }
        return true
    }

    internal fun countFlips(): Int {
        var flips = 1
        var first = p[0]
        if (p[first] != 0) {
            System.arraycopy(p, 0, pp, 0, pp.size)
            do {
                ++flips
                var lo = 1
                var hi = first - 1
                while (lo < hi) {
                    val t = pp[lo]
                    pp[lo] = pp[hi]
                    pp[hi] = t
                    ++lo
                    --hi
                }
                val t = pp[first]
                pp[first] = first
                first = t
            } while (pp[first] != 0)
        }
        return flips
    }

    internal fun runTask(task: Int) {
        val idxMin = task * CHUNKSZ
        val idxMax = Math.min(Fact!![n], idxMin + CHUNKSZ)

        firstPermutation(idxMin)

        var maxflips = 1
        var chksum = 0
        var i = idxMin
        while (true) {

            if (p[0] != 0) {
                val flips = countFlips()
                maxflips = Math.max(maxflips, flips)
                chksum += if (i % 2 == 0) flips else -flips
            }

            if (++i == idxMax) {
                break
            }

            nextPermutation()
        }
        maxFlips!![task] = maxflips
        chkSums!![task] = chksum
    }

    override fun run() {
        p = IntArray(n)
        pp = IntArray(n)
        count = IntArray(n)

        var task: Int = taskId!!.getAndIncrement()
        while (task < NTASKS) {
            runTask(task)
            task = taskId!!.getAndIncrement()
        }
    }

    companion object {
        private val NCHUNKS = 150
        private var CHUNKSZ: Int = 0
        private var NTASKS: Int = 0
        private var n: Int = 0
        private var Fact: IntArray? = null
        private var maxFlips: IntArray? = null
        private var chkSums: IntArray? = null
        private var taskId: AtomicInteger? = null

        internal fun printResult(n: Int, res: Int, chk: Int) {
            println(chk.toString() + "\nPfannkuchen(" + n + ") = " + res)
        }

        @JvmStatic
        fun execute(args: Array<String>) {
            n = if (args.size > 0) Integer.parseInt(args[0]) else 12
            if (n < 0 || n > 12) {         // 13! won't fit into int
                printResult(n, -1, -1)
                return
            }
            if (n <= 1) {
                printResult(n, 0, 0)
                return
            }

            Fact = IntArray(n + 1)
            Fact!![0] = 1
            for (i in 1 until Fact!!.size) {
                Fact!![i] = Fact!![i - 1] * i
            }

            CHUNKSZ = (Fact!![n] + NCHUNKS - 1) / NCHUNKS
            NTASKS = (Fact!![n] + CHUNKSZ - 1) / CHUNKSZ
            maxFlips = IntArray(NTASKS)
            chkSums = IntArray(NTASKS)
            taskId = AtomicInteger(0)

            val nthreads = Runtime.getRuntime().availableProcessors()
            val threads = arrayOfNulls<Thread>(nthreads)
            for (i in 0 until nthreads) {
                threads[i] = Thread(FannkuchReduxConv())
                threads[i]!!.start()
            }
            for (t in threads) {
                try {
                    t!!.join()
                } catch (e: InterruptedException) {
                }

            }

            var res = 0
            for (v in maxFlips!!) {
                res = Math.max(res, v)
            }
            var chk = 0
            for (v in chkSums!!) {
                chk += v
            }

            printResult(n, res, chk)
        }
    }
}