#!/bin/bash

echo 'Executing benchmark suite'


echo 'Compiling Java benchmarks'
javac resultswriter/ResultsWriterJava.java

echo ' - Compile Binary Trees Java'
javac javabenchmarks/binarytrees/*.java
jar -cf generated/BinaryTreesJavaBenchmark.jar javabenchmarks/binarytrees/*.class resultswriter/ResultsWriterJava.class

echo ' - Compile Fannkuch Redux Java'
javac javabenchmarks/fannkuchredux/*.java
jar -cf generated/FannkuchReduxJavaBenchmark.jar javabenchmarks/fannkuchredux/*.class resultswriter/ResultsWriterJava.class

echo ' - Compile Fasta Java'
javac javabenchmarks/fasta/*.java
jar -cf generated/FastaJavaBenchmark.jar javabenchmarks/fasta/*.class resultswriter/ResultsWriterJava.class

# echo ' - Compile Mandelbrot Java'
# javac javabenchmarks/mandelbrot/*.java
# jar -cf generated/MandelbrotJavaBenchmark.jar javabenchmarks/mandelbrot/*.class resultswriter/ResultsWriterJava.class

# echo ' - Compile NBody Java'
# javac javabenchmarks/nbody/*.java
# jar -cf generated/NBodyJavaBenchmark.jar javabenchmarks/nbody/*.class resultswriter/ResultsWriterJava.class

# echo ' - Compile Spectral Norm Java'
# javac javabenchmarks/spectralnorm/*.java
# jar -cf generated/SpectralNormJavaBenchmark.jar javabenchmarks/spectralnorm/*.class resultswriter/ResultsWriterJava.class


echo 'Compiling Kotlin benchmarks'

echo ' - Compile Binary Trees Kt Converted'
kotlinc -include-runtime -d generated/BinaryTreesKtConvBenchmark.jar kotlinbenchmarks/converted/binarytrees/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Fannkuch Redux Kt Converted'
kotlinc -include-runtime -d generated/FannkuchReduxKtConvBenchmark.jar kotlinbenchmarks/converted/fannkuchredux/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Fasta Kt Converted'
kotlinc -include-runtime -d generated/FastaKtConvBenchmark.jar kotlinbenchmarks/converted/fasta/*.kt resultswriter/ResultsWriterKt.kt

# echo ' - Compile Mandelbrot Kt Converted'
# kotlinc -include-runtime -d generated/MandelbrotKtConvBenchmark.jar kotlinbenchmarks/converted/mandelbrot/*.kt resultswriter/ResultsWriterKt.kt

# echo ' - Compile NBody Kt Converted'
# kotlinc -include-runtime -d generated/NBodyKtConvBenchmark.jar kotlinbenchmarks/converted/nbody/*.kt resultswriter/ResultsWriterKt.kt

# echo ' - Compile Spectral Norm Kt Converted'
# kotlinc -include-runtime -d generated/SpectralNormKtConvBenchmark.jar kotlinbenchmarks/converted/spectralnorm/*.kt resultswriter/ResultsWriterKt.kt

echo 'Warmup Binary Trees Kotlin'
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 warmup
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 warmup
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 warmup

echo 'Executing Binary Trees Kotlin benchmark'
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 benchmark

echo 'Warmup Binary Trees Java'
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 warmup
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 warmup
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 warmup

echo 'Executing Binary Trees Java benchmark'
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 benchmark


echo 'Warmup Fannkuch Redux Java'
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 21 warmup
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 21 warmup
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 21 warmup

echo 'Executing Fannkuch Redux Java benchmark'
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 21 benchmark

echo 'Warmup Fannkuch Redux Kotlin'
java -jar generated/FannkuchReduxKtConvBenchmark.jar 21 warmup
java -jar generated/FannkuchReduxKtConvBenchmark.jar 21 warmup
java -jar generated/FannkuchReduxKtConvBenchmark.jar 21 warmup

echo 'Executing Fannkuch Redux Kotlin benchmark'
java -jar generated/FannkuchReduxKtConvBenchmark.jar 21 benchmark


echo 'Warmup Fasta Java'
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 21 warmup
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 21 warmup
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 21 warmup

echo 'Executing Fasta Java benchmark'
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 21 benchmark

echo 'Warmup Fasta Kotlin'
java -jar generated/FastaKtConvBenchmark.jar 21 warmup
java -jar generated/FastaKtConvBenchmark.jar 21 warmup
java -jar generated/FastaKtConvBenchmark.jar 21 warmup

echo 'Executing Fasta Kotlin benchmark'
java -jar generated/FastaKtConvBenchmark.jar 21 benchmark

# echo 'Warmup Mandelbrot Kotlin'
# java -jar generated/MandelbrotKtConvBenchmark.jar 21 warmup
# java -jar generated/MandelbrotKtConvBenchmark.jar 21 warmup
# java -jar generated/MandelbrotKtConvBenchmark.jar 21 warmup

# echo 'Executing Mandelbrot Kotlin benchmark'
# java -jar generated/MandelbrotKtConvBenchmark.jar 21 benchmark

# echo 'Warmup Mandelbrot Java'
# java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 21 warmup
# java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 21 warmup
# java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 21 warmup

# echo 'Executing Mandelbrot Java benchmark'
# java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 21 benchmark


# echo 'Warmup NBody Kotlin'
# java -jar generated/NBodyKtConvBenchmark.jar 21 warmup
# java -jar generated/NBodyKtConvBenchmark.jar 21 warmup
# java -jar generated/NBodyKtConvBenchmark.jar 21 warmup

# echo 'Executing NBody Java benchmark'
# java -jar generated/NBodyKtConvBenchmark.jar 21 benchmark

# echo 'Warmup NBody Java'
# java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 21 warmup
# java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 21 warmup
# java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 21 warmup

# echo 'Executing NBody Java benchmark'
# java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 21 benchmark


# echo 'Warmup Spectral Norm Kotlin'
# java -jar generated/SpectralNormKtConvBenchmark.jar 21 warmup
# java -jar generated/SpectralNormKtConvBenchmark.jar 21 warmup
# java -jar generated/SpectralNormKtConvBenchmark.jar 21 warmup

# echo 'Executing Spectral Norm Java benchmark'
# java -jar generated/SpectralNormKtConvBenchmark.jar 21 benchmark

# echo 'Warmup Spectral Norm Java'
# java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 21 warmup
# java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 21 warmup
# java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 21 warmup

# echo 'Executing Spectral Norm Java benchmark'
# java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 21 benchmark


echo 'End of benchmark'