package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
		protected WebDriver driver;
		//create constructor
		public PageBase(WebDriver driver) 
		{		
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		protected static void ClickButton(WebElement Button) {
			Button.click();
		}
		protected static void SendTextElement(WebElement TextField, String Value) {
			TextField.sendKeys(Value);
		}

}
