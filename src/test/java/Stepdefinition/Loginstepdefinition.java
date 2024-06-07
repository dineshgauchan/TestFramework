package Stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Loginstepdefinition {
	private WebDriver driver;
	private LoginPage loginPage;

@Before
public void setUp () {
	System.setProperty("webdriver.chrome.driver",".\\src\\test\\java\\Libraries\\chromedriver.exe");
	driver = new ChromeDriver();
	loginPage = new LoginPage(driver);
	driver.manage().window().maximize();
}
@Given ("I am on the login page")
public void iAmOnTheLoginPage() {
	driver.get("https://practicetestautomation.com/practice-test-login/");
}

@When("I enter username {string} password {string}")
public void iEnterUsernameAndPassword(String username, String password) {
	loginPage.enterUsername(username);
	loginPage.enterPassword(password);
}
@And("I click on the login button")
public void iClickOnLoginButton () {
	loginPage.clickLoginButton ();
}

@Then("I should see the welcome message")
public void i_should_see_the_welcome_message() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSuccessMessageLocator()));
	
	String successMessage = loginPage.getSuccessMessage();
	
	Assert.assertEquals("Logged In Successfully", successMessage);
	
	System.out.println("Login successful!");
}
@After
public void tearDown() {
	driver.quit();
}	
}

