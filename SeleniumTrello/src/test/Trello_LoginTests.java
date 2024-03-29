package test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Trello_LoginTests {
	ExtentSparkReporter spark;
	ExtentReports extent;
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public  void setup() {
		spark = new ExtentSparkReporter("spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		

	}
	@BeforeTest
	public  void setupTest() {
		 driver = new FirefoxDriver();
	     driver.manage().window().maximize();
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public  void test1() {
		
		ExtentTest test1 = extent.createTest("Login : Test1","Trello Login Happy Path");
		driver.get("https://trello.com/");
	    test1.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("");
	    test1.pass("Entered user email");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    test1.pass("Clicked on Continue");
	    driver.findElement(By.name("password")).sendKeys("");
	    test1.pass("Entered the password");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    test1.pass("Clicked on the Login button");
	    wait.until(ExpectedConditions.titleIs("Boards | Trello"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    String ActualTitle= driver.getTitle();
	    String ExpectedTitle="Boards | Trello"; 
	    Assert.assertEquals(ActualTitle,ExpectedTitle); 
	    test1.pass("Assertion passed");
		test1.info("Test completed");
		
		
	}
	@Test
	public  void test2() {
		driver = new FirefoxDriver();
		ExtentTest test2 = extent.createTest("Login_Incorrect Password : Test2","Incorrect Password");
		driver.get("https://trello.com/");
	    test2.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("");
	    test2.pass("Entered user email");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    test2.pass("Clicked on Continue");
	    driver.findElement(By.name("password")).sendKeys("");
	    test2.pass("Entered the password");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    test2.pass("Clicked on the Login button");
	    String expcted = "Incorrect email address and / or password. If you recently migrated your Trello account to an Atlassian account, you will need to use your Atlassian account password. Alternatively, you can get help logging in.";
	    WebElement m = driver.findElement(By.xpath("//span[@class='css-xal9c7']"));
	    String act = m.getText();
	    Assert.assertEquals(expcted, act);
	    test2.pass("Assertion passed");
		test2.info("Test completed");
		
		
		
		
	}
	
	
	@Test
	public  void test3() {
		driver = new FirefoxDriver();
		ExtentTest test3 = extent.createTest("Login_Blank Password : Test3","Login_Blank Password");
		driver.get("https://trello.com/");
		test3.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("");
	    test3.pass("Entered user email");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    test3.pass("Clicked on Continue");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    test3.pass("Clicked on the Login button");
	    String expcted = "Enter your password";
	    WebElement m = driver.findElement(By.xpath("//span[@id='password-error']"));
	    String act = m.getText();
	    Assert.assertEquals(expcted, act);
	    test3.pass("Assertion passed");
	    test3.info("Test completed");
	    
		
		
	}
	
	@Test
	public  void test4() {
		driver = new FirefoxDriver();
		ExtentTest test4 = extent.createTest("Login_Logout : Test4","Trello Login_Logout Happy Path");
		driver.get("https://trello.com/");
		test4.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("");
	    test4.pass("Entered user email");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    test4.pass("Clicked on Continue");
	    driver.findElement(By.name("password")).sendKeys("");
	    test4.pass("Entered the password");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    test4.pass("Clicked on the Login button");
	    //wait.until(ExpectedConditions.titleIs("Boards | Trello"));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    //String ActualTitle= driver.getTitle();
	    //String ExpectedTitle="Boards | Trello"; 
	    //Assert.assertEquals(ActualTitle,ExpectedTitle); 
	    //test4.pass("Assertion passed");
	    driver.findElement(By.xpath("//span[@title='PK (jammykhose)']")).click();
	    test4.pass("Clicked on profile");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.xpath("//span[normalize-space()='Log out']")).click();
	    test4.pass("Clicked on Logout");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.xpath("//span[@class='css-178ag6o']")).click();
	    test4.pass("Logout Success");
	    test4.info("Test completed");
		
	}
	@AfterTest
	public  void teardownTest() {
		//driver = new FirefoxDriver();
		if (driver != null) {
            driver.quit();
		}
		
		System.out.println("Test Completed Successfully");
		
	}
	
	@AfterSuite
	public  void teardown() {
		
		extent.flush();
	}
}

