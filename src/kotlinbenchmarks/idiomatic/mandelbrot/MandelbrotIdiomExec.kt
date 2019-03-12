package kotlinbenchmarks.idiomatic.mandelbrot

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "Mandelbrot Kotlin Idiomatic"
    val startTime = System.nanoTime()
    MandelbrotIdiom.execute(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}