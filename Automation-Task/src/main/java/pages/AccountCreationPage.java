package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationPage extends PageBase {

	public AccountCreationPage(WebDriver driver) {
		super(driver);
	}
	//Personal Information
	@FindBy(id = "id_gender2")
	WebElement GenderRadioButton;
	@FindBy(id = "customer_firstname")
	WebElement FirstNameTxtField;
	@FindBy(id = "customer_lastname")
	WebElement LastNameTxtField;
	@FindBy(id = "passwd")
	WebElement PasswordTxtField;
	@FindBy(id = "days")
	WebElement DaysList;
	@FindBy(id = "months")
	WebElement MonthsList;
	@FindBy(id = "years")
	WebElement YearsList;
	//Your Address
	@FindBy(id = "firstname")
	WebElement AddFirstNamtxtField;
	@FindBy(id = "lastname")
	WebElement AddLastNamtxtField;
	@FindBy(id = "company")
	WebElement CompanytxtField;
	@FindBy(id = "address1")
	WebElement AddersstxtField;
	@FindBy(id = "address2")
	WebElement Address2txtField;
	@FindBy(id = "city")
	WebElement CitytxtField;
	@FindBy(id = "id_state")
	WebElement StateDropDownList;
	@FindBy(id = "postcode")
	WebElement PostalCodeTxtField;
	@FindBy(id = "phone_mobile")
	WebElement MobileTxtField;
	@FindBy(id = "alias")
	WebElement AddressAliastxtField;
	@FindBy(id = "submitAccount")
	WebElement SubmitButton;

	@SuppressWarnings("deprecation")
	public void UserRegisteration(String FirstName, String LastName, String Password, String AddressFn, String AddressLn, String Company, String Address, String Address2, String City, String PostalCode, String MobileNumber, String AddressAlias) 
	{
		//Personal Information
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
		ClickButton(GenderRadioButton);
		SendTextElement(FirstNameTxtField, FirstName);
		SendTextElement(LastNameTxtField, LastName);
		SendTextElement(PasswordTxtField, Password);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select BirthDay = new Select(DaysList);
		List<WebElement> AllDaysList = BirthDay.getOptions();
		int DaysCount = AllDaysList.size();
		Random Dnum = new Random();
		int DaySelection = Dnum.nextInt(DaysCount);
		BirthDay.selectByIndex(DaySelection);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select BirthMonth = new Select(MonthsList);
		List<WebElement> AllMonthsList = BirthMonth.getOptions();
		int MonthsCount = AllMonthsList.size();
		Random Mnum = new Random();
		int MonthSelection = Mnum.nextInt(MonthsCount);
		BirthMonth.selectByIndex(MonthSelection);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select BirthYear = new Select(YearsList);
		List<WebElement> AllYearsList = BirthYear.getOptions();
		int YearsCount = AllYearsList.size();
		Random Ynum = new Random();
		int YearSelection = Ynum.nextInt(YearsCount);
		BirthYear.selectByIndex(YearSelection);
		//Your Address
		SendTextElement(AddFirstNamtxtField, AddressFn);
		SendTextElement(AddFirstNamtxtField, AddressLn);
		SendTextElement(CompanytxtField, Company);
		SendTextElement(AddersstxtField, Address);
		SendTextElement(Address2txtField, Address2);
		SendTextElement(CitytxtField, City);
		ClickButton(StateDropDownList);
		Select State = new Select(StateDropDownList);
		List<WebElement> AllStatesList = State.getOptions();
		int StatesCount = AllStatesList.size();
		Random Snum = new Random();
		int StateSelection = Snum.nextInt(StatesCount);
		State.selectByIndex(StateSelection);
		SendTextElement(PostalCodeTxtField, PostalCode);
		SendTextElement(MobileTxtField, MobileNumber);
		SendTextElement(AddressAliastxtField, AddressAlias);
		ClickButton(SubmitButton);


	}	
}
