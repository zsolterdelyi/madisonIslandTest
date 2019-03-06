package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductGrid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SearchTest extends TestBase {

private String keyword;

    public SearchTest(String keyword) {
        this.keyword = keyword;
    }

    @Parameterized.Parameters
    public static List<String> imputData(){

        return Arrays.asList("vase", "camera");

    }



    @Test
    public void searchByOneKeywordTest() {
        Header header = PageFactory.initElements(driver, Header.class);
        waitForPageToLoad(1500);

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
