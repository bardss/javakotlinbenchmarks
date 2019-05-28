#!/bin/bash

echo "Start scanning jars "$2

export PACKAGES=$1
export RESULTPATH=results

export NAME=$2
export JAR=./jarfiles/$NAME.jar
export ALLOCATIONCOUNT=results/allocationCount_$NAME.csv
export INSTRUCTIONCOUNT=results/instructionCount_$NAME.csv
export METHODSIZEHISTO=results/methodSizeHisto_$NAME.csv

./jarScan.sh --mode=allocationCount           --packages=$PACKAGES $JAR > $ALLOCATIONCOUNT 
./jarScan.sh --mode=instructionCount          --packages=$PACKAGES $JAR > $INSTRUCTIONCOUNT
./jarScan.sh --mode=methodSizeHisto 		  --packages=$PACKAGES $JAR > $METHODSIZEHISTO

echo "End scanning jars "$2
