
object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val benchmarkSuite = BenchmarkSuite()
        val resultsWriter = ResultsWriter()

        benchmarkSuite.executeJavaFasta()
        benchmarkSuite.executeKotlinConvertedFasta()
        benchmarkSuite.executeJavaNBody()
        benchmarkSuite.executeKotlinConvertedNBody()

        val results = benchmarkSuite.results
        resultsWriter.writeResultsToFile(results)
    }

}