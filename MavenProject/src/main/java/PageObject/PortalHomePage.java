package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {

	public WebDriver driver;
	By searchBox = By.className("query");
	
	
	public PortalHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
