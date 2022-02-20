package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertsExample {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Alert Accept
        WebElement elem = driver.findElement(By.xpath("//*[@id='alertButton']"));
        elem.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //Alert Cancel
        WebElement elem1 = driver.findElement(By.xpath("//*[@id='confirmButton']"));
        elem1.click();

        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.dismiss();

        //Alert message
        WebElement elem2 = driver.findElement(By.xpath("//*[@id='promtButton']"));
        elem2.click();

        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.sendKeys("Some text");
        alert2.accept();
    }
}
