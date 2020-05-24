package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By email = By.xpath("//input[@id=\"user_email\"]");
	By password = By.xpath("//input[@id=\"user_password\"]");
	By logIn = By.cssSelector(".btn.btn-primary.btn-md.login-button");
	By forgotPass = By.xpath("//a[contains(text(),\"Forgot Password?\")]");

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogIn()
	{
		return driver.findElement(logIn);
	}
	public ForgotPassword getForgotPass()
	{
		 driver.findElement(forgotPass).click();
		 ForgotPassword fps = new ForgotPassword(driver); // or return new ForgotPassword(driver);
		 return fps;
	}

}
