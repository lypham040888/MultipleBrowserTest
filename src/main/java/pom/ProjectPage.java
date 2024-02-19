package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

	public ProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By loggedUser =  By.xpath("//span[@class='user-name ml10']");
	public void checkLoggedUser(String user)
	{
		WebElement lbbLoggedUser = driver.findElement(loggedUser);
		assertEquals(lbbLoggedUser.getText(), user);
		
	}

}
