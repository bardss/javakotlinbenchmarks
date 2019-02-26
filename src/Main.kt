
object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val benchmarkSuite = BenchmarkSuite()
        val resultsWriter = ResultsWriter()

//        benchmarkSuite.executeJavaFasta()
//        benchmarkSuite.executeKotlinConvertedFasta()

//        benchmarkSuite.executeJavaNBody()
//        benchmarkSuite.executeKotlinConvertedNBody()

//        benchmarkSuite.executeJavaFannkuchRedux()
//        benchmarkSuite.executeKotlinConvertedFannkuchRedux()
//
//        benchmarkSuite.executeJavaBinaryTrees()
//        benchmarkSuite.executeKotlinConvertedBinaryTrees()

//        TODO: Uncomment when proper stream conversion in Kotlin and corrent input from Fasta
//        benchmarkSuite.executeJavaRegexRedux()
//        benchmarkSuite.executeKotlinConvertedRegexRedux()

//        benchmarkSuite.executeJavaSpectralNorm()
//        benchmarkSuite.executeKotlinConvertedSpectralNorm()
//
//        benchmarkSuite.executeJavaMandelbrot()
//        benchmarkSuite.executeKotlinConvertedMandelbrot()

        val results = benchmarkSuite.results
        resultsWriter.writeResultsToFile(results)
    }

}