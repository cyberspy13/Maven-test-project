package MavenAcademy.MavenAcademyProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;
import resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject(); // here we are trying to Pull EXTENT from the ExtentReporterNG.getReportObject() method 
																// and parse inside our method  extends BaseClass implements ITestListener
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // We created an object of this ThreaddLocal Class
																		//so now extentTest can store all details from test
	
	
	@Override
	public void onTestStart(ITestResult result) { // this command strts Before our test run starts 
		// TODO Auto-generated method stub
		 test = extent.createTest(result.getMethod().getMethodName());  // using this EXTENT object with all Parameters we are simply creating the Test
																		//initially we are created a variable TEST which responsible for everything now:passed test/failed test etc.
		 extentTest.set(test); // initially sending new created tests to ThreadlocalPool and this pool gives us result Failed or Passed.
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS,"Test Passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		extentTest.get().fail(result.getThrowable());    // This command gives us a log getThrowable()
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName(); // this method will be capture our failure Tests and
		try {
			driver  = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // once we captured we need to send of argument getScreenShotPath
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	
	
	
	
	
	
	

}
