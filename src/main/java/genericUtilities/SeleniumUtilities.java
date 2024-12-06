package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SeleniumUtilities {
	
	public void maximize(ChromeDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void implicitWait(ChromeDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void screenshot(WebDriver driver,String screenshotName) throws IOException
	{
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File des = new File(".\\Screenshots\\"+screenshotName+".png");
		 FileHandler.copy(src, des);
	}
}
