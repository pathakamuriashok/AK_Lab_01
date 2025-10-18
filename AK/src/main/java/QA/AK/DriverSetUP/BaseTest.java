package QA.AK.DriverSetUP;

import org.openqa.selenium.WebDriver;

public class BaseTest 
{
	public WebDriver driver;  
	
      public void DriverSetUP(String BrowserName)
      {
		
		 DriverFactory.initDriver(BrowserName);   
		 driver= DriverFactory.getDriver();
      }
      public void EnterURL(String url)
      {
    	  try {
			driver.get(url);
 		} catch (Exception e) {
 			e.printStackTrace();
		}
      }
	
	  public void quitDriver() {
	       driver.quit();
	    }
}
