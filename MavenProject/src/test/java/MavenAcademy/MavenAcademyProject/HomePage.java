package MavenAcademy.MavenAcademyProject;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import PageObject.ForgotPassword;
import PageObject.LandingPage;
import PageObject.LoginPage;
import resources.BaseClass;

public class HomePage extends BaseClass { 	//inheritance
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void beforetest() throws IOException
	{
		driver = initializeDriver();					
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username,String password,String text) throws IOException	// need to declare variables from getData() method
	{																								//the count of the arguments should be equal  values we are sending per each row
																									//once the Test with first values is finished it is going to trigger  the second test Case
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);   //create object of the class and invoke the method
		LoginPage logp = lp.getLogin();
		
		//LoginPage logp = new LoginPage(driver); // we dont need this code because we cpecify in LoginPage Method
		logp.getEmail().sendKeys(username);            	 //data type 0     //coloumn 0  
		logp.getPassword().sendKeys(password); 		    //data type 1     //coloumn 1
		//System.out.println(text);		
		log.info(text);
		
		logp.getLogIn().click();
		ForgotPassword fp = logp.getForgotPass();
		fp.getEmail().sendKeys("kerraprouk@gmail.com");
		fp.getInstructions().click();
	}
	@AfterTest
	public void aftertest()
	{
		driver.close();
	}

	@DataProvider
	public Object[][] getData()
	{
				//Row stands for how many different data types test should run
				//Coloumn stands for how many values per each test
				Object[][] data = new Object[2][3];       // it is will be run 2 times and we are taking 3 parameters for this , but start to count indexers by - 0,1,2 - 3 in total           
				data[0][0] = "nonresttricteduser@gmail.com";  
				data[0][1] = "udemycom123";
				data[0][2] =  "Non restricted user";
				
				data[1][0] = "restricteduser@gmail.com";
				data[1][1] = "udemycom123";
				data[1][2] = "Restricted user";
		
		return data;
	}
	
	
	
	
	
	
	
	

}
