package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {


    protected WebDriver driver;

   //  WebDriverWait wait = new WebDriverWait("browser",5);

    @Before
    public void setup(){
        String browser = System.getProperty("browser","chrome");


        driver = DriverManager.initDriver(browser);
        driver.get(AppConfig.getSiteUrl());
        System.out.println("Opened homepage");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        driver.quit();

    }

    public void waitForPageToLoad(long timeoutMillis){

        do {
            long waitTime = 500;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(" Wait interrupted. " + e.getMessage());
            }
            timeoutMillis -= waitTime;
            System.out.println("Waiting for page load. Remaining millis: " + timeoutMillis);

        } while (timeoutMillis > 0 && !( (JavascriptExecutor) driver)
            .executeScript ("return document.readyState").equals ("complete"));

    }
}
