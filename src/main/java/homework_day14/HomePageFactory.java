package homework_day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFactory extends BasePageFactory {

	public HomePageFactory(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[@class='avatar2']")
	WebElement avatar;
	@FindBy(xpath ="//a[@href='https://alada.vn/thong-tin-ca-nhan']")
	WebElement optChangeInfo;
	

	public void linkInformation() {
		driver.get("https://alada.vn/thong-tin-ca-nhan");
	}
	public void moveChangeInfo() {
		actions.move(avatar);
		actions.click(optChangeInfo);
	}

}
