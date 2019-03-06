package kotlinbenchmarks.converted.spectralnorm

import resultswriter.ResultsWriterKt

fun main(args: Array<String>) {
    val key = "Spectral Norm Kotlin Converted"
    val startTime = System.nanoTime()
    SpectralNormConv.execute(args)
    val endTime = System.nanoTime()
    if (args[1] != "warmup") {
        val result = endTime - startTime
        val resultsWriter = ResultsWriterKt()
        resultsWriter.writeResultsToFile(key, result)
    }
}