package propertyutility;

import baselibary.BaseLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility  extends BaseLibrary
{

    static String location = System.getProperty("user.dir");
    static String path = location + "\\src\\test\\resources\\config.properties";

    public static String readData(String key) {
        String value = "";

        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);

        } catch (Exception e) {
            System.out.println("Issue in get read data+ e");
        }
        return value;
    }
}
