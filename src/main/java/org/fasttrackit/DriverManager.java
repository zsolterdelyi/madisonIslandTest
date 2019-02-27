package org.fasttrackit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver initDriver(String browser){

        switch (browser.toLowerCase()) {
            default:
                System.out.println("Creating default driver for Chrome...");
            case "chrome":
              //  if(System.setProperty("os.name").toLowerCase().contains("Windows"))


                System.setProperty("webdriver.chrome.driver",AppConfig.getChromeDriverPath());
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver",AppConfig.getGeckoDriverPath());
                driver = new FirefoxDriver();
                break;

            case "safari":
                System.setProperty("webdriver.safari.driver",AppConfig.getSafariDriverPath());
                driver = new SafariDriver();
                break;

        }

        driver.manage().timeouts().implicitlyWait(AppConfig.getTimeOut(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(AppConfig.getTimeOut(),TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeOut(),TimeUnit.SECONDS);

        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
