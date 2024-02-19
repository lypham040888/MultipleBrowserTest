package homework_day14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageFactoryJavascriptExecutor  extends BasePageFactory{
	public RegisterPageFactoryJavascriptExecutor(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "txtFirstname")
	WebElement txtFirstname;
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	@FindBy(id = "txtCEmail")
	WebElement txtCEmail;
	@FindBy(id = "txtPassword")
	WebElement txtPassword;
	@FindBy(id = "txtCPassword")
	WebElement txtCPassword;
	@FindBy(id = "txtPhone")
	WebElement txtPhone;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnDangKy;

	public void inputInformation(String firstname, String email, String password, String phone) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//CommonActions common = new CommonActions();
		//actions.sendKeys(txtFirstname, firstname);
		 
		js.executeScript("document.getElementById('txtFirstname').setAttribute('value','admin021@mailinator.com');");
		
		actions.sendKeys(txtEmail, email);
		actions.sendKeys(txtCEmail, email);
		actions.sendKeys(txtPassword, password);
		actions.sendKeys(txtCPassword, password);
		actions.sendKeys(txtPhone, phone);
		js.executeScript("arguments[0].scrollIntoView(true);", txtPhone);
		
		js.executeScript("arguments[0].style.border='3px solid red'", txtPhone);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//actions.click(btnDangKy);
		js.executeScript("arguments[0].click();", btnDangKy);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 js.executeScript("alert('Successfully Logged In');");
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
}
