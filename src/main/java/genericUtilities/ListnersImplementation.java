package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListnersImplementation implements ITestListener{

	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyy hh-mm-ss");
	String date = f.format(d);
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("---test execution started---");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"---test execution successfull---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"---test execution failed---");
		System.out.println("Execption -"+result.getThrowable());
		
		String screenshotName = testMethodName+date;
		SeleniumUtilities sUtil = new SeleniumUtilities();
		try {
			sUtil.screenshot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"---test execution skipped---");
		System.out.println("Execption -"+result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\Report -"+date+".html");
		//esr.config().setDocumentTitle("");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution completed");
	}
}
