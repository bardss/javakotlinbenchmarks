package javabenchmarks.mandelbrot;

import resultswriter.ResultsWriterJava;

public class MandelbrotExec {

    public static void main(final String[] args) throws Exception {
        String key = "Mandelbrot Java";
        Long startTime = System.nanoTime();
        Mandelbrot.execute(args);
        Long endTime = System.nanoTime();
        if (!args[1].equals("warmup")) {
            Long result = endTime - startTime;
            ResultsWriterJava resultsWriter = new ResultsWriterJava();
            resultsWriter.writeResultsToFile(key, result);
        }
    }
}
