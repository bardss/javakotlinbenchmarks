package kotlinbenchmarks.converted

import resultswriter.ResultsWriter

fun main(args: Array<String>) {
    val key = "Fannkuch Redux Kotlin Converted"
    val startTime = System.nanoTime()
    FannkuchReduxConv.execute(args)
    val endTime = System.nanoTime()
    val result = endTime - startTime
    val resultsWriter = ResultsWriter()
    resultsWriter.writeResultsToFile(key, result)}