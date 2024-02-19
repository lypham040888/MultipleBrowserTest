package sprint1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

@Test
public class Day13_Pratice {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {

	}

	@Test
	public void BasicFunction2() {

		// driver.findElements(null)
		// phần tử không tồn tại =0

		/// Khởi tạo các browser
		// chrome
//  driver = new ChromeDriver();
//  
//  
//  // firefox 
//  driver = new FirefoxDriver();
//  
//  // edge
//  driver = new InternetExplorerDriver();
//  
//  // Safari
//  
//  driver = new SafariDriver();
		// selenium < 4

		driver.get("https://googlechromelabs.github.io/chrome-for-testing/#stable");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to("https://bepantoan.vn/");
		System.out.print(driver.getCurrentUrl());
		System.out.print(driver.getTitle());
		System.out.print(driver.getPageSource());
		driver.navigate().to("https://googlechromelabs.github.io/chrome-for-testing/#stable");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		// driver.switchTo().newWindow(WindowType.TAB);
		// driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.)

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
	}

}
