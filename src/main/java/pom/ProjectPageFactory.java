package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPageFactory extends BasePageFactory {

	public ProjectPageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[@class='user-name ml10']")
	WebElement lbbLoggedUser;

	public void checkLoggedUser(String user) {
		assertEquals(lbbLoggedUser.getText(), user);

	}

}
