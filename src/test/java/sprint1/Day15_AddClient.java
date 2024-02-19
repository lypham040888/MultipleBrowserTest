package sprint1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import pom.AddClientPageFactory;
import pom.ClientPageFactory;
import pom.DashboardPageFactory;
import pom.SignInPageFactory;

public class Day15_AddClient {
	WebDriver driver;
	CommonBrowser browser;
	CommonActions action;

	@Test
	public void AddClientTest() {
		SignInPageFactory signIn = new SignInPageFactory(driver);
		signIn.clickLogin("admin@demo.com", "riseDemo");
		String companyName = "ABC Company 2";
		// Dashboard page

		DashboardPageFactory dashboard = new DashboardPageFactory(driver);
		dashboard.clickClientLink();
		// Client page
		ClientPageFactory clientPage = new ClientPageFactory(driver);
		clientPage.clickAddClientButton();

		// AddClient Page
		AddClientPageFactory addClientPage = new AddClientPageFactory(driver);
		addClientPage.fillData(companyName);
		addClientPage.closeForm();
		// Add contact page
		

		// Client page

		clientPage.searchClientName(companyName);
		clientPage.verifyClient(companyName);

	}

	@BeforeTest
	public void beforeTest() {
		/// driver = new ChromeDriver();
		browser = new CommonBrowser();
		action = new CommonActions();
		driver = browser.initEdgeDriver("https://rise.fairsketch.com/signin");

	}

	@AfterTest
	public void afterTest() {
	}
}
