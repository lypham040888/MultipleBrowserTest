package homework_day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalPageFactory extends BasePageFactory {

	public PersonalPageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="txtnewpass")
	WebElement txtnewpass;
	@FindBy(id="txtrenewpass")
	WebElement txtrenewpass;

	@FindBy(xpath = "//button[text()='Lưu mật khẩu mới']")
	WebElement btnSave;
	
	public void changePassword(String newpass)
	{
		actions.sendKeys(txtnewpass, newpass);
		actions.sendKeys(txtrenewpass, newpass);
		actions.click(btnSave);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
