package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "email_create")
	WebElement EmailTxtField;
	@FindBy(id = "SubmitCreate")
	WebElement CreateAnAccountButton;
	@SuppressWarnings("deprecation")
	public void RegisteringEmail(String Email) throws InterruptedException 
	{
		 SendTextElement(EmailTxtField, Email);
		 ClickButton(CreateAnAccountButton); 		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
