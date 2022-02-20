package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ScrollExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        WebElement element = driver.findElement(By.xpath("//h2[text()='Table Rows']"));
        JavascriptExecutor obj = (JavascriptExecutor) driver; //typecasting on the driver

        //Only one out of below 3 will work at any given point

        //Find the element on the page, scrollInto view function
        obj.executeScript("arguments[0].scrollIntoView();", element);

        //scroll down
        obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        //scroll up
        obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

    }
}
