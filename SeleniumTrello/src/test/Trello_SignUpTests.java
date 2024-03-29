package test;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
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

public class Trello_SignUpTests {
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
	     wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     //ebDriverWait wait = new WebDriverWait(driver, 30);
	}
	@Test
	public  void test8() {
		ExtentTest test8 = extent.createTest("SignUp_Blank Email Id: Test8","Blank Email Id");
		driver.get("https://trello.com/");
		test8.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//div[@class='grid__StyledColumn-sc-p40pqe-2 eXMZwc ui-column lg-text-left']//button[@aria-label='Sign up for Trello - it’s free!'][contains(text(),'Sign up - it’s free!')]")).click();
	    test8.pass("Clicked on signUp");
	    driver.findElement(By.xpath("//span[normalize-space()='Sign up']")).click();
	    test8.pass("Clicked on signUp");
	    String expcted = "Please enter an email address";
	    WebElement em = driver.findElement(By.xpath("//div[@id='email-uid2-error']"));
	    String act = em.getText();
	    Assert.assertEquals(expcted, act);
	    test8.pass("Assertion passed");
	    test8.info("Test completed: Blank Email Id error");
		
		
	}
	@Test
	public  void test9() {
		ExtentTest test9 = extent.createTest("SignUp_Invalid Email Id : Test9","Invalid Email Id");
		driver.get("https://trello.com/");
		test9.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//input[@class='UiEmailSignupstyles__InputEmail-sc-9nggyw-1 ZIPtJ']")).sendKeys("@123");
	    test9.pass("Entered the Invalid email Id");
	    driver.findElement(By.xpath("//div[@class='grid__StyledColumn-sc-p40pqe-2 eXMZwc ui-column lg-text-left']//button[@aria-label='Sign up for Trello - it’s free!'][contains(text(),'Sign up - it’s free!')]")).click();
	    String expcted = "";
	    WebElement ms = driver.findElement(By.xpath("//div[@class=\"UiSpacerstyles__Spacer-sc-3m9z76-0 jAuYNL\"]"));
	    String act = ms.getText();
	    Assert.assertEquals(expcted, act);
	    test9.pass("Assertion passed");
	    test9.info("Test completed: Invalid Email Id error");
		
		
	}
	@Test
	public  void test10() {
		String email = "pranalikhose133@gmail.com";
		ExtentTest test10 = extent.createTest("SignUp : Test10","SignUp Happy Path");
		driver.get("https://trello.com/");
		test10.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 Buttonsstyles__PrimaryButton-sc-1jwidxo-1 kTwZBr lhSFdZ']")).click();
	    test10.pass("Clicked on signup");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	    test10.pass("Entered an email");
	    driver.findElement(By.xpath("//span[normalize-space()='Sign up']")).click();
	    driver.findElement(By.xpath("//h5[normalize-space()='Check your inbox to log in']"));
	    test10.fail("Captcha automation is not recommended");
	    test10.info("Test completed: SignUp");
	    
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
