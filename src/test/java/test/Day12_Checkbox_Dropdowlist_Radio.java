package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import dev.failsafe.internal.util.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Day12_Checkbox_Dropdowlist_Radio extends CommonBrowser {
	WebDriver driver;
	CommonBrowser cb;
	CommonActions actions;

	@Test
	public void doPracticeCheckbox() {
		WebElement chkAged = driver.findElement(By.id("isAgeSelected"));
		// isDisplay kiểm tra xem phần tử đó có xuất hiện trên UI không
		// isEnable kiểm tra có thể tương tác phần đó không

		if (chkAged.isSelected() == false) {
			chkAged.click();

		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement chkSecond = driver.findElement(By.xpath("(//label[@class='checkbox-inline']//input)[2]"));
		if (chkSecond.isSelected() == true)
			chkSecond.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// List checkbox

		List<WebElement> lstMultiCheckBox = driver.findElements(By.xpath("//input[@class='cb1-element']"));
		for (WebElement webElement : lstMultiCheckBox) {
			if (webElement.isSelected() == false) {
				webElement.click();
			}

		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement mutiCheckboxFourth = driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));
		if (mutiCheckboxFourth.isSelected() == true) {
			mutiCheckboxFourth.click();
		}

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void doPracticeRadio() {
		driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		WebElement rdoMale = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
		// isDisplay kiểm tra xem phần tử đó có xuất hiện trên UI không
		// isEnable kiểm tra có thể tương tác phần đó không

		if (rdoMale.isSelected() == false) {
			rdoMale.click();

		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement chkAgedFirst = driver.findElement(By.xpath("(//input[@name='ageGroup'])[1]"));
		if (chkAgedFirst.isSelected() == false) {

			chkAgedFirst.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement chkAgedSecond = driver.findElement(By.xpath("(//input[@name='ageGroup'])[2]"));
		if (chkAgedSecond.isSelected() == false) {

			chkAgedSecond.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement chkAgedThird = driver.findElement(By.xpath("(//input[@name='ageGroup'])[3]"));
		if (chkAgedThird.isSelected() == false) {

			chkAgedThird.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void doPracticeSelectDropdownlist() {
		driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		WebElement optTuesday = driver.findElement(By.xpath("//select[@id='select-demo']//option[@value='Tuesday']"));
		optTuesday.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Select option
		WebElement ddlWeek = driver.findElement(By.id("select-demo"));
		Select selectWeek = new Select(ddlWeek);

		System.out.println("Mutiple select :  " + selectWeek.isMultiple());
		System.out.println("Số options: " + selectWeek.getOptions().size());
		org.testng.Assert.assertEquals(8, selectWeek.getOptions().size());
		System.out.println("Text of first option: " + selectWeek.getFirstSelectedOption().getText());
		selectWeek.selectByIndex(5);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectWeek.selectByValue("Sunday");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectWeek.selectByVisibleText("Wednesday");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void doPracticeDropdownlist() {
		driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ddlcountry = driver.findElement(By.xpath("(//a[@class='chosen-single'])[2]"));
		ddlcountry.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement optAngola = driver.findElement(By.xpath("//ul[@class='chosen-results']//li[text()='Angola']"));
		optAngola.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	@Ignore
	public void doPracticeBasicFunction() {
		driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// clear and sendKey
		WebElement txtSearch = driver
				.findElement(By.xpath("//div[@class='header-search position-relative']//input[@type='search']"));

		// isDisplay and isEnable
		if (txtSearch.isDisplayed() && txtSearch.isEnabled()) {
			txtSearch.click();
			txtSearch.clear();
			txtSearch.sendKeys("NewYork");
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Location: " + txtSearch.getLocation());
		System.out.println("Dimension: " + txtSearch.getSize());
		System.out.println("CSS Value: " + txtSearch.getCssValue("form-control"));
		System.out.println("Attribute Value: " + txtSearch.getAttribute("placeholder"));
		System.out.println("Tag name: " + txtSearch.getTagName());
	}

	@BeforeTest
	@Parameters("browserName")
	public void beforeTest(@Optional("firefox") String browser) {
//		driver = new ChromeDriver();
//		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.manage().window().maximize();
		cb = new CommonBrowser();
		driver= setupDriver(browser, "https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
