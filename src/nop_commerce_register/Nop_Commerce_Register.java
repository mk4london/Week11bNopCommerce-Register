package nop_commerce_register;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Nop_Commerce_Register {
    WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void verify_User_On_Register_page() {
        // user click on register page
        driver.findElement(By.className("ico-register")).click();
        String expected_Result = "Register";
        WebElement message = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actual_Results = message.getText();
        // user enter first name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("vishal");
        // user enter last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("tailor");
        // user enter date of birth
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[1]")).sendKeys("1");
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[2]")).sendKeys("January");
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[3]")).sendKeys("1");
        // user enter email address
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("lkjjhgg@gmail.com");
        // company name
        driver.findElement(By.id("Company")).sendKeys("abcd ltd");
        // passowrd
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        // confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
        // click on register page
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        // registration completed
        String expected_Results = "Register";
        WebElement message1 = driver.findElement(By.xpath("//h1[text()='Register']"));

        String actual_Result = message1.getText();
        Assert.assertEquals("User not on  a Registration Page", actual_Result,expected_Results);


    }
    @After
    public void tearDown() {

        driver.quit();
    }



}
