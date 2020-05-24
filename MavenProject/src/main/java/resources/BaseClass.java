package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
		//static public WebDriver driver  - it is means that - IF MULTIBLE TEST CASES ACCESSING THIS DRIVER IT IS NOT CREATE A NEW OBJECT.IT IS WILL SHARE EXISTING COPY ONLY
											//In sequentioal that is okay , coz all TEST CASES run one by one.But in PARALLEL we are can not use Static word coz all test cases will be run it on the same time
											// wieth STATIC one variable will override another one every time, it is now create a new one.
		public WebDriver driver;			// need to define in here coz we dont want to create one more time, iit is no point
		public Properties prop;				// it is visible for all class , so if we need to create access for instantiated classes we need to make it public and take out from the method.
		
		
	public WebDriver initializeDriver() throws IOException
	{
		//need to ChromeBrowser
		prop = new Properties();
		//System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\properties"); //this is how  we can avoid Hard Coding part in our code
		
		prop.load(fis);
		//mvn test -Dbrowser=chrome // we are parsing this "chrome" parameter to the browserName and it is will be stored in there.
		
		
		
		//String browserName = System.getProperty("browser"); // if we are giving this command it is taking from maven(We need to uncomment this if we want to run from Maven)
		String browserName = prop.getProperty("browser"); // if we are giving this command it is taking from the poperties File.(If we want  to run from the eclipse we need to uncoment this step)
		//System.getProperty("user.dir")
		if(browserName.contains("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\drivers\\chromedriver.exe");
			 ChromeOptions options = new ChromeOptions();  // it's a class which will helps you to give many options which you can inject with this ChromeDriver and tell the behaivior of headlist
			 if(browserName.contains("headless"))
			 {
				 options.addArguments("headless");  //headless we are using cos we Do not see the browser opening but Tests sre executing
			 }
			 driver = new ChromeDriver(options); 
			 driver.manage().window().maximize();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else
		{
			System.out.println("Program can not be run.You are trying to reach without browser definition");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // we need to declare this TimeOut in here in case if Developer tell us change or set up timeOut but dont want to do it in all our testCasesss.We need to do it once and in here.So it is very important.
		
		return driver;  // DO NOT FORGOT ABOUT THIS. We need to send our driver back to use  
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile  =  System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"; 	// user.dir gives us a folder of our project
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}
}
