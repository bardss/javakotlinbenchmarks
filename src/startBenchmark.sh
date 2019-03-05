#!/bin/bash

echo 'Executing benchmark suite'

echo 'Compile all Java benchmarks'

javac -d generated javabenchmarks/*.java

echo 'Compile all Kotlin benchmarks'

kotlinc kotlinbenchmarks/converted/BinaryTreesConv.kt -include-runtime -d generated/BinaryTreesConverted.jar
kotlinc kotlinbenchmarks/converted/FannkuchReduxConv.kt -include-runtime -d generated/FannkuchReduxConverted.jar
kotlinc kotlinbenchmarks/converted/FastaConv.kt -include-runtime -d generated/FastaConverted.jar
kotlinc kotlinbenchmarks/converted/MandelbrotConv.kt -include-runtime -d generated/MandelbrotConverted.jar
kotlinc kotlinbenchmarks/converted/NBodyConverted.kt -include-runtime -d generated/NBodyConverted.jar
kotlinc kotlinbenchmarks/converted/SpectralNormConv.kt -include-runtime -d generated/SpectralNormConverted.jar

echo 'Warmup BinaryTrees benchmark'

java -cp generated javabenchmarks/BinaryTrees 21
java -cp generated javabenchmarks/BinaryTrees 21
java -cp generated javabenchmarks/BinaryTrees 21

echo 'Warmup FannkuchRedux benchmark'

java -cp generated javabenchmarks/FannkuchRedux 7
java -cp generated javabenchmarks/FannkuchRedux 7
java -cp generated javabenchmarks/FannkuchRedux 7

echo 'Warmup Fasta benchmark'

java -cp generated javabenchmarks/Fasta 25000000
java -cp generated javabenchmarks/Fasta 25000000
java -cp generated javabenchmarks/Fasta 25000000

echo 'Warmup Mandelbrot benchmark'

java -cp generated javabenchmarks/Mandelbrot 16000
java -cp generated javabenchmarks/Mandelbrot 16000
java -cp generated javabenchmarks/Mandelbrot 16000

echo 'Warmup NBody benchmark'

java -cp generated javabenchmarks/NBody 50000000
java -cp generated javabenchmarks/NBody 50000000
java -cp generated javabenchmarks/NBody 50000000

echo 'Warmup SpectralNorm benchmark'

java -cp generated javabenchmarks/SpectralNorm 5500
java -cp generated javabenchmarks/SpectralNorm 5500
java -cp generated javabenchmarks/SpectralNorm 5500

echo 'End of benchmark'