package MavenAcademy.MavenAcademyProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import PageObject.LandingPage;
import resources.BaseClass;

//what we need to do
//generating html reports
//Screenshots on failure
//Jenkins integration
public class ValidateBar extends BaseClass {    //inheritance
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void initialize() throws IOException						// need to declare variables from getData() method
	{															   //the count of the arguments should be equal  values we are sending per each row
																  //once the Test with first values is finished it is going to trigger  the second test Case
	
		driver = initializeDriver();					   
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException				
	{
		LandingPage lp = new LandingPage(driver);   //create obbject of the class annd invoke the method
													//compare the text from the browser with actual text - error..
													// we are comparing values from here (lp.getTitle().getText() from the values we are expecting
		AssertJUnit.assertTrue(lp.getNavigationBar().isDisplayed()); // if we need to use Boolean assertions : true/false we can use assertTrue... etc
		log.info("Navigation bar is displayed");
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}


	
	
	
	
	
	
	

}
