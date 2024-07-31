package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    private Properties prop;

    public PropertyFileReader(String filePath) {
        prop = new Properties();
        loadProperties(filePath);
    }

    private void loadProperties(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            prop.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading properties file: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }


}
