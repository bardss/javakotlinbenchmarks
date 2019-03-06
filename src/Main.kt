import resultswriter.ResultsWriterKt

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val benchmarkSuite = BenchmarkSuite()
        val resultsWriter = ResultsWriterKt()

        benchmarkSuite.executeJavaFasta()
        benchmarkSuite.executeKotlinConvertedFasta()

        benchmarkSuite.executeJavaNBody()
        benchmarkSuite.executeKotlinConvertedNBody()

        benchmarkSuite.executeJavaFannkuchRedux()
        benchmarkSuite.executeKotlinConvertedFannkuchRedux()

        benchmarkSuite.executeJavaBinaryTrees()
        benchmarkSuite.executeKotlinConvertedBinaryTrees()

        benchmarkSuite.executeJavaSpectralNorm()
        benchmarkSuite.executeKotlinConvertedSpectralNorm()

        benchmarkSuite.executeJavaMandelbrot()
        benchmarkSuite.executeKotlinConvertedMandelbrot()

        val results = benchmarkSuite.results
        resultsWriter.writeResultsToFile(results)
    }

}