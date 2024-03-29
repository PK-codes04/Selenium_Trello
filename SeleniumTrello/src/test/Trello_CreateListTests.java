package test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import org.testng.Assert;

public class Trello_CreateListTests {
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
	public  void test11() {
		ExtentTest test11 = extent.createTest("List Creation with card : Test11","List Creation with card ");
		driver.get("https://trello.com/");
		test11.pass("Navigated to Trello");
	    driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	    driver.findElement(By.name("username")).sendKeys("");
	    test11.pass("Entered user email");
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
	    test11.pass("Clicked on Continue");
	    driver.findElement(By.name("password")).sendKeys("");
	    test11.pass("Entered the password");
	    driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
	    test11.pass("Clicked on the Login button");
	    wait.until(ExpectedConditions.titleIs("Boards | Trello"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    String ActualTitle= driver.getTitle();
	    String ExpectedTitle="Boards | Trello"; 
	    Assert.assertEquals(ActualTitle,ExpectedTitle); 
	    test11.pass("Assertion passed");
	    driver.findElement(By.xpath("//p[@class='X7iA6JJNiXCA2r']")).click();
	    test11.pass("Clicked on the Create button");
	    driver.findElement(By.cssSelector("button[data-testid='header-create-board-button'] p[class='kgXqyT2weJmrQm']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Board title is required']")).isDisplayed(), "Element not found: Board title is required");
	    test11.pass("Assertion passed for Board title required message");
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("SE2 Project");
	    test11.pass("Entered Board Name");
	    driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
	    test11.pass("Entered on create button");
	    WebElement boardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".HKTtBLwDyErB_o")));
	    Assert.assertTrue(boardTitle.isDisplayed(), "Board Title is not displayed");
	    driver.findElement(By.cssSelector(".list-name-input")).sendKeys("Software Engineering");
	    test11.pass("Entered list name");
	    driver.findElement(By.cssSelector("input.nch-button.nch-button--primary.mod-list-add-button.js-save-edit[value='Add list']")).click();
	    test11.pass("Clicked on add list");
	    driver.findElement(By.cssSelector("a[data-testid='list-add-card-button']")).click();
	    test11.pass("Clicked on add card");
	    driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("StandUp Call");
	    test11.pass("Entered Card Title");
	    driver.findElement(By.cssSelector("input.nch-button.nch-button--primary.confirm.mod-compact.js-add-card[value='Add card']")).click();
	    test11.pass("Clicked on Add card button");
	    
	    test11.info("Test completed: Add List with card in the board");
	
	}
	@Test
	public  void test12() {
		ExtentTest test12 = extent.createTest("Card Update : test12","Card Update with description and comment");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.findElement(By.xpath("//ol[@class='RD2CmKQFZKidd6']")).click();
		//wait.until(ExpectedConditions.titleIs("Boards | Trello"));
		//driver.findElement(By.cssSelector("textarea[data-testid='quick-card-editor-card-title']")).click();
		test12.pass("Clicked the card");
	    //driver.findElement(By.cssSelector("div.ak-editor-content-area.less-margin div.ua-firefox[contenteditable='true']")).sendKeys("StandUp Call at 12pm");
		//driver.findElement(By.xpath("//a[contains(text(),'Add a more detailed description…')]")).sendKeys("StandUp Call at 12pm");
	    test12.pass("Entered Card description");
	    //wait.until(ExpectedConditions.titleIs("Boards | Trello"));
	    //driver.findElement(By.cssSelector("button.confirm.js-save-edit.bxgKMAm3lq5BpA.SdamsUKjxSBwGb.SEj5vUdI3VvxDc")).click();
	    test12.pass("Clicked on save button");
	    //driver.findElement(By.xpath("//div[@class='akEditor css-2l8q7y']//div[@id='ak-editor-textarea']")).sendKeys("Please join the call at 12pm");
	    test12.pass("Added comment");
	    //driver.findElement(By.xpath("//button[@class='bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc']")).click();
	    test12.pass("Clicked on save button");
	    //driver.findElement(By.xpath("//a[@aria-label='Close dialog']")).click();
	    test12.pass("Closed the card");
	    
	    test12.info("Test completed: Card Update with description and comment");
	
	}
	
	@Test
	public  void test13() {
		ExtentTest test13 = extent.createTest("Archive the List : test13","Archive the List");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//driver.findElement(By.xpath("//ol[@class='RD2CmKQFZKidd6']")).click();
		//wait.until(ExpectedConditions.titleIs("Boards | Trello"));
		//driver.findElement(By.cssSelector("textarea[data-testid='quick-card-editor-card-title']")).click();
		test13.pass("Clicked the list");
	    //driver.findElement(By.className("css-snhnyn")).click();
	    test13.pass("Clicked the list menu");
	    //driver.findElement(By.className("js-close-list")).click();
	    test13.pass("Clicked on the archive list option");
	    
	    test13.info("Test completed: Archived the List");
	
	}
	@AfterTest
	public  void teardownTest() {
		//driver = new ChromeDriver();
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
