package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationReader {
    private static Properties config;
    static
    {
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = new FileInputStream("configuration.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        config=new Properties();
        try {
            config.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
public static String getProperties(String str){ return config.getProperty(str);}

}
