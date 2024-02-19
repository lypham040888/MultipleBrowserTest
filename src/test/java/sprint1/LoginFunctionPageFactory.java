package sprint1;

import org.testng.annotations.Test;

import common.CommonBrowser;
import pom.ProjectPage;
import pom.ProjectPageFactory;
import pom.SignInPage;
import pom.SignInPageFactory;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterTest;

public class LoginFunctionPageFactory {
	WebDriver driver;
	CommonBrowser browser;

	@BeforeMethod
	public void beforeMethod() {
		driver = browser.initEdgeDriver(
				"https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/projects/all_projects");

	}

	@AfterMethod
	public void afterMethod() {
		browser.closeDriver(driver);

	}

	@Test
	public void Testcase1_CorrectUser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		
		SignInPageFactory signInPageFactory = new SignInPageFactory(driver);
		signInPageFactory.clickLogin("admin@demo.com", "riseDemo");
		ProjectPageFactory project = new ProjectPageFactory(driver);
		project.checkLoggedUser("John Doe");

	}

	@Test
	@Ignore
	public void Testcase2_InCorrectPassword() {
		SignInPageFactory signInPage = new SignInPageFactory(driver);
		signInPage.clickLogin("admin@demo.com", "riseDemo1");
		signInPage.checkDisplayAlert();
	}

	@Test
	@Ignore
	public void Testcase3_InCorrectEmail() {
		SignInPageFactory signInPage = new SignInPageFactory(driver);
		signInPage.clickLogin("admin@demo.com1", "riseDemo");
		signInPage.checkDisplayAlert();
	}

	@Test
	@Ignore
	public void Testcase4_InCorrectUser() {
		SignInPageFactory signInPage = new SignInPageFactory(driver);
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
