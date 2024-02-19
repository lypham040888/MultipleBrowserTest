package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBase;
import common.CommonBrowser;
import pom.DashboardPageFactory;
import pom.LoginPageFactory;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class Bai14PageFactory extends CommonBrowser{
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void TC01_LoginSuccess() {
		LoginPageFactory rLogin = new LoginPageFactory(driver);
		rLogin.clickLogin("admin@demo.com", "riseDemo");
		
		cb.pause(2000);
		actions.takeScreenShotFullPage(driver);
		DashboardPageFactory pDashboard = new DashboardPageFactory(driver);
		assertTrue(pDashboard.checkExistedUserName());

	}

	@Test
	public void TC02_LoginFailed_IncorrectPassword() {

	}

	@Test
	public void TC03_LoginFailed_IncorrectUser() {

	}

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@AfterTest
	public void afterMethod() {
		cb.quitDriver(driver);
	}

//	@BeforeTest
//	public void beforeTest() {
//		cb = new CommonBrowser();
//		actions = new CommonActions();
//		driver = cb.initChromeDriver(constants.Test1_WebInfo.prodwebURL);
//		cb.pause(4000);
//	}
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional("chrome") String browser) {
		cb = new CommonBrowser();
		actions = new CommonActions();
		driver = setupDriver(browser,"https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/projects/all_projects");
		
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		cb.quitDriver(driver);
	}

}
