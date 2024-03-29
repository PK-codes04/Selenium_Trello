package test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Trello_WorkspaceForTeamTests {
	ExtentSparkReporter spark;
	ExtentReports extent;
	WebDriver driver;
	WebDriverWait wait;
	//JavascriptExecutor js;
	
	
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
	     //js = (JavascriptExecutor) driver;
	}
	@Test
	public  void test14() {
		ExtentTest test14 = extent.createTest("CreateWorkspace : Test14","Workspace Creation");
		driver.get("https://trello.com/");
		test14.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("");
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    driver.findElement(By.name("password")).sendKeys("");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    wait.until(ExpectedConditions.titleIs("Boards | Trello"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    String ActualTitle= driver.getTitle();
	    String ExpectedTitle="Boards | Trello"; 
	    Assert.assertEquals(ActualTitle,ExpectedTitle); 
	    driver.findElement(By.xpath("//button[@aria-label='Create a Workspace']//span[@class='icon-add icon-sm _BwhWIRGqM8j8m']")).click();
	    test14.pass("Clicked on add workspace");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]")).sendKeys("UTA Software Engineering");
	    test14.pass("Entered Workspace Name");
	    WebElement dropdown = driver.findElement(By.className("css-1og2rpm"));
	    dropdown.click();
	    test14.pass("Clicked on dropdown to select workspace type");
	    Actions ac = new Actions(driver);
	    ac.sendKeys(Keys.ENTER).build().perform();
	    WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
	    submit.click();
	    driver.findElement(By.xpath("//a[normalize-space()=\"I'll do this later\"]")).click();
	    test14.info("Test completed: Workspace Created Successfully");
		
		
	}
	
	@Test
	public  void test15() {
		ExtentTest test15 = extent.createTest("Workspace Privacy: test15","Workspace Privacy change");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.xpath("//span[@class='see8N96uJ7JSJZ']")).click();
		test15.pass("Clicked on Workspace settings");
		driver.findElement(By.xpath("//span[@class='BmRHtH7FIX0jcL'][normalize-space()='Workspace settings']")).click();
		test15.pass("Clicked on Workspace settings");
		driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Change']")).click();
		test15.pass("Clicked on change button");
		driver.findElement(By.xpath("//p[contains(text(),\"This Workspace is public. It's visible to anyone w\")]")).click();
		test15.pass("Clicked on public button");
		test15.info("Test completed: Workspace Privacy changed");
		
		
	}
	@Test
	public  void test16() {
		ExtentTest test16 = extent.createTest("Workspace Invite Members: test16","Workspace Invite Members");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.xpath("//button[@class='js-invite-team-members nch-button nch-button--primary']")).click();
		test16.pass("Clicked on Invite Workspace members");
		driver.findElement(By.xpath("//input[@placeholder='Email address or name']")).sendKeys("pranali.khose45@gmail.com");
		test16.pass("Entered Email");
		Actions bc = new Actions(driver);
	    bc.sendKeys(Keys.ENTER).build().perform();
	    driver.findElement(By.xpath("//span[normalize-space()='Send invite']")).click();
	    test16.pass("Send Invite Button");
		test16.info("Test completed: Invitation sent to a memeber");
		
		
	}
	@Test
	public  void test17() {
		//Actions actions = new Actions(driver);
		ExtentTest test17 = extent.createTest("Workspace Deletion: test17","Workspace Deletion");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete this Workspace?']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", delete);
		//delete.click();
		//driver.findElement(By.xpath("//button[normalize-space()='Delete this Workspace?']")).click();
		test17.pass("Clicked Delete the workspace link");
		driver.findElement(By.xpath("//input[@id='confirmWorkspaceName']")).sendKeys("UTA Software Engineering");
		test17.pass("Entered workspace name to confirm");
	    driver.findElement(By.xpath("//button[normalize-space()='Delete Workspace']")).click();
	    test17.pass("Click on delete button");
	    test17.info("Test completed: Workspace Deleted");
		
		
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
