package javabenchmarks.nbody;

import resultswriter.ResultsWriterJava;

public class NBodyExec {

    public static void main(final String[] args) throws Exception {
        String key = "NBody Java";
        Long startTime = System.nanoTime();
        NBody.execute(args);
        Long endTime = System.nanoTime();
        if (!args[1].equals("warmup")) {
            Long result = endTime - startTime;
            ResultsWriterJava resultsWriter = new ResultsWriterJava();
            resultsWriter.writeResultsToFile(key, result);
        }
    }
}
