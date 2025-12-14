package QA.AK.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import QA.AK.DriverSetUP.DriverFactory;
import QA.AK.ExcellHandling.ExcelUtils;
import QA.AK.PageBusinessLogics.LoginPage;
import QA.AK.ReportGeneration.Reports;

public class TC_001 extends DriverFactory
{
	ExtentTest test;
	
	@BeforeSuite
	public void Report()
	{
		 test=Reports.ExtentReports("TC_001");
	}
	
	@BeforeClass
	
	public void IntiateDriver() throws IOException
	{
		try {
			  initDriver("chrome");  
			} catch (Exception e) {
			 Reports.FAIL("Browser is NOT Launched !!");  
		}
		 
	}
	
	 @BeforeMethod
	  
	  public void URLLaunch() throws IOException {
	
		 try {
			 driver.get(ExcelUtils.GetData("TC_001", "URL"));  
		 	 Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
		 	 Reports.PASS("User is able to open URL As expected");  
		 	 
		} catch (Exception e) {
			 Reports.FAIL("User is NOT able to open URL As expected");  
		}	 	 
	 }

         @Test
         public void LoginLogics() throws IOException, InterruptedException
         {  
        	 
        	 LoginPage loginpage=new LoginPage(driver,"TC_001");	
        	 try {
        		 loginpage.login();
         		 Reports.PASS("User is able to Login as expected");  
			} catch (Exception e) {
				 Reports.FAIL("User is NOT able to Login as expected"); 
			}
         }
         @AfterMethod
         public void quit()
         {
        	 driver.quit();
         }
         
         @AfterSuite
         public void reportend()
         {
        	 Reports.ExtentReports_End();
         }
}