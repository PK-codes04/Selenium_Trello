package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects {
	
	WebDriver driver = null;

	By loginb_first_page = By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']");
	By user_email = By.xpath("//input[@id='username']");
	By continue1 = By.xpath("//span[normalize-space()='Continue']");
	By password = By.name("password");
	By loginMain = By.xpath("//span[normalize-space()='Log in']");
	
	public LoginPageObjects(WebDriver driver) {	
		this.driver = driver ;
	}
	
	public void clickOnLoginB () {
		driver.findElement(loginb_first_page).click();
	}
	
	public void enterUserEmail(String text) {
		driver.findElement(user_email).sendKeys(text);
	}
	
	public void pressContinue() {
		driver.findElement(continue1).click();
	}
	
	public void enterPassword(String text) {
		driver.findElement(password).sendKeys(text);
	}
	public void pressLogin() {
		driver.findElement(loginMain).click();
	}
}
