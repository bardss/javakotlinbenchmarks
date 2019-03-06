package javabenchmarks.fannkuchredux;

import resultswriter.ResultsWriterJava;

public class FannkuchReduxExec {

    public static void main(final String[] args) throws Exception {
        String key = "Fannkuch Redux Java";
        Long startTime = System.nanoTime();
        FannkuchRedux.execute(args);
        Long endTime = System.nanoTime();
        if (!args[1].equals("warmup")) {
            Long result = endTime - startTime;
            ResultsWriterJava resultsWriter = new ResultsWriterJava();
            resultsWriter.writeResultsToFile(key, result);
        }
    }
}
