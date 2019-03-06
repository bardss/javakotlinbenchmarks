package kotlinbenchmarks.converted.mandelbrot

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "Mandelbrot Kotlin Converted"
    val startTime = System.nanoTime()
    MandelbrotConv.execute(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}