package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

public WebDriver driver;

	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
	}

	By email = By.xpath("//input[@id=\"user_email\"]");
	By sendMeInstructions = By.xpath("//input[@name=\"commit\"]");
		
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}

	public WebElement getInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}


}
