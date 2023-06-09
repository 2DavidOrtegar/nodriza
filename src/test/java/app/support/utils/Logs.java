package app.support.utils;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
public class Logs {
    Map<String, Map<String, String>> datayml;
    public Logs(){
    }

    public void writeLog(String logFilePath, String textLog) throws FileNotFoundException {
        Yaml yml = new Yaml("pathlogs");
        datayml = yml.getFile();
        System.out.println("RUTA::: " + datayml.get("pathlogs").get(logFilePath));

        String actualDate = String.valueOf(LocalDateTime.now());

        try(FileWriter fw = new FileWriter(String.valueOf(datayml.get("pathlogs").get(logFilePath)), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println();
            //more code
            out.println(actualDate + " | " + textLog);
            //more code
        } catch (IOException err) {
            //exception handling left as an exercise for the reader
        }

    }
}
