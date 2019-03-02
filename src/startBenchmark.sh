#!/bin/bash

echo 'Executing benchmark suite'

echo 'Compile all Java benchmarks'

javac -d generated/java javabenchmarks/*.java

echo 'Compile all Kotlin benchmarks'

kotlinc kotlinbenchmarks/converted/BinaryTreesConverted.kt -include-runtime -d generated/kotlin/BinaryTreesConverted.jar
kotlinc kotlinbenchmarks/converted/FannkuchReduxConverted.kt -include-runtime -d generated/kotlin/FannkuchReduxConverted.jar
kotlinc kotlinbenchmarks/converted/FastaConverted.kt -include-runtime -d generated/kotlin/FastaConverted.jar
kotlinc kotlinbenchmarks/converted/MandelbrotConverted.kt -include-runtime -d generated/kotlin/MandelbrotConverted.jar
kotlinc kotlinbenchmarks/converted/NBodyConverted.kt -include-runtime -d generated/kotlin/NBodyConverted.jar
kotlinc kotlinbenchmarks/converted/SpectralNormConverted.kt -include-runtime -d generated/kotlin/SpectralNormConverted.jar

echo 'Warmup BinaryTrees benchmark'

java -cp generated/java javabenchmarks/BinaryTrees 21
java -cp generated/java javabenchmarks/BinaryTrees 21
java -cp generated/java javabenchmarks/BinaryTrees 21

echo 'Warmup FannkuchRedux benchmark'

java -cp generated/java javabenchmarks/FannkuchRedux 7
java -cp generated/java javabenchmarks/FannkuchRedux 7
java -cp generated/java javabenchmarks/FannkuchRedux 7

echo 'Warmup Fasta benchmark'

java -cp generated/java javabenchmarks/Fasta 25000000
java -cp generated/java javabenchmarks/Fasta 25000000
java -cp generated/java javabenchmarks/Fasta 25000000

echo 'Warmup Mandelbrot benchmark'

java -cp generated/java javabenchmarks/Mandelbrot 16000
java -cp generated/java javabenchmarks/Mandelbrot 16000
java -cp generated/java javabenchmarks/Mandelbrot 16000

echo 'Warmup NBody benchmark'

java -cp generated/java javabenchmarks/NBody 50000000
java -cp generated/java javabenchmarks/NBody 50000000
java -cp generated/java javabenchmarks/NBody 50000000

echo 'Warmup SpectralNorm benchmark'

java -cp generated/java javabenchmarks/SpectralNorm 5500
java -cp generated/java javabenchmarks/SpectralNorm 5500
java -cp generated/java javabenchmarks/SpectralNorm 5500

echo 'End of benchmark'