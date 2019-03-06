package resultswriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultsWriterJava {

    private String resultsFileName = "results.txt";

    public void writeResultsToFile(String key, Long value) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFileName, true));
            String dateTimeNowText = getTextTimestamp();
            writer.write(dateTimeNowText);
            writer.newLine();
            writer.write(key + ": " + value);
            writer.newLine();
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTextTimestamp() {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss");
        return dateTimeNow.format(formatter);
    }
}
