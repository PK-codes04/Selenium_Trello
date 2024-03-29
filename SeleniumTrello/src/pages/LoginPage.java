package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element = null;

	public static WebElement loginb (WebDriver driver) {
		// TODO Auto-generated method stub
		element = driver.findElement(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
		return element;
	}
	
	public static WebElement user (WebDriver driver) {
		// TODO Auto-generated method stub
		 element = driver.findElement(By.xpath("//input[@id='username']"));
		return element;
	}
	public static WebElement continue1 (WebDriver driver) {
		// TODO Auto-generated method stub
		 element = driver.findElement(By.xpath("//span[normalize-space()='Continue']"));
		return element;
	}
	public static WebElement password (WebDriver driver) {
		// TODO Auto-generated method stub
		 element = driver.findElement(By.name("password"));
		return element;
	}
	public static WebElement loginMain (WebDriver driver) {
		// TODO Auto-generated method stub
		 element = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));
		return element;
	}
}
