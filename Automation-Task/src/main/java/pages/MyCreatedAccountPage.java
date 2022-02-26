package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCreatedAccountPage extends PageBase {

	public MyCreatedAccountPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(linkText = "Sign out")
	public WebElement SignOutLink;
	public void SignOut() 
	{
		ClickButton(SignOutLink); 
	}

}
