package homework;

import org.testng.annotations.Test;

import common.CommonBrowser;
import homework_day14.HomePageFactory;
import homework_day14.PersonalPageFactory;
import homework_day14.RegisterPageFactory;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BTVN_Day14 {
	WebDriver driver;
	CommonBrowser browser;

	@Test
	public void RegisterAccount() {
		RegisterPageFactory register = new RegisterPageFactory(driver);
		Random random = new Random();
		int temp = random.nextInt(10000);
		String email = "testemail" + temp + "@gmail.com";

		register.inputInformation("AAA A1", email, "12345678", "0956646509");
		HomePageFactory homepage = new HomePageFactory(driver);
		homepage.linkInformation();
		//homepage.moveChangeInfo();
		PersonalPageFactory personal  =  new PersonalPageFactory(driver);
		personal.changePassword("123456789");
	}

	@BeforeTest
	public void beforeTest() {
		browser = new CommonBrowser();
		driver = browser.initEdgeDriver("https://alada.vn/tai-khoan/dang-ky.html");

	}

	@AfterTest
	public void afterTest() {
		// browser.quitDriver(driver);
	}

}
