import javabenchmarks.binarytrees.BinaryTrees
import javabenchmarks.fannkuchredux.FannkuchRedux
import javabenchmarks.fasta.Fasta
import javabenchmarks.mandelbrot.Mandelbrot
import javabenchmarks.nbody.NBody
import javabenchmarks.spectralnorm.SpectralNorm
import kotlinbenchmarks.converted.binarytrees.BinaryTreesConv
import kotlinbenchmarks.converted.fannkuchredux.FannkuchReduxConv
import kotlinbenchmarks.converted.fasta.FastaConv
import kotlinbenchmarks.converted.mandelbrot.MandelbrotConv
import kotlinbenchmarks.converted.nbody.NBodyConv
import kotlinbenchmarks.converted.spectralnorm.SpectralNormConv

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
        Fasta.execute(inputFasta)
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
        NBody.execute(inputNBody)
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
        FannkuchRedux.execute(inputFannkuch)
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
        BinaryTrees.execute(inputBinaryTrees)
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
        SpectralNorm.execute(inputSpectralNorm)
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
        Mandelbrot.execute(inputMandelbrot)
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