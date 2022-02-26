package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.AccountCreationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.MyCreatedAccountPage;

public class TestScript extends TestBase {
	HomePage homepageObject;
	MyAccountPage myaccountObject;
	AccountCreationPage accountcreationObject;
	MyCreatedAccountPage mycreatedaccountpageObject;
	Faker fakedata = new Faker();
	String Email = fakedata.internet().emailAddress();
	String FirstName = fakedata.name().firstName();
	String LastName = fakedata.name().lastName();
	String Password = fakedata.number().digits(8).toString();
	String Address = fakedata.address().streetName();
	String Address2 = fakedata.address().buildingNumber();
	String City = fakedata.address().cityName();
	String PostalCode = fakedata.number().digits(5);
	String MobileNumber = fakedata.phoneNumber().cellPhone();
	String Company = fakedata.company().name();

	@Test (priority = 1, alwaysRun = true)
	public void NavigateToMyAccount() 
	{
		homepageObject = new HomePage(driver);
		homepageObject.SignIn();
	}
	@Test (dependsOnMethods = {"NavigateToMyAccount"})
	public void NavigateToAccountCreation() throws InterruptedException 
	{
		myaccountObject = new MyAccountPage(driver);
		myaccountObject.RegisteringEmail(Email);
	}

	@Test (dependsOnMethods = {"NavigateToAccountCreation"})
	public void CreateAccount() 
	{
		accountcreationObject = new AccountCreationPage(driver);
		accountcreationObject.UserRegisteration(FirstName, LastName, Password, FirstName, LastName, Company, Address, Address2, City, PostalCode, MobileNumber, Address);
		mycreatedaccountpageObject = new MyCreatedAccountPage(driver);
		Assert.assertTrue(mycreatedaccountpageObject.SignOutLink.isDisplayed());
	}
	@Test (dependsOnMethods = {"CreateAccount"})
	public void SigningOut() 
	{
		mycreatedaccountpageObject = new MyCreatedAccountPage(driver);
		mycreatedaccountpageObject.SignOut();
	}

}
