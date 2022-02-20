package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //To count no of rows
        List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        System.out.println("Total no of rows are "+ tbRows.size());

        //To count no of columns
        List<WebElement> tbColumns = driver.findElements(By.xpath("//table[@id='customers']//th"));
        System.out.println("Total no of columns are " + tbColumns.size());

        //To extract data from 3rd row in the table
        List<WebElement> tbData = driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
        for(WebElement elm :tbData) {
            System.out.println(elm.getText());
        }
        //To extract data from the first column in the table
        List<WebElement> tbData2 = driver.findElements(By.xpath("//table[@id='customers']//td[1]"));
        for(WebElement elm :tbData2) {
            System.out.println(elm.getText());
        }

    }
}
