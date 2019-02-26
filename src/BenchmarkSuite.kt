import javabenchmarks.*
import kotlinbenchmarks.converted.*

class BenchmarkSuite {

    val results: HashMap<String, Long> = hashMapOf()
    val inputNBody = arrayOf("50000000")
    val inputFasta = arrayOf("25000000")

    fun executeJavaFasta(){
        val key = "Fasta Java"
        val startTime = System.nanoTime()
        Fasta.execute(inputFasta)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedFasta(){
        val key = "Fasta Kotlin Converted"
        val startTime = System.nanoTime()
        FastaConverted.execute(inputFasta)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaNBody(){
        val key = "NBody Java"
        val startTime = System.nanoTime()
        NBody.execute(inputNBody)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedNBody(){
        val key = "NBody Kotlin Converted"
        val startTime = System.nanoTime()
        NBodyConverted.execute(inputNBody)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaFannkuchRedux(){
        val key = "FannkuchRedux Java"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        FannkuchRedux.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedFannkuchRedux(){
        val key = "FannkuchRedux Kotlin Converted"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        FannkuchReduxConverted.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaBinaryTrees(){
        val key = "BinaryTrees Java"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        BinaryTrees.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedBinaryTrees(){
        val key = "BinaryTrees Kotlin Converted"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        BinaryTreesConverted.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaRegexRedux(){
        val key = "RegexRedux Java"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        RegexRedux.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedRegexRedux(){
        val key = "RegexRedux Kotlin Converted"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        RegexReduxConverted.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaSpectralNorm(){
        val key = "SpectralNorm Java"
        val args = arrayOf("5500")
        val startTime = System.nanoTime()
        SpectralNorm.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedSpectralNorm(){
        val key = "SpectralNorm Kotlin Converted"
        val args = arrayOf("5500")
        val startTime = System.nanoTime()
        SpectralNormConverted.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaMandelbrot(){
        val key = "Mandelbrot Java"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        Mandelbrot.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedMandelbrot(){
        val key = "Mandelbrot Kotlin Converted"
        val args = arrayOf("1")
        val startTime = System.nanoTime()
        MandelbrotConverted.execute(args)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

}