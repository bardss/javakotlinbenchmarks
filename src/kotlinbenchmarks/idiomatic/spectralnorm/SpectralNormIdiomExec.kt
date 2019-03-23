package kotlinbenchmarks.idiomatic.spectralnorm

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "SpectralNorm Kotlin Idiomatic"
    val startTime = System.nanoTime()
    SpectralNormIdiom.main(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}