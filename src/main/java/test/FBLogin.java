package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FBLogin {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverProject\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.30.0-win64\\geckodriver.exe");

        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

        WebElement UserName = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement Login = driver.findElement(By.xpath("//button[@name='login']"));

        UserName.sendKeys("abc123@abc.com");
        Password.sendKeys("abc123");
        Login.click();

        driver.close();
    }
}
