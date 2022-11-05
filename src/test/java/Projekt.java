import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Projekt {

    static WebDriver driver;

    @BeforeAll
    static void prepareBrouser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterAll
    static void closeBrouser() {
        driver.quit();
    }

    @Test
    void zad1(){
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        WebElement email= driver.findElement(By.xpath("//input[@id ='email']"));
        WebElement password= driver.findElement(By.xpath("//input[@id = 'passwd']"));
        WebElement submit= driver.findElement(By.xpath("//button[@id = 'SubmitLogin']"));

        email.sendKeys("");
        password.sendKeys("qaz1!QAZ");
        submit.click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class = 'alert alert-danger']")).isDisplayed());
    }

    @Test
    void zad2(){
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        WebElement email= driver.findElement(By.xpath("//input[@id ='email']"));
        WebElement password= driver.findElement(By.xpath("//input[@id = 'passwd']"));
        WebElement submit= driver.findElement(By.xpath("//button[@id = 'SubmitLogin']"));

        email.sendKeys("test@softie.pl");
        password.sendKeys("");
        submit.click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class = 'alert alert-danger']")).isDisplayed());
    }

    @Test
    public void zad3() {

        Boolean var1logo = driver.findElement(By.cssSelector("#header_logo")).isDisplayed();
        Boolean var1search = driver.findElement(By.xpath("//input[@id = 'search_query_top']")).isDisplayed();
        driver.findElement(By.xpath("//a[@class = 'login']")).click();
        Boolean var2logo = driver.findElement(By.cssSelector("#header_logo")).isDisplayed();
        Boolean var2search = driver.findElement(By.xpath("//input[@id = 'search_query_top']")).isDisplayed();
        if (var1logo==true || var2logo == true || var1search== true || var2search == true) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

    }

    @Test
    public void zad4(){
        driver.findElement(By.xpath("//div[@id ='contact-link']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@id = 'center_column']")).isDisplayed());
    }
//zablokować poprzednie
    @Test
    void zad5(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication");
        driver.findElement(By.cssSelector("#header_logo")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@id = 'center_column']")).isDisplayed());
    }

    @Test
    void zad6(){
        driver.findElement(By.xpath("//a[@class = 'sf-with-ul']")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'button ajax_add_to_cart_button btn btn-default']")));
        driver.findElement(By.xpath("//a[@class = 'button ajax_add_to_cart_button btn btn-default']")).click();
        driver.findElement(By.xpath("//a[@class ='btn btn-default button button-medium']")).click();


        Assertions.assertTrue(driver.findElement(By.xpath("//td[@class = 'cart_quantity text-center']")).isDisplayed());
    }

    @Test
     void zad7(){
        driver.findElement(By.xpath("//a[@class = 'sf-with-ul']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'button ajax_add_to_cart_button btn btn-default']")));
        driver.findElement(By.xpath("//a[@class = 'button ajax_add_to_cart_button btn btn-default']")).click();
        driver.findElement(By.xpath("//a[@class ='btn btn-default button button-medium']")).click();

        driver.findElement(By.xpath("//td[@class = 'cart_delete text-center']")).click();


        Assertions.assertTrue(driver.findElement(By.xpath("//p[@class = 'alert alert-warning']")).isDisplayed());
    }
}
