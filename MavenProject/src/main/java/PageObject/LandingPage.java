package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver =  driver;
	}
	private By popUp = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By signIn = By.xpath("//span[contains(text(),'Login')]");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navMenu = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By header = By.cssSelector(".col-sm-6.col-md-8.hidden-xs.video-banner h3");
	
	public LoginPage getLogin()
	{
		driver.findElement(signIn).click();
		LoginPage logp = new LoginPage(driver);
		return logp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		System.out.println("Trying to identify navigation bar");
		return driver.findElement(navMenu);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	public int popUpSize()
	{
		return driver.findElements(popUp).size(); // we are taking here llike a size
	}
	public WebElement popUp()
	{
		return driver.findElement(popUp);
	}

}
