#!/bin/bash

# Those scripts are using JarScan which is part of JITWatch. Check out repository on JITWatch Github for more information

echo "Start scanning ALL jars"

export KOTLINPACKAGES=kotlinbenchmarks.*
export JAVAPACKAGES=javabenchmarks.*


./scanScripts.sh $JAVAPACKAGES BinaryTreesJava
./scanScripts.sh $KOTLINPACKAGES BinaryTreesKtConv
./scanScripts.sh $KOTLINPACKAGES BinaryTreesKtIdiom
./scanScripts.sh $JAVAPACKAGES FannkuchReduxJava
./scanScripts.sh $KOTLINPACKAGES FannkuchReduxKtConv
./scanScripts.sh $KOTLINPACKAGES FannkuchReduxKtIdiom
./scanScripts.sh $JAVAPACKAGES FastaJava
./scanScripts.sh $KOTLINPACKAGES FastaKtConv
./scanScripts.sh $KOTLINPACKAGES FastaKtIdiom
./scanScripts.sh $JAVAPACKAGES MandelbrotJava
./scanScripts.sh $KOTLINPACKAGES MandelbrotKtConv
./scanScripts.sh $KOTLINPACKAGES MandelbrotKtIdiom
./scanScripts.sh $JAVAPACKAGES NBodyJava
./scanScripts.sh $KOTLINPACKAGES NBodyKtConv
./scanScripts.sh $KOTLINPACKAGES NBodyKtIdiom
./scanScripts.sh $JAVAPACKAGES SpectralNormJava
./scanScripts.sh $KOTLINPACKAGES SpectralNormKtConv
./scanScripts.sh $KOTLINPACKAGES SpectralNormKtIdiom

echo "End scanning ALL jars
