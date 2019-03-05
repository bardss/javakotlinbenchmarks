package kotlinbenchmarks.converted

import resultswriter.ResultsWriter

fun main(args: Array<String>) {
    val key = "Mandelbrot Kotlin Converted"
    val startTime = System.nanoTime()
    MandelbrotConv.execute(args)
    val endTime = System.nanoTime()
    val result = endTime - startTime
    val resultsWriter = ResultsWriter()
    resultsWriter.writeResultsToFile(key, result)}