import java.io.BufferedWriter
import java.io.FileWriter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter



class ResultsWriter {

    fun writeResultsToFile(hashMap: HashMap<String, Long>){
        val writer = BufferedWriter(FileWriter("results.txt", true))
        val dateTimeNowText = getTextTimestamp()
        writer.write(dateTimeNowText)
        writer.newLine()
        hashMap.forEach { key, value ->
            writer.write("$key: $value\n")
        }
        writer.newLine()
        writer.newLine()
        writer.close()
    }

    private fun getTextTimestamp(): String? {
        val dateTimeNow = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss")
        return dateTimeNow.format(formatter)
    }

}