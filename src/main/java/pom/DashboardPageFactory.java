package pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;

public class DashboardPageFactory extends BasePageFactory {
	WebDriver driver;
	CommonActions common = new CommonActions();

	public DashboardPageFactory(WebDriver driver) {
		// this.driver = driver;
		// PageFactory.initElements(driver, this);
		super(driver);
	}

	@FindBy(xpath = "//span[@class='user-name ml10']")
	WebElement userLogged;

	public boolean checkExistedUserName() {
		boolean isExisted = false;
		try {
			common.takeScreenShotElement(driver, userLogged);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userLogged.isDisplayed()) {
			isExisted = true;
		}
		return isExisted;
	}

	public String getUserLogged() {
		String userLoggedName = "";
		userLoggedName = userLogged.getText();
		return userLoggedName;
	}

	public void clickClientLink() {
	}
}
