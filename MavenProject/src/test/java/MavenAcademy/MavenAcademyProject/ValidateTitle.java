package MavenAcademy.MavenAcademyProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import PageObject.LandingPage;
import resources.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ValidateTitle extends BaseClass {   //inheritance
	public WebDriver driver;
	LandingPage lp;					// create the variable and giving the live in the methods below
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	@BeforeTest
	public void initializeTitle() throws IOException						// need to declare variables from getData() method
	{													//the count of the arguments should be equal  values we are sending per each row
														//once the Test with first values is finished it is going to trigger  the second test Case
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	@Test
	public void basePageNavigation() throws IOException			
	{
		lp = new LandingPage(driver);   			//create obbject of the class annd invoke the method
													//compare the text from the browser with actual text - error..
		   											// we are comparing values from here (lp.getTitle().getText() from the values we are expecting
		AssertJUnit.assertEquals(lp.getTitle().getText(), "FEATURED COURSES adventador"); // we can use tgis assertion if we need compare Something with a Something
		log.info("Succesfully validated Text message");
	}
	@AfterTest

	@Test
	public void validateHeader() throws IOException			
	{
		//lp = new LandingPage(driver); // we can comment this step coz it is accessible globally 	//create obbject of the class annd invoke the method
													//compare the text from the browser with actual text - error..
		   											// we are comparing values from here (lp.getTitle().getText() from the values we are expecting
		AssertJUnit.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING"); // we can use tgis assertion if we need compare Something with a Something
		log.info("Succesfully validated Text message");
	}
	
	
	
	public void aftetest()
	{
		driver.close();
	}



	
	
	
	
	
	
	

}
