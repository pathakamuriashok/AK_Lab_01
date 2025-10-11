package QA.AK.DriverSetUP;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{
	WebDriver driver;
	
	//@BeforeMethod
	@Test
	public void DriverSetUp() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		// Add another argument to run in incognito mode
		options.addArguments("incognito");
				
		// Add a command-line argument to start the browser maximized
		options.addArguments("start-maximized");

	//	options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Waits until fully loaded
		
	//	options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Waits until DOMContentLoaded
		
	//	options.setPageLoadStrategy(PageLoadStrategy.NONE);  // Doesn’t wait at all
		
		options.addArguments("test-type");
		
	    driver=new ChromeDriver(options);

	       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	      /* new WebDriverWait(driver, Duration.ofSeconds(20)).until(
	    		    webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
	    		        .executeScript("return jQuery.active == 0")); */

	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	       
	    Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
	    
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("D:\\Git\\Lab1 git\\AK\\src\\test\\java\\Screenshorts\\"+timestamp+"AK.png"));
       
	    driver.close();	    			    		
	}
}
