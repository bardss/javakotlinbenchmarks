#!/bin/bash

echo "Start scanning jars "$2

export PACKAGES=$1
export RESULTPATH=results

export NAME=$2
export JAR=./jarfiles/$NAME.jar
export FREQINLINESIZE=results/freqInlineSize_$NAME.csv
export SEQUENCE2=results/sequence2_$NAME.csv
export SEQUENCE3=results/sequence3_$NAME.csv
export SEQUENCE4=results/sequence4_$NAME.csv
export SEQUENCE5=results/sequence5_$NAME.csv
export INVOKECOUNT=results/invokeCount_$NAME.csv
export ALLOCATIONCOUNT=results/allocationCount_$NAME.csv
export NEXTINSTRUCTIONFREQ=results/nextInstruction_$NAME.csv
export INSTRUCTIONCOUNT=results/instructionCount_$NAME.csv

./jarScan.sh --mode=maxMethodSize --limit=325 --packages=$PACKAGES $JAR > $FREQINLINESIZE
./jarScan.sh --mode=sequenceCount --length=2  --packages=$PACKAGES $JAR > $SEQUENCE2
./jarScan.sh --mode=sequenceCount --length=3  --packages=$PACKAGES $JAR > $SEQUENCE3
./jarScan.sh --mode=sequenceCount --length=4  --packages=$PACKAGES $JAR > $SEQUENCE4
./jarScan.sh --mode=sequenceCount --length=5  --packages=$PACKAGES $JAR > $SEQUENCE5
./jarScan.sh --mode=invokeCount               --packages=$PACKAGES $JAR > $INVOKECOUNT
./jarScan.sh --mode=allocationCount           --packages=$PACKAGES $JAR > $ALLOCATIONCOUNT 
./jarScan.sh --mode=nextInstructionFreq       --packages=$PACKAGES $JAR > $NEXTINSTRUCTIONFREQ
./jarScan.sh --mode=instructionCount          --packages=$PACKAGES $JAR > $INSTRUCTIONCOUNT

echo "End scanning jars "$2
