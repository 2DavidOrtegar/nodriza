package app.support.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Yaml {
    private static String pathFile;
    private static String basepath = "C:\\Users\\soportepc\\Documents\\QA\\gascox-caja-magallanes\\data\\";
    public Yaml(String tagFile) {
        pathFile = getPathFile(tagFile);
    }

    private String getPathFile(String tag) {
        HashMap<String, String> pathsFile = new HashMap<String, String>();
        pathsFile.put("pathlogs", basepath + "pathlogs.yml");
        pathsFile.put("config", basepath + "config.yml");

        return pathsFile.get(tag);
    }

    public Map<String, Map<String, String>> getFile() throws FileNotFoundException {

        org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();

        Map<String, Map<String, String>> values = yaml
                .load(new FileInputStream(new File(pathFile)));

        return values;

    }
}
