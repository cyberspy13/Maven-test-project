package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.PortalHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.BaseClass;

public class stepDefinition extends BaseClass{
	

	
	@Given("Initialize the browser with a chrome")
	public void initialize_the_browser_with_a_chrome() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		driver = initializeDriver();
	 
	}

	@Given("Navigate to {string} Site")
	public void navigate_to_Site(String string) {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(string);
	   
	}

	@Given("Click on Login link in home page to land on sign in Page")
	public void click_on_Login_link_in_home_page_to_land_on_sign_in_Page() {
	    // Write code here that turns the phrase above into concrete actions
		
		LandingPage lp = new LandingPage(driver);   //create object of the class and invoke the method
		if(lp.popUpSize() > 0)
		{
			lp.popUp().click();
		}
		LoginPage logp = lp.getLogin();
	    
	}

	@Then("Verify that user is successfully logged in")
	public void verify_that_user_is_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		
		PortalHomePage portal = new PortalHomePage(driver);
		Assert.assertTrue(portal.getSearchBox().isDisplayed());
		
	}

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
       
    	LoginPage logp = new LoginPage(driver);
		logp.getEmail().sendKeys(username);            	 //data type 0     //coloumn 0  
		logp.getPassword().sendKeys(password); 		    //data type 1     //coloumn 1
			
		logp.getLogIn().click();
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
       driver.quit();
    }
}
