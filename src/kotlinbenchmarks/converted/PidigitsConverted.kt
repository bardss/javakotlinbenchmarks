package kotlinbenchmarks.converted

/**
 * The Computer Language Benchmarks Game
 * https://salsa.debian.org/benchmarksgame-team/benchmarksgame/
 * contributed by Mike Pall
 * java port by Stefan Krause
 */


class PidigitsConverted private constructor(internal val n: Int) {

    internal val q = GmpInteger()
    internal val r = GmpInteger()
    internal val s = GmpInteger()
    internal val t = GmpInteger()
    internal val u = GmpInteger()
    internal val v = GmpInteger()
    internal val w = GmpInteger()

    internal var i: Int = 0
    internal var k: Int = 0
    internal var c: Int = 0
    internal var digit: Int = 0
    internal var d: Int = 0
    internal var strBuf = StringBuffer(20)

    private fun compose_r(bq: Int, br: Int, bs: Int, bt: Int) {
        u.mul(r, bs)
        r.mul(r, bq)
        v.mul(t, br)
        r.add(r, v)
        t.mul(t, bt)
        t.add(t, u)
        s.mul(s, bt)
        u.mul(q, bs)
        s.add(s, u)
        q.mul(q, bq)
    }

    /* Compose matrix with numbers on the left. */
    private fun compose_l(bq: Int, br: Int, bs: Int, bt: Int) {
        r.mul(r, bt)
        u.mul(q, br)
        r.add(r, u)
        u.mul(t, bs)
        t.mul(t, bt)
        v.mul(s, br)
        t.add(t, v)
        s.mul(s, bq)
        s.add(s, u)
        q.mul(q, bq)
    }

    /* Extract one digit. */
    private fun extract(j: Int): Int {
        u.mul(q, j)
        u.add(u, r)
        v.mul(s, j)
        v.add(v, t)
        w.div(u, v)
        return w.intValue()
    }

    /* Print one digit. Returns 1 for the last digit. */
    private fun prdigit(y: Int): Boolean {
        strBuf.append(y)
        if (++i % 10 == 0 || i == n) {
            if (i % 10 != 0) for (j in 10 - i % 10 downTo 1) {
                strBuf.append(" ")
            }
            strBuf.append("\t:")
            strBuf.append(i)
            println(strBuf)
            strBuf = StringBuffer(20)
        }
        return i == n
    }

    /* Generate successive digits of PI. */
    internal fun pidigits() {
        var k = 1
        d = 0
        i = 0
        q.set(1)
        r.set(0)
        s.set(0)
        t.set(1)
        while (true) {
            val y = extract(3)
            if (y == extract(4)) {
                if (prdigit(y)) return
                compose_r(10, -10 * y, 0, 1)
            } else {
                compose_l(k, 4 * k + 2, 0, 2 * k + 1)
                k++
            }
        }
    }

    companion object {

        @JvmStatic
        fun execute(args: Array<String>) {
            val m = PidigitsConverted(Integer.parseInt(args[0]))
            m.pidigits()
        }
    }
}


internal class GmpInteger
// Public methods

() {
    private val pointer: Long = 0

    init {
        mpz_init()
    }

    constructor(value: Int) : this() {
        mpz_set_si(pointer, value)
    }

    fun set(value: Int) {
        mpz_set_si(pointer, value)
    }

    fun mul(src: GmpInteger, `val`: Int) {
        mpz_mul_si(pointer, src.pointer, `val`)
    }

    fun add(op1: GmpInteger, op2: GmpInteger) {
        mpz_add(pointer, op1.pointer, op2.pointer)
    }

    fun div(op1: GmpInteger, op2: GmpInteger) {
        mpz_tdiv_q(pointer, op1.pointer, op2.pointer)
    }

    fun intValue(): Int {
        return mpz_get_si(pointer)
    }

    fun doubleValue(): Double {
        return mpz_get_d(pointer)
    }

    protected fun finalize() {
        mpz_clear(pointer)
    }

    private external fun mpz_init()

    private external fun mpz_clear(src: Long)

    companion object {

        // Non public stuff

        init {
            System.loadLibrary("jgmplib")
        }

        private external fun mpz_mul_si(dest: Long, src: Long,
                                        `val`: Int)

        private external fun mpz_add(dest: Long, src: Long,
                                     src2: Long)

        private external fun mpz_tdiv_q(dest: Long, src: Long,
                                        src2: Long)

        private external fun mpz_set_si(src: Long, value: Int)

        private external fun mpz_get_si(src: Long): Int

        private external fun mpz_get_d(src: Long): Double
    }
}