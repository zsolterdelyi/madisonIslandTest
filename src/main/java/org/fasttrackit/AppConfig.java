package org.fasttrackit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();

    static {
        String environment = System.getProperty("env", "production");
        InputStream inputStream =
                AppConfig.class.getClassLoader()
                        .getResourceAsStream(environment + ".properties");

        try {
            properties.load(inputStream);
        } catch (IOException e){
            System.out.println("Failed to load properties file");
        }

    }

    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = properties.getProperty("gecko.driver.path");

    public static String getSafariDriverPath() {
        return safariDriverPath;
    }

    private static String safariDriverPath = properties.getProperty("safari.driver.path");

    private static String siteUrl = properties.getProperty("site.url");

    private static String timeout = properties.getProperty("timeout");

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }

    public static int getTimeOut (){

        return Integer.parseInt(timeout);
    }
}
