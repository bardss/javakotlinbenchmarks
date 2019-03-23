package kotlinbenchmarks.idiomatic.nbody

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "NBody Kotlin Idiomatic"
    val startTime = System.nanoTime()
    NBodyIdiom.main(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}