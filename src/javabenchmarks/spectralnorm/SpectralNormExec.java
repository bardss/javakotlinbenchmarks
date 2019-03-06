package javabenchmarks.spectralnorm;

import resultswriter.ResultsWriterJava;

public class SpectralNormExec {

    public static void main(final String[] args) throws Exception {
        String key = "SpectralNorm Java";
        Long startTime = System.nanoTime();
        SpectralNorm.execute(args);
        Long endTime = System.nanoTime();
        if (!args[1].equals("warmup")) {
            Long result = endTime - startTime;
            ResultsWriterJava resultsWriter = new ResultsWriterJava();
            resultsWriter.writeResultsToFile(key, result);
        }
    }
}
