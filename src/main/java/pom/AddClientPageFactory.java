package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddClientPageFactory extends BasePageFactory {

	public AddClientPageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// Fill data cho các field
	// Click Save button
	@FindBy(name="company_name")
	WebElement txtCompanyName;
	@FindBy (id="save-and-continue-button")
	WebElement btnSave;
	
	@FindBy(xpath = "//button[text()=' Close']")
	WebElement btnClose;
	

	public void fillData(String value) {

		txtCompanyName.sendKeys(value);
		btnSave.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeForm() {
		btnClose.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
