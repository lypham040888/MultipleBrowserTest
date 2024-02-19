package sprint1;

import org.testng.annotations.Test;

import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Day15_DatePicker {
	CommonBrowser browser;
	WebDriver driver;

	@Test
	public void AddValueDatePicker() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement flyTo = driver.findElement(By.xpath("(//label[text()='Flying from']//following-sibling::div//input[@placeholder='City or airport'])[1]"));
		js.executeScript("arguments[0].setAttribute('value','Tokyo');", flyTo);
		flyTo.sendKeys(Keys.TAB);
		WebElement datePicker = driver.findElement(
				By.xpath("(//label[text()='Departing']//following-sibling::div//input[@name='daterange-single'])[1]"));
		
		js.executeScript("arguments[0].removeAttribute('readonly');", datePicker);
		datePicker.clear();
		datePicker.sendKeys("10102024");
		datePicker.sendKeys(Keys.TAB);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeTest
	public void beforeTest() {
		browser = new CommonBrowser();
		driver = browser.initEdgeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
	}

	@AfterTest
	public void afterTest() {
	}

}
