package javabenchmarks.binarytrees;

import resultswriter.ResultsWriterJava;

public class BinaryTreesExec {

    public static void main(final String[] args) throws Exception {
        String key = "BinaryTrees Java";
        Long startTime = System.nanoTime();
        BinaryTrees.execute(args);
        Long endTime = System.nanoTime();
        if (!args[1].equals("warmup")) {
            Long result = endTime - startTime;
            ResultsWriterJava resultsWriter = new ResultsWriterJava();
            resultsWriter.writeResultsToFile(key, result);
        }
    }
}
