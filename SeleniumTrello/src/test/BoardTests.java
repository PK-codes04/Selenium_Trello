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

public class BoardTests {
	ExtentSparkReporter spark;
	ExtentReports extent;
	WebDriver driver;
	WebDriverWait wait;
	private int boardCounter = 1;
	
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
	     wait = new WebDriverWait(driver, Duration.ofSeconds(200));
	}
	@Test
	public  void test5() {
		String boardName = "My_Board_" + boardCounter;
		boardCounter++;
		ExtentTest test5 = extent.createTest("CreateBoard : Test5","Board Creation");
		driver.get("https://trello.com/");
		test5.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("enter valid email");
	    test5.pass("Entered user email");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    test5.pass("Clicked on Continue");
	    driver.findElement(By.name("password")).sendKeys("password");
	    test5.pass("Entered the password");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    test5.pass("Clicked on the Login button");
	    wait.until(ExpectedConditions.titleIs("Boards | Trello"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    String ActualTitle= driver.getTitle();
	    String ExpectedTitle="Boards | Trello"; 
	    Assert.assertEquals(ActualTitle,ExpectedTitle); 
	    test5.pass("Assertion passed");
	    driver.findElement(By.xpath("//p[@class='X7iA6JJNiXCA2r']")).click();
	    test5.pass("Clicked on the Create button");
	    driver.findElement(By.cssSelector("button[data-testid='header-create-board-button'] p[class='kgXqyT2weJmrQm']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Board title is required']")).isDisplayed(), "Element not found: Board title is required");
	    test5.pass("Assertion passed for Board title required message");
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(boardName);
	    test5.pass("Entered Board Name");
	    driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
	    test5.pass("Entered on create button");
	    WebElement boardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".HKTtBLwDyErB_o")));
	    Assert.assertTrue(boardTitle.isDisplayed(), "Board Title is not displayed");
	    test5.pass("Assertion pass to check board titile");

	    test5.info("Test completed: Board Created Successfully");
		
		
	}
	
	@Test
	public  void test6() {
		ExtentTest test6 = extent.createTest("Board Visibility : Test6","Change Board Visibiltiy");
	    WebElement visible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='OrganizationIcon']")));
	    visible.click();
	    test6.pass("click on visibiltiy icon");
	    driver.findElement(By.xpath("//p[contains(text(),'Anyone on the internet can see this board. Only bo')]")).click();
	    test6.pass("click on public option");
	    driver.findElement(By.cssSelector("button.oHQ8obc2i5j1_X.bxgKMAm3lq5BpA.SdamsUKjxSBwGb.PnEv2xIWy3eSui.SEj5vUdI3VvxDc")).click();
	    test6.pass("click yes make board public button");
	    String expcted = "This board is set to public. You can change its visibility at any time.";
	    WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'This board is set to public. You can change its vi')]")));
	    String act = msg.getText();
	    Assert.assertEquals(expcted, act);
	    test6.pass("Message Assertion passed");
	    
	  
	    test6.info("Test completed: Board Visibility changed Successfully");
	    
	}
	@Test
	public  void test7() {
		ExtentTest test7 = extent.createTest("DeleteBoard : test7","Board Deletion");
	    WebElement dots = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='nch-icon A3PtEe1rGIm_yL J2CpPoHYfZ2U6i fAvkXZrzkeHLoc']//span[@class='css-snhnyn']")));
	    dots.click();
	    driver.findElement(By.xpath("//a[@class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']")).click();
	    test7.pass("clicked on close board");
	    driver.findElement(By.xpath("//input[@value='Close']")).click();
	    test7.pass("clicked on close button");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.findElement(By.xpath("//button[normalize-space()='Permanently delete board']")).click();
	    test7.pass("clicked on Permanently delete board'");
	    driver.findElement(By.xpath("//button[@data-testid=\"close-board-delete-board-confirm-button\"]")).click();
	    test7.pass("clicked on delete button'");
	    test7.info("Test completed: Board Deleted Successfully");
	    
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
