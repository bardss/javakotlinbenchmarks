package kotlinbenchmarks.converted.fannkuchredux

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "Fannkuch Redux Kotlin Converted"
    val startTime = System.nanoTime()
    FannkuchReduxConv.execute(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}