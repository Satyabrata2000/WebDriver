package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabExample {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        String ParentWin = driver.getWindowHandle();
        System.out.println("Before clicking new button: " + ParentWin);

        WebElement element = driver.findElement(By.xpath("//button[@id='tabButton']"));
        element.click();

        System.out.println("After clicking new button");

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();

        while(itr.hasNext()){

            String currentVal = itr.next();
            System.out.println(currentVal);

            if(!currentVal.equals(ParentWin)){
                driver.switchTo().window(currentVal);
            }
        }
        WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println(heading.getText());
        //driver.close();

        driver.switchTo().window(ParentWin);
        System.out.println("Back to parent window");
        //driver.close();
        //driver.quit();
    }
}
