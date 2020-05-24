package resources;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports  extent;
	
	public static ExtentReports getReportObject()   // we need to call this method in Listeners (public void onTestStart(ITestResult result)) method 
	{												// to directly call this method with a class name we need to keep it STATIC	
													// we can simply call now   ExtentReporterNG.getReportObject
													// if we want to call this method and do not change the type void to type static we need to create a new object of the method and call this metho.For example:
													// ExtentReporterNG kaka = new ExtentReporterNG();
													//kaka.getReportObject();
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Mihail Lecari");
		
		return extent;
		
	}


	

}
