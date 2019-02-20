package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class SearchTest {


    @Test
    public void searchByOneKeywordTest() {

        System.setProperty("webdriver.chrome.driver",AppConfig.getChromeDriverPath());

        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());

        String keyword = "vase";

        driver.findElement(By.id("search")).sendKeys(keyword + Keys.ENTER);

     //   driver.findElement(By.className ("input-text")).sendKeys("shirt");
     //   driver.findElement(By.tagName("button")).click();

      //  driver.findElement(By.linkText("WOMEN")).click();

        List<WebElement> productNameContainers =
                driver.findElements(By.cssSelector(".product-name > a"));

        for (WebElement container : productNameContainers){
            String productName = container.getText();


            assertThat("Some of the product names do not contain the searched keyword",
                    productName, containsString(keyword.toUpperCase()));
        }



    }
}
