package javabenchmarks.fasta;

import resultswriter.ResultsWriterJava;

public class FastaExec {

    public static void main(final String[] args) throws Exception {
        String key = "Fasta Java";
        Long startTime = System.nanoTime();
        Fasta.execute(args);
        Long endTime = System.nanoTime();
        if (!args[1].equals("warmup")) {
            Long result = endTime - startTime;
            ResultsWriterJava resultsWriter = new ResultsWriterJava();
            resultsWriter.writeResultsToFile(key, result);
        }
    }
}
