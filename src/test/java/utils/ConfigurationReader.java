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
            config=new Properties();
            config.load(fileInputStream);
            fileInputStream.close();
        } catch(Exception e){
            System.out.println("Failed to load the properties");
            e.printStackTrace();
        }
    }
public static String getProperties(String str){ return config.getProperty(str);}

}
