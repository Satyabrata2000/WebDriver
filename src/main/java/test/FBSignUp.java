package test;

import net.bytebuddy.implementation.bind.annotation.This;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FBSignUp {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverProject\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        WebElement CreateNewAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        CreateNewAccount.click();

        WebElement FirstName = driver.findElement(By.xpath("//input[@aria-label='First name']"));
        WebElement LastName = driver.findElement(By.xpath("//input[@aria-label='Last name']"));
        WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        WebElement ReEnterEmail = driver.findElement(By.cssSelector("input[aria-label^='Re-enter']"));


        FirstName.sendKeys("abc");
        LastName.sendKeys("xyz");
        Email.sendKeys("email@email.com");
        Password.sendKeys("355RD@hgf#");
        ReEnterEmail.sendKeys("email@email.com");

        String strGender = "Female";
        //input[@value='1']
        //input[@value='2']
        //input[@value='-1']

        //label[text()='Male']/following-sibling::input
        //label[text()='Female']/following-sibling::input
        //label[text()='Custom']/following-sibling::input

        String genXpath = "//label[text()='" + strGender + "']/following-sibling::input";
        WebElement gen = driver.findElement(By.xpath(genXpath));
        gen.click();

        List<WebElement> Months = driver.findElements(By.xpath("//select[@title='Month']/option"));

        for(WebElement elm : Months){
            System.out.println(elm.getText());
        }

        WebElement CurrMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));

        System.out.println("Current Month " + CurrMonth.getText());

        WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
        Select ddDay = new Select(Day);
        ddDay.selectByVisibleText("25");


        WebElement Month=driver.findElement(By.xpath("//select[@id='month']"));
        Select ddMonth = new Select(Month);
        ddMonth.selectByVisibleText("Jul");
        //Select Month = new Select(driver.findElement(By.name("birthday_month")));
        //Select ddMonth = (Select) driver.findElement(By.xpath("//select[@id='month']"));
        //Thread.sleep(2000);


        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        Select ddYear = new Select(Year);
        ddYear.selectByVisibleText("2000");
        //Select Year = new Select(driver.findElement(By.name("birthday_year")));
        //Thread.sleep(2000);
        //Select ddYear = (Select) driver.findElement(By.xpath("//select[@id='year']"));



    }
}
