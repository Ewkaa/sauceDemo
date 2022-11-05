import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class excercise {



    @Test
    void emptyLoginField() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        passwordInput.sendKeys("Haslo123");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        //https://learngitbranching.js.org/?locale=pl
        driver.quit();
    }

    @Test
    void emptyPasswordField() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.saucedemo.com/");
        WebElement loginInput = driver.findElement(By.id("user-name"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        loginInput.sendKeys("loginTest");
        submitButton.click();
        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface: Password is required", errorBox.getText());
        driver.quit();
    }

    @Test
    public void pageSupport() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions builder = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement submitbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginInput.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        submitbutton.click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='bm-burger-button']")).isDisplayed());
        WebElement menubutton = driver.findElement(By.xpath("//div[@class='bm-burger-button']"));
        menubutton.click();
        WebElement aboutbutton = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
        aboutbutton.click();
        WebElement conctactbutton = driver.findElement(By.xpath("(//div[@data-hover-content='Contact']//a)[2]"));
        builder.moveToElement(conctactbutton);
        WebElement conctactsupportbutton = driver.findElement(By.xpath("(//span[text()='Contact Sales'])[2]"));
        builder.click(conctactsupportbutton);
        builder.perform();
        //conctactsupportbutton.click();
    }
}
