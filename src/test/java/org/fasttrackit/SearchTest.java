package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class SearchTest {


    @Test
    public void searchByOneKeywordTest() {

        System.setProperty("webdriver.chrome.driver",AppConfig.getChromeDriverPath());

        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());

        Header header = PageFactory.initElements(driver, Header.class);

        String keyword = "vase";

        header.search(keyword);

     //   driver.findElement(By.className ("input-text")).sendKeys("shirt");
     //   driver.findElement(By.tagName("button")).click();

      //  driver.findElement(By.linkText("WOMEN")).click();

        ProductGrid productsGrid = PageFactory.initElements(driver, ProductGrid.class);



        for (WebElement container : productsGrid.getProductNameContainers()){
            String productName = container.getText();


            assertThat("Some of the product names do not contain the searched keyword",
                    productName, containsString(keyword.toUpperCase()));
        }



    }
}
