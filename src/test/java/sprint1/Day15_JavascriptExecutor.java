package sprint1;

import org.testng.annotations.Test;

import common.CommonBrowser;
import homework_day14.HomePageFactory;
import homework_day14.PersonalPageFactory;
import homework_day14.RegisterPageFactory;
import homework_day14.RegisterPageFactoryJavascriptExecutor;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Day15_JavascriptExecutor {
	WebDriver driver;
	CommonBrowser browser;

	@Test
	public void RegisterAccount() {
		RegisterPageFactoryJavascriptExecutor register = new RegisterPageFactoryJavascriptExecutor(driver);
		Random random = new Random();
		int temp = random.nextInt(10000);
		String email = "testemail" + temp + "@gmail.com";

		register.inputInformation("AAA A1", email, "12345678", "0956646509");
		HomePageFactory homepage = new HomePageFactory(driver);
		homepage.linkInformation();
		//homepage.moveChangeInfo();
		PersonalPageFactory personal = new PersonalPageFactory(driver);
		personal.changePassword("123456789");
	}

	@Test
	public void RemoveAttribute() {
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		
		js.executeScript("document.getElementsByTagName('input')[2].removeAttribute('disabled');");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("document.getElementsByTagName('input')[2].removeAttribute('checked');");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("document.getElementsByTagName('input')[2].checked=true;");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(js.executeScript("return window.innerHeight;").toString()); 
		System.out.println(js.executeScript("return window.innerWidth;").toString());

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
