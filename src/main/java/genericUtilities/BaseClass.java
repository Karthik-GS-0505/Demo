package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.LoginPage;

public class BaseClass {
	
	PropertyFileUtilities pUtil = new PropertyFileUtilities();
	SeleniumUtilities sUtil = new SeleniumUtilities();
	
	public ChromeDriver driver;
	public static ChromeDriver sdriver;
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("DataBase connection successfull");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String URL = pUtil.readPropertyFile("url");
		driver = new ChromeDriver();
		sUtil.implicitWait(driver);
		sUtil.maximize(driver);
		driver.get(URL);
		System.out.println("Browser launched successfull");
		
		sdriver = driver;
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException 
	{
		String EMAIL = pUtil.readPropertyFile("email");
		String PASSWORD = pUtil.readPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(EMAIL, PASSWORD);
		System.out.println("Login to Application successfull");
		
	}
}
