package FirstTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
 
public class FirstTestClass {
   
    public static void main(String args[])
    {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
 
       driver.get("https://trello.com/");
       //Login button
       WebElement loginb = driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
       loginb.click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       //UserDetails
       
       WebElement username = driver.findElement(By.name("username"));
       username .sendKeys("jammy.khose@gmail.com");
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       WebElement continue1 =driver.findElement(By.xpath("//span[normalize-space()='Continue']"));
       continue1.click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       WebElement password = driver.findElement(By.name("password"));
       password .sendKeys("$PK12345678");
       WebElement login = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));
       login.click();
       //login.click(); String actualUrl="https://www.linkedin.com/feed/"; 
       //String expectedUrl= driver.getCurrentUrl(); if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
       //System.out.println("Test passed"); } else { System.out.println("Test failed"); } }   }
        
      
        
    }
}