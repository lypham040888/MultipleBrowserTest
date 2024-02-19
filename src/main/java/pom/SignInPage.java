package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonActions;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Properties
	CommonActions common = new CommonActions();
	By txtEmail = By.name("email");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");
	By alertMessage = By.xpath("//div[@class='alert alert-danger']");

	// Action or method

	public void clickLogin(String user, String pass) {
		WebElement username = driver.findElement(txtEmail);
		common.sendKeys(username, user);
		WebElement password = driver.findElement(txtPassword);
		common.sendKeys(password, pass);
		WebElement login = driver.findElement(btnLogin);
		common.click(login);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void checkDisplayAlert() {
		WebElement divAlert = driver.findElement(alertMessage);
		assertEquals(divAlert.isDisplayed(), true);
	}
}
