package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	public void enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		}
	public void enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public void clickLoginButton() {
		driver.findElement(By.id("submit")).click();
	}
	public String getSuccessMessage() {
		return driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
	}
	
	public By getSuccessMessageLocator() {
		return By.xpath("//h1[@class='post-title']");
		
	}
}
