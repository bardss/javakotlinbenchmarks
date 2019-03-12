package kotlinbenchmarks.idiomatic.fannkuchredux

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "Fannkuch Redux Kotlin Idiomatic"
    val startTime = System.nanoTime()
    FannkuchReduxIdiom.execute(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}