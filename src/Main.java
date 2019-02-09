import javabenchmarks.Fasta;
import kotlinbenchmarks.FastaConverted;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Long fastaJavaExecutionTime = 0L;
            Long fastaKotlinExecutionTime = 0L;
            int numberOfExecutions = 10000;

            for (int i = 0; i <= numberOfExecutions; i++) {
                Long startTime = System.nanoTime();
                Fasta.execute();
                Long endTime = System.nanoTime();
                fastaJavaExecutionTime += (endTime - startTime);
            }

            for (int i = 0; i <= numberOfExecutions; i++) {
                Long startTime = System.nanoTime();
                FastaConverted.execute();
                Long endTime = System.nanoTime();
                fastaKotlinExecutionTime += (endTime - startTime);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            writer.write("fastaJavaExecutionTime: " + fastaJavaExecutionTime + "\n");
            writer.write("fastaKotlinExecutionTime: " + fastaKotlinExecutionTime + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
