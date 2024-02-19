package homework_day14;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;

public class BasePageFactory {
	WebDriver driver;
	CommonActions actions = new CommonActions();

	public BasePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
