package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.PropertyFileUtilities;

public class RigisterPage {
	
	PropertyFileUtilities pUtil = new PropertyFileUtilities();
	
	//Declaration
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLinkButton;
	
	@FindBy(id = "gender-male")
	private WebElement maleGenderRadioButton;
	
	@FindBy(id = "gender-female")
	private WebElement femaleGenderRadioButton;
	
	@FindBy(id = "FirstName")
	private WebElement firstName;
	
	@FindBy(id = "LastName")
	private WebElement lastName;
	
	@FindBy(id = "Email")
	private WebElement Email;

	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutButton;
	
	//Initialization
	public RigisterPage(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//getters
	public WebElement getRegisterLinkButton() {
		return registerLinkButton;
	}
	
	public WebElement getMaleGenderRadioButton() {
		return maleGenderRadioButton;
	}
	
	public WebElement getFemaleGenderRadioButton() {
		return femaleGenderRadioButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	
	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	public WebElement getlogoutButton() {
		return logoutButton;
	}
	
	
	//Business Library
	public void logout()
	{
		getlogoutButton().click();
	}
	public void RegisterUser() throws IOException
	{
		String GENDER = pUtil.readPropertyFile("gender");
		String FIRSTNAME = pUtil.readPropertyFile("firstname");
		String LASTNAME = pUtil.readPropertyFile("lastname");
		String EMAIL = pUtil.readPropertyFile("email");
		String PASSWORD = pUtil.readPropertyFile("password");
				
		if(GENDER == "male")
		{
			getMaleGenderRadioButton().click();
		}
		else
		{
			getFemaleGenderRadioButton().click();
		}
		
		getFirstName().sendKeys(FIRSTNAME);
		getLastName().sendKeys(LASTNAME);
		getEmail().sendKeys(EMAIL);
		getPassword().sendKeys(PASSWORD);
		getConfirmPassword().sendKeys(PASSWORD);
		getRegisterButton().click();
	}
	
	public void clickOnRigisterLinkButton()
	{
		getRegisterLinkButton().click();
	}
}
