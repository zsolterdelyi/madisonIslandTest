package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ShoppingCartTest {

    @Test
    public void addToCartFromSearchResultsTest () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//test//resources//drivers//chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/sale.html");

        String keyword = "vase";

        driver.findElement(By.id("search")).sendKeys(keyword + Keys.ENTER);

        String searchedProductName = "Herald Glass Vase";


        driver.findElement(By.xpath(
                "//div[@class='product-info' and .//a[text() = '" + searchedProductName + "' ]]" +
                "//button[@title='Add to Cart']")).click();

       String succesMessage = driver.findElement(By.className("success-msg")).getText();

       assertThat("Unexpected succes message", succesMessage,
               is(searchedProductName + " was added to your shopping cart."));

        WebElement productNameInCart = driver.findElement(By.xpath(
                "//table [@id= 'shopping-cart-table']//a[text() = '" + searchedProductName + "']"));



    }

}
