package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import common.CommonActions;

public class SignInPageFactory extends BasePageFactory {

	public SignInPageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Properties

	CommonActions common = new CommonActions();
	@FindBy(name = "email")
	@CacheLookup
	WebElement username;
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement divAlert;

	// Action or method

	public void clickLogin(String user, String pass) {
		common.sendKeys(username, user);
		common.sendKeys(password, pass);
		common.click(btnLogin);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void checkDisplayAlert() {
		assertEquals(divAlert.isDisplayed(), true);
	}

}