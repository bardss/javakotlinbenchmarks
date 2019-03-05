import javabenchmarks.*
import kotlinbenchmarks.converted.*

class BenchmarkSuite {

    val results: HashMap<String, Long> = hashMapOf()
    private val inputNBody = arrayOf("50000000")
    private val inputFasta = arrayOf("25000000")
    private val inputFannkuch = arrayOf("7")
    private val inputBinaryTrees = arrayOf("21")
    private val inputSpectralNorm = arrayOf("5500")
    private val inputMandelbrot = arrayOf("16000")


    fun executeJavaFasta(){
        val key = "Fasta Java"
        val startTime = System.nanoTime()
        Fasta.main(inputFasta)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedFasta(){
        val key = "Fasta Kotlin Converted"
        val startTime = System.nanoTime()
        FastaConv.execute(inputFasta)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaNBody(){
        val key = "NBody Java"
        val startTime = System.nanoTime()
        NBody.main(inputNBody)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedNBody(){
        val key = "NBody Kotlin Converted"
        val startTime = System.nanoTime()
        NBodyConv.execute(inputNBody)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaFannkuchRedux(){
        val key = "FannkuchRedux Java"
        val startTime = System.nanoTime()
        FannkuchRedux.main(inputFannkuch)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedFannkuchRedux(){
        val key = "FannkuchRedux Kotlin Converted"
        val startTime = System.nanoTime()
        FannkuchReduxConv.execute(inputFannkuch)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaBinaryTrees(){
        val key = "BinaryTrees Java"
        val startTime = System.nanoTime()
        BinaryTrees.main(inputBinaryTrees)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedBinaryTrees(){
        val key = "BinaryTrees Kotlin Converted"
        val startTime = System.nanoTime()
        BinaryTreesConv.execute(inputBinaryTrees)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaSpectralNorm(){
        val key = "SpectralNorm Java"
        val startTime = System.nanoTime()
        SpectralNorm.main(inputSpectralNorm)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedSpectralNorm(){
        val key = "SpectralNorm Kotlin Converted"
        val startTime = System.nanoTime()
        SpectralNormConv.execute(inputSpectralNorm)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeJavaMandelbrot(){
        val key = "Mandelbrot Java"
        val startTime = System.nanoTime()
        Mandelbrot.main(inputMandelbrot)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

    fun executeKotlinConvertedMandelbrot(){
        val key = "Mandelbrot Kotlin Converted"
        val startTime = System.nanoTime()
        MandelbrotConv.execute(inputMandelbrot)
        val endTime = System.nanoTime()
        results[key] = (endTime - startTime)
    }

}