import javabenchmarks.Fasta
import javabenchmarks.NBody
import kotlinbenchmarks.converted.FastaConverted
import kotlinbenchmarks.converted.NBodyConverted

class BenchmarkSuite {

    val results: HashMap<String, Long> = hashMapOf()

    fun executeJavaFasta(){
        val key = "Fasta Java"
        val startTime = System.nanoTime()
        Fasta.execute()
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedFasta(){
        val key = "Fasta Kotlin Converted"
        val startTime = System.nanoTime()
        FastaConverted.execute()
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaNBody(){
        val key = "NBody Java"
        val nbodyArgs = arrayOf("1")
        val startTime = System.nanoTime()
        NBody.execute(nbodyArgs)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedNBody(){
        val key = "NBody Kotlin Converted"
        val nbodyArgs = arrayOf("1")
        val startTime = System.nanoTime()
        NBodyConverted.execute(nbodyArgs)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

}