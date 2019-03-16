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

echo ' - Compile Mandelbrot Java'
javac javabenchmarks/mandelbrot/*.java
jar -cf generated/MandelbrotJavaBenchmark.jar javabenchmarks/mandelbrot/*.class resultswriter/ResultsWriterJava.class

echo ' - Compile NBody Java'
javac javabenchmarks/nbody/*.java
jar -cf generated/NBodyJavaBenchmark.jar javabenchmarks/nbody/*.class resultswriter/ResultsWriterJava.class

echo ' - Compile Spectral Norm Java'
javac javabenchmarks/spectralnorm/*.java
jar -cf generated/SpectralNormJavaBenchmark.jar javabenchmarks/spectralnorm/*.class resultswriter/ResultsWriterJava.class


echo 'Compiling Kotlin benchmarks'

echo ' - Compile Binary Trees Kt Converted'
kotlinc -include-runtime -d generated/BinaryTreesKtConvBenchmark.jar kotlinbenchmarks/converted/binarytrees/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Fannkuch Redux Kt Converted'
kotlinc -include-runtime -d generated/FannkuchReduxKtConvBenchmark.jar kotlinbenchmarks/converted/fannkuchredux/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Fasta Kt Converted'
kotlinc -include-runtime -d generated/FastaKtConvBenchmark.jar kotlinbenchmarks/converted/fasta/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Mandelbrot Kt Converted'
kotlinc -include-runtime -d generated/MandelbrotKtConvBenchmark.jar kotlinbenchmarks/converted/mandelbrot/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile NBody Kt Converted'
kotlinc -include-runtime -d generated/NBodyKtConvBenchmark.jar kotlinbenchmarks/converted/nbody/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Spectral Norm Kt Converted'
kotlinc -include-runtime -d generated/SpectralNormKtConvBenchmark.jar kotlinbenchmarks/converted/spectralnorm/*.kt resultswriter/ResultsWriterKt.kt


echo 'Compiling Kotlin Idiomatic'

echo ' - Compile Binary Trees Kt Idiomatic'
kotlinc -include-runtime -d generated/BinaryTreesKtIdiomBenchmark.jar kotlinbenchmarks/idiomatic/binarytrees/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Fannkuch Redux Kt Idiomatic'
kotlinc -include-runtime -d generated/FannkuchReduxKtIdiomBenchmark.jar kotlinbenchmarks/idiomatic/fannkuchredux/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Fasta Kt Idiomatic'
kotlinc -include-runtime -d generated/FastaKtIdiomBenchmark.jar kotlinbenchmarks/idiomatic/fasta/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Mandelbrot Kt Idiomatic'
kotlinc -include-runtime -d generated/MandelbrotKtIdiomBenchmark.jar kotlinbenchmarks/idiomatic/mandelbrot/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile NBody Kt Idiomatic'
kotlinc -include-runtime -d generated/NBodyKtIdiomBenchmark.jar kotlinbenchmarks/idiomatic/nbody/*.kt resultswriter/ResultsWriterKt.kt

echo ' - Compile Spectral Norm Kt Idiomatic'
kotlinc -include-runtime -d generated/SpectralNormKtIdiomBenchmark.jar kotlinbenchmarks/idiomatic/spectralnorm/*.kt resultswriter/ResultsWriterKt.kt


echo 'Warmup Binary Trees Kotlin Converted'
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 warmup
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 warmup
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 warmup

echo 'Executing Binary Trees Kotlin Converted benchmark'
java -jar generated/BinaryTreesKtConvBenchmark.jar 21 benchmark

echo 'Warmup Binary Trees Kotlin Idiomatic'
java -jar generated/BinaryTreesKtIdiomBenchmark.jar 21 warmup
java -jar generated/BinaryTreesKtIdiomBenchmark.jar 21 warmup
java -jar generated/BinaryTreesKtIdiomBenchmark.jar 21 warmup

echo 'Executing Binary Trees Kotlin Idiomatic benchmark'
java -jar generated/BinaryTreesKtIdiomBenchmark.jar 21 benchmark

echo 'Warmup Binary Trees Java'
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 warmup
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 warmup
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 warmup

echo 'Executing Binary Trees Java benchmark'
java -cp generated/BinaryTreesJavaBenchmark.jar javabenchmarks.binarytrees.BinaryTreesExec 21 benchmark


echo 'Warmup Fannkuch Redux Kotlin Converted'
java -jar generated/FannkuchReduxKtConvBenchmark.jar 7 warmup
java -jar generated/FannkuchReduxKtConvBenchmark.jar 7 warmup
java -jar generated/FannkuchReduxKtConvBenchmark.jar 7 warmup

echo 'Executing Fannkuch Redux Kotlin Converted benchmark'
java -jar generated/FannkuchReduxKtConvBenchmark.jar 7 benchmark

echo 'Warmup Fannkuch Redux Kotlin Idiomatic'
java -jar generated/FannkuchReduxKtIdiomBenchmark.jar 7 warmup
java -jar generated/FannkuchReduxKtIdiomBenchmark.jar 7 warmup
java -jar generated/FannkuchReduxKtIdiomBenchmark.jar 7 warmup

echo 'Executing Fannkuch Redux Kotlin Idiomatic benchmark'
java -jar generated/FannkuchReduxKtIdiomBenchmark.jar 7 benchmark

echo 'Warmup Fannkuch Redux Java'
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 7 warmup
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 7 warmup
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 7 warmup

echo 'Executing Fannkuch Redux Java benchmark'
java -cp generated/FannkuchReduxJavaBenchmark.jar javabenchmarks.fannkuchredux.FannkuchReduxExec 7 benchmark


echo 'Warmup Fasta Kotlin Converted'
java -jar generated/FastaKtConvBenchmark.jar 25000000 warmup
java -jar generated/FastaKtConvBenchmark.jar 25000000 warmup
java -jar generated/FastaKtConvBenchmark.jar 25000000 warmup

echo 'Executing Fasta Kotlin Converted benchmark'
java -jar generated/FastaKtConvBenchmark.jar 25000000 benchmark

echo 'Warmup Fasta Kotlin Idiomatic'
java -jar generated/FastaKtIdiomBenchmark.jar 25000000 warmup
java -jar generated/FastaKtIdiomBenchmark.jar 25000000 warmup
java -jar generated/FastaKtIdiomBenchmark.jar 25000000 warmup

echo 'Executing Fasta Kotlin Idiomatic benchmark'
java -jar generated/FastaKtIdiomBenchmark.jar 25000000 benchmark

echo 'Warmup Fasta Java'
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 25000000 warmup
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 25000000 warmup
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 25000000 warmup

echo 'Executing Fasta Java benchmark'
java -cp generated/FastaJavaBenchmark.jar javabenchmarks.fasta.FastaExec 25000000 benchmark


echo 'Warmup Mandelbrot Kotlin Converted'
java -jar generated/MandelbrotKtConvBenchmark.jar 16000 warmup
java -jar generated/MandelbrotKtConvBenchmark.jar 16000 warmup
java -jar generated/MandelbrotKtConvBenchmark.jar 16000 warmup

echo 'Executing Mandelbrot Kotlin Converted benchmark'
java -jar generated/MandelbrotKtConvBenchmark.jar 16000 benchmark

echo 'Warmup Mandelbrot Kotlin Idiomatic'
java -jar generated/MandelbrotKtIdiomBenchmark.jar 16000 warmup
java -jar generated/MandelbrotKtIdiomBenchmark.jar 16000 warmup
java -jar generated/MandelbrotKtIdiomBenchmark.jar 16000 warmup

echo 'Executing Mandelbrot Kotlin Idiomatic benchmark'
java -jar generated/MandelbrotKtIdiomenchmark.jar 16000 benchmark

echo 'Warmup Mandelbrot Java'
java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 16000 warmup
java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 16000 warmup
java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 16000 warmup

echo 'Executing Mandelbrot Java benchmark'
java -cp generated/MandelbrotJavaBenchmark.jar javabenchmarks.mandelbrot.MandelbrotExec 16000 benchmark


echo 'Warmup NBody Kotlin Converted'
java -jar generated/NBodyKtConvBenchmark.jar 50000000 warmup
java -jar generated/NBodyKtConvBenchmark.jar 50000000 warmup
java -jar generated/NBodyKtConvBenchmark.jar 50000000 warmup

echo 'Executing NBody Java Converted benchmark'
java -jar generated/NBodyKtConvBenchmark.jar 50000000 benchmark

echo 'Warmup NBody Kotlin Idiomatic'
java -jar generated/NBodyKtIdiomBenchmark.jar 50000000 warmup
java -jar generated/NBodyKtIdiomBenchmark.jar 50000000 warmup
java -jar generated/NBodyKtIdiomBenchmark.jar 50000000 warmup

echo 'Executing NBody Java Idiomatic benchmark'
java -jar generated/NBodyKtIdiomBenchmark.jar 50000000 benchmark

echo 'Warmup NBody Java'
java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 50000000 warmup
java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 50000000 warmup
java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 50000000 warmup

echo 'Executing NBody Java benchmark'
java -cp generated/NBodyJavaBenchmark.jar javabenchmarks.nbody.NBodyExec 50000000 benchmark


echo 'Warmup Spectral Norm Kotlin Converted'
java -jar generated/SpectralNormKtConvBenchmark.jar 5500 warmup
java -jar generated/SpectralNormKtConvBenchmark.jar 5500 warmup
java -jar generated/SpectralNormKtConvBenchmark.jar 5500 warmup

echo 'Executing Spectral Norm Kotlin Converted benchmark'
java -jar generated/SpectralNormKtConvBenchmark.jar 5500 benchmark

echo 'Warmup Spectral Norm Kotlin Idiomatic'
java -jar generated/SpectralNormKtIdiomBenchmark.jar 5500 warmup
java -jar generated/SpectralNormKtIdiomBenchmark.jar 5500 warmup
java -jar generated/SpectralNormKtIdiomBenchmark.jar 5500 warmup

echo 'Executing Spectral Norm Kotlin Idiomatic benchmark'
java -jar generated/SpectralNormKtIdiomBenchmark.jar 5500 benchmark

echo 'Warmup Spectral Norm Java'
java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 5500 warmup
java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 5500 warmup
java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 5500 warmup

echo 'Executing Spectral Norm Java benchmark'
java -cp generated/SpectralNormJavaBenchmark.jar javabenchmarks.spectralnorm.SpectralNormExec 5500 benchmark


echo 'End of benchmark'