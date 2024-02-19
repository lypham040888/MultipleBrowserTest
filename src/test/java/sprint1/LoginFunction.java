package sprint1;

import org.testng.annotations.Test;

import common.CommonBrowser;
import pom.ProjectPage;
import pom.SignInPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginFunction {

	WebDriver driver;
	CommonBrowser browser;

	@BeforeMethod
	public void beforeMethod() {
		driver = browser.initChromeDriver(
				"https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/projects/all_projects");

	}

	@AfterMethod
	public void afterMethod() {
		browser.closeDriver(driver);

	}

	@Test
	public void Testcase1_CorrectUser() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickLogin("admin@demo.com", "riseDemo");
		ProjectPage project = new ProjectPage(driver);
		project.checkLoggedUser("John Doe");

	}

	@Test
	@Ignore
	public void Testcase2_InCorrectPassword() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickLogin("admin@demo.com", "riseDemo1");
		signInPage.checkDisplayAlert();
	}

	@Test
	@Ignore
	public void Testcase3_InCorrectEmail() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickLogin("admin@demo.com1", "riseDemo");
		signInPage.checkDisplayAlert();
	}

	@Test
	@Ignore
	public void Testcase4_InCorrectUser() {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clickLogin("admin@demo.com1", "riseDemo1");
		signInPage.checkDisplayAlert();
	}

	@BeforeTest
	public void beforeTest() {
		browser = new CommonBrowser();
		// driver = browser.initChromeDriver(
		// "https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/projects/all_projects");

	}

	@AfterTest
	public void afterTest() {
		// browser.quitDriver(driver);
	}

}
