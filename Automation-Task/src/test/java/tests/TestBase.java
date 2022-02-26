package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	public static WebDriver driver;
	@BeforeSuite
	public void StartDriver() 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com");
		driver.manage().window().maximize();
	}
	@AfterSuite
	public void StopDriver() 
	{
		driver.quit();
	}

}