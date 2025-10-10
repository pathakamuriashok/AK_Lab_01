package QA.AK.DriverSetUP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{
	WebDriver driver;
	
	//@BeforeMethod
	@Test
	public void DriverSetUp()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		// Add another argument to run in incognito mode
		options.addArguments("incognito");
				
		// Add a command-line argument to start the browser maximized
		options.addArguments("start-maximized");

		options.addArguments("test-type");
		
	    driver=new ChromeDriver(options);
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	    Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
	    			    		
	}
}
