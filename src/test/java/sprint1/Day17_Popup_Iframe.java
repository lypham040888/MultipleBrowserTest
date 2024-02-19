package sprint1;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Day17_Popup_Iframe {
	WebDriver driver;
	CommonBrowser browser;
	WebDriverWait wait;
	CommonActions actions;

	@Test
	@Ignore
	public void HandleWindows() {
		// Cửa sổ/ tab mà chúng ta mở ngay sau khi truyền url
		// String mainWindow = driver.getWindowHandle();

		// System.out.println("Main windows: " + mainWindow);
		WebElement lnkClickHere = driver.findElement(By.xpath("//a[@href='../articles_popup.php']"));
		lnkClickHere.click();
		// Lấy thông tin của tab mà đang tương tác ( Hay là tab mà đang mở)
		// Lưu lại thông tin của tab mà đang mở
		String emailSubmitTab = driver.getWindowHandle();
		System.out.println("Email Submit Tab: " + emailSubmitTab);
		// Lấy tất cả tab mà browser đang chạy automation
		Set<String> collectTab = driver.getWindowHandles();
		// Duyệt tab sao cho tab focus đúng là emailSubmitTab thì truyền giá trị cho ô
		// email và click nút submit
		for (String window : collectTab) {
			System.out.println("window in Set tabs: " + window);
			if (!window.equals(emailSubmitTab)) {
				// Chuyển focus/ select đúng về email Submit tab
				driver.switchTo().window(window);
				// Set giá trị cho email
				WebElement email = driver.findElement(By.name("emailid"));
				email.sendKeys("testemail@gmail.com");
				WebElement btnSubmit = driver.findElement(By.name("btnLogin"));
				btnSubmit.click();
				WebElement detailUser = driver.findElement(By.xpath("(//td[@align='center'])[3]"));
				System.out.println("Detail user:" + detailUser.getText());
				driver.close();
				// Close đóng tab hiện tại đang mở hoặc focus
				// driver.quit();
				// Thoát trình duyệt và đóng tất cả các tab trên trình duyệt đó
			}
		}

		driver.switchTo().window(emailSubmitTab);
		System.out.println("Đã chuyển về màn hình chính đầu tiên");
		System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/popup.php");

	}

	@Test
	@Ignore
	public void HandlePopupModal() {
		driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");

		WebElement linkToFacebook = driver.findElement(By.xpath("//a [contains(text(),'Like us On Facebook')]"));
		linkToFacebook.click();
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for (String name : windows) {
			if (!name.equals(mainWindow)) {
				driver.switchTo().window(name);
				WebElement headerPopup = driver.findElement(By.xpath("(//form[@id='login_popup_cta_form']//span)[2]"));
				System.out.println(headerPopup.getText());
			}

		}

	}

	@Test
	@Ignore
	public void HandlePopupAuthentication() {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		// Dùng list.size() để kiếm tra phần tử có tồn tại hay không, khi element chỉ
		// xuất hiện trong trường hợp đúng
		List<WebElement> element = driver.findElements(By.xpath("//p[contains(text(),'Congratulations!')]"));

		if (element.size() > 0) {
			String text = element.get(0).getText();

			if (text.contains("Congratulations")) {
				System.out.println("successful login");
			} else {
				System.out.println("login failed");
			}
		} else {
			System.out.println("login failed with wrong user/password");
		}

	}

	@Test
	@Ignore

	public void HandleIframe() {
		driver.get("https://codestar.vn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Đếm số iframe trên 1 trang web

		int sizeFrame = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Số iframe: " + sizeFrame);
		List<WebElement> lstIframe = driver.findElements(By.xpath("//iframe[contains(@src,'form')]"));

		// driver.switchTo().frame(lstIframe.get(lstIframe.size() - 1)); // index phần
		// tử số 2
		// driver.switchTo().frame("");// id
		// driver.switchTo().frame(""); // name
		WebElement iframeFormLast = driver.findElement(By.xpath("(//iframe[contains(@src,'form')])[2]"));
		driver.switchTo().frame(iframeFormLast); // WebElement
		WebElement txtPhone = driver.findElement(By.name("account_phone"));
		txtPhone.sendKeys("12346777");
		WebElement txtCustomer = driver.findElement(By.name("account_name"));
		txtCustomer.sendKeys("Customer1");
		WebElement txtEmail = driver.findElement(By.name("account_email"));
		txtEmail.sendKeys("testcodestar@gmail.com");
		WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Đăng ký ngay']"));
		btnSubmit.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		// Chuyển trang default page
		driver.switchTo().defaultContent();
		driver.switchTo().frame(lstIframe.get(0));
		WebElement txtPhone1 = driver.findElement(By.name("account_phone"));
		txtPhone1.sendKeys("12346777");

	}

	@Test
	public void HandleIframe2() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/frames");

		driver.switchTo().frame("frame1");// lấy theo id
		WebElement heading = driver.findElement(By.id("sampleHeading"));
		System.out.println(heading.getText());
		// do version selenium 2.53.1 nên không hỗ trợ chụp ảnh elemetnt
//		// Chụp ảnh 1 control
		driver.switchTo().defaultContent();
		WebElement divframesWrapper = driver.findElement(By.id("frame1"));
				
		try {
			actions.takeScreenShotElement(driver, divframesWrapper);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Chụp ảnh cả màn hình

		actions.takeScreenShotFullPage(driver);

	}

	@BeforeTest
	public void beforeTest() {
		browser = new CommonBrowser();
		// driver = browser.initEdgeDriver("https://demo.guru99.com/popup.php");
		driver = browser.initChromeDriver("https://demoqa.com/frames");
		//driver = browser.initFirefoxDriver("https://demoqa.com/frames");
		//wait = new WebDriverWait(driver, 5);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		actions = new CommonActions();
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
		browser.closeDriver(driver);
	}

}
