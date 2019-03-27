package kotlinbenchmarks.idiomatic.nbody

fun main(args: Array<String>) {
    NBodyIdiom.execute(args)
}

object NBodyIdiom {
    fun execute(args: Array<String>) {
        val n = args[0].toInt()

        val bodies = NBodySystem()
        System.out.printf("%.9f\n", bodies.energy())
        for (i in 0 until n)
            bodies.advance(0.01)
        System.out.printf("%.9f\n", bodies.energy())
    }
}

private class NBodySystem {

    private val bodies: Array<Body> = arrayOf(Body.sun(), Body.jupiter(), Body.saturn(), Body.uranus(), Body.neptune())

    init {

        var px = 0.0
        var py = 0.0
        var pz = 0.0
        for (i in 0 until LENGTH) {
            px += bodies[i].vx * bodies[i].mass
            py += bodies[i].vy * bodies[i].mass
            pz += bodies[i].vz * bodies[i].mass
        }
        bodies[0].offsetMomentum(px, py, pz)
    }

    fun advance(dt: Double) {
        val b = bodies
        for (i in 0 until LENGTH - 1) {
            val iBody = b[i]
            val iMass = iBody.mass
            val ix = iBody.x
            val iy = iBody.y
            val iz = iBody.z

            for (j in i + 1 until LENGTH) {
                val jBody = b[j]
                val dx = ix - jBody.x
                val dy = iy - jBody.y
                val dz = iz - jBody.z

                val dSquared = dx * dx + dy * dy + dz * dz
                val distance = Math.sqrt(dSquared)
                val mag = dt / (dSquared * distance)

                val jMass = jBody.mass

                iBody.vx -= dx * jMass * mag
                iBody.vy -= dy * jMass * mag
                iBody.vz -= dz * jMass * mag

                jBody.vx += dx * iMass * mag
                jBody.vy += dy * iMass * mag
                jBody.vz += dz * iMass * mag
            }
        }

        for (i in 0 until LENGTH) {
            val body = b[i]
            body.x += dt * body.vx
            body.y += dt * body.vy
            body.z += dt * body.vz
        }
    }

    fun energy(): Double {
        var dx: Double
        var dy: Double
        var dz: Double
        var distance: Double
        var e = 0.0

        for (i in bodies.indices) {
            val iBody = bodies[i]
            e += 0.5 * iBody.mass *
                    (iBody.vx * iBody.vx
                            + iBody.vy * iBody.vy
                            + iBody.vz * iBody.vz)

            for (j in i + 1 until bodies.size) {
                val jBody = bodies[j]
                dx = iBody.x - jBody.x
                dy = iBody.y - jBody.y
                dz = iBody.z - jBody.z

                distance = Math.sqrt(dx * dx + dy * dy + dz * dz)
                e -= iBody.mass * jBody.mass / distance
            }
        }
        return e
    }

    companion object {
        private const val LENGTH = 5
    }
}


private class Body {

    var x: Double = 0.0
    var y: Double = 0.0
    var z: Double = 0.0
    var vx: Double = 0.0
    var vy: Double = 0.0
    var vz: Double = 0.0
    var mass: Double = 0.0

    fun offsetMomentum(px: Double, py: Double, pz: Double): Body {
        vx = -px / SOLAR_MASS
        vy = -py / SOLAR_MASS
        vz = -pz / SOLAR_MASS
        return this
    }

    companion object {
        private const val PI = 3.141592653589793
        private const val SOLAR_MASS = 4.0 * PI * PI
        private const val DAYS_PER_YEAR = 365.24

        fun jupiter(): Body {
            return Body().apply {
                x = 4.84143144246472090e+00
                y = -1.16032004402742839e+00
                z = -1.03622044471123109e-01
                vx = 1.66007664274403694e-03 * DAYS_PER_YEAR
                vy = 7.69901118419740425e-03 * DAYS_PER_YEAR
                vz = -6.90460016972063023e-05 * DAYS_PER_YEAR
                mass = 9.54791938424326609e-04 * SOLAR_MASS
            }
        }

        fun saturn(): Body {
            return Body().apply {
                x = 8.34336671824457987e+00
                y = 4.12479856412430479e+00
                z = -4.03523417114321381e-01
                vx = -2.76742510726862411e-03 * DAYS_PER_YEAR
                vy = 4.99852801234917238e-03 * DAYS_PER_YEAR
                vz = 2.30417297573763929e-05 * DAYS_PER_YEAR
                mass = 2.85885980666130812e-04 * SOLAR_MASS
            }
        }

        fun uranus(): Body {
            return Body().apply {
                x = 1.28943695621391310e+01
                y = -1.51111514016986312e+01
                z = -2.23307578892655734e-01
                vx = 2.96460137564761618e-03 * DAYS_PER_YEAR
                vy = 2.37847173959480950e-03 * DAYS_PER_YEAR
                vz = -2.96589568540237556e-05 * DAYS_PER_YEAR
                mass = 4.36624404335156298e-05 * SOLAR_MASS
            }
        }

        fun neptune(): Body {
            return Body().apply {
                x = 1.53796971148509165e+01
                y = -2.59193146099879641e+01
                z = 1.79258772950371181e-01
                vx = 2.68067772490389322e-03 * DAYS_PER_YEAR
                vy = 1.62824170038242295e-03 * DAYS_PER_YEAR
                vz = -9.51592254519715870e-05 * DAYS_PER_YEAR
                mass = 5.15138902046611451e-05 * SOLAR_MASS
            }
        }

        fun sun(): Body {
            return Body().apply {
                mass = SOLAR_MASS
            }
        }
    }
}