package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {

        try {
            // location + name of the file
            String path = "Configuration.properties";
            // FileInputStream --> read files in format that java understands
            FileInputStream input = new FileInputStream(path);

            // properties --> object which will contain the values from the configuration properties file
            properties = new Properties();

            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    // returns the value of property given as keyName
    // returns null if the key does not exist
    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}

