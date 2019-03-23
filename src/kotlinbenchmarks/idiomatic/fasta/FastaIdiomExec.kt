package kotlinbenchmarks.idiomatic.fasta

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "Fasta Kotlin Converted"
    val startTime = System.nanoTime()
    FastaIdiom.main(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}