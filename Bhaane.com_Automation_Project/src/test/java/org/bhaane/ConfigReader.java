package org.bhaane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties userProperties;
    private static final Properties shopProperties;
    public static String getUserProperty(String key) {
        return userProperties.getProperty(key);
    }
    public static String getShopProperty(String key) {
        return shopProperties.getProperty(key);
    }

    static {
        userProperties = new Properties();
        try (InputStream input1 = new FileInputStream("env/Bhaane/user.properties")) {
            userProperties.load(input1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static {
        shopProperties = new Properties();
        try (InputStream input1 = new FileInputStream("env/Bhaane/shop.properties")) {
            shopProperties.load(input1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
