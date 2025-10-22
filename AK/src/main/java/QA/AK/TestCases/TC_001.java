package QA.AK.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import QA.AK.DriverSetUP.DriverFactory;
import QA.AK.ExcellHandling.ExcelUtils;
import QA.AK.PageBusinessLogics.LoginPage;

public class TC_001 extends DriverFactory
{
	
	@BeforeClass
	
	public void IntiateDriver()
	{
		  initDriver("chrome");  
	}
	
	 @BeforeMethod
	  
	  public void URLLaunch() throws IOException {
	
		 driver.get(ExcelUtils.GetData("TC_001", "URL"));  
	 	 Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
	 }

         @Test
         public void LoginLogics() throws IOException, InterruptedException
         {  
        	 
        	 LoginPage loginpage=new LoginPage(driver,"TC_001");	
        	 
          	 loginpage.login();
         
         }
         @AfterMethod
         public void quit()
         {
        	 driver.quit();
         }
}