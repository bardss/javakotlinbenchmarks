package kotlinbenchmarks.idiomatic.binarytrees

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "BinaryTrees Kotlin Idiomatic"
    val startTime = System.nanoTime()
    BinaryTreesIdiom.execute(args)
    val endTime = System.nanoTime()
    println()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}