package kotlinbenchmarks.converted.nbody

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "NBody Kotlin Converted"
    val startTime = System.nanoTime()
    NBodyConv.execute(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}