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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ShoppingCartTest {

    @Test
    public void addToCartFromSearchResultsTest () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//drivers//chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/sale.html");

        String keyword = "vase";

        driver.findElement(By.id("search")).sendKeys(keyword + Keys.ENTER);

        String productName = "Herald Glass Vase";


        ProductGrid productGrid = PageFactory.initElements(driver, ProductGrid.class);

        productGrid.addProductToCart(productName, driver);

       String succesMessage = driver.findElement(By.className("success-msg")).getText();

       assertThat("Unexpected succes message", succesMessage,
               is(productName + " was added to your shopping cart."));

        WebElement productNameInCart = driver.findElement(By.xpath(
                "//table [@id= 'shopping-cart-table']//a[text() = '" + productName + "']"));



    }

}
