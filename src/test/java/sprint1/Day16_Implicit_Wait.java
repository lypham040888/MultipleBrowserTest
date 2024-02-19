package sprint1;

import org.testng.annotations.Test;

import common.CommonBase;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Day16_Implicit_Wait {
	WebDriver driver;
	CommonBrowser browser;
	// CommonBase browser;
	// WebDriverWait wait = new WebDriverWait(driver, 5);
	WebDriverWait wait;

	@Test
	public void AlertDemo() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * driver.get("https://demo.automationtesting.in/Alerts.html"); WebElement
		 * btnAlert = driver .findElement(By.
		 * xpath("//button[contains(text(),'click the button to display an  alert box')]"
		 * )); btnAlert.click(); try { Thread.sleep(1000); } catch (InterruptedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * wait.until(ExpectedConditions.alertIsPresent()); // Alert trong Selenium //
		 * Alert box Alert alert = driver.switchTo().alert(); alert.accept(); // OK
		 * 
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * // Confirm alert box // driver.navigate().refresh();
		 * 
		 * WebElement lnkAlertConfirm =
		 * driver.findElement(By.xpath("//a[@href='#CancelTab']"));
		 * lnkAlertConfirm.click(); WebElement btnAlertConfirm = driver .findElement(By.
		 * xpath("//button[text()='click the button to display a confirm box ']"));
		 * btnAlertConfirm.click(); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } Alert alertConfirm = driver.switchTo().alert();
		 * System.out.print(alertConfirm.getText()); alertConfirm.dismiss(); // Cancel
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } // Alert with Textbox
		 * WebElement lnkAlertTextbox =
		 * driver.findElement(By.xpath("//a[@href='#Textbox']"));
		 * lnkAlertTextbox.click(); WebElement btnAlertTextbox = driver .findElement(By.
		 * xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		 * btnAlertTextbox.click(); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } Alert alertTextbox = driver.switchTo().alert();
		 * System.out.print(alertTextbox.getText());
		 * alertTextbox.sendKeys("VVVVVVVVVVVVVv"); alertTextbox.accept(); try {
		 * Thread.sleep(1000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		// driver.get("https://demo.guru99.com/test/delete_customer.php");
		WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		btnSubmit.click();
		Alert deleteAlert = driver.switchTo().alert();
		deleteAlert.accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void LoginWait() {
		// Implicit wait
		// driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// Ngầm định 10 để tìm
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Explicit wait

		WebElement txtUser = driver.findElement(By.name("username"));//
		// Đợi Xuất hiện
		wait.until(ExpectedConditions.visibilityOf(txtUser));
		txtUser.sendKeys("Admin");
		WebElement txtPassword = driver.findElement(By.name("password"));
		wait.until(ExpectedConditions.elementToBeClickable(txtUser));

		txtPassword.sendKeys("admin123");
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='orangehrm-dashboard-widget-name']//p"),
				"Time at Work"));
		wait.until(ExpectedConditions.textToBe(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"), "Admin"));
		WebElement lnkAdmin = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
		lnkAdmin.click();

		System.out.println(driver.getCurrentUrl());
	}

	@BeforeTest
	public void beforeTest() {
		browser = new CommonBrowser();

		// driver =
		// browser.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver =
		// browser.initEdgeDriver("https://demo.guru99.com/test/delete_customer.php");
		driver = browser.initFirefoxDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//wait = new WebDriverWait(driver, 5);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
		browser.closeDriver(driver);
	}

}
