package QA.AK.Utilities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import QA.AK.DriverSetUP.BaseTest;

public class Check extends BaseTest
{
	
	ElementActions a;
	
	@BeforeClass
	public void initDriver()
	{
		DriverSetUP("chrome");
   	    a=new ElementActions(driver);
	}
	
     @BeforeMethod
     public void BrowserLaunch()
     { 
    	 
    	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  
     }
     
     @Test
     public void m()
     {
    	 Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
    	 
    	 a.EnterText(By.name("username"), "Admin");
    	 a.EnterText(By.name("password"), "admin123");
    	 a.Click(By.xpath("//button[@type='submit']"));  
     }
     @AfterMethod
     public void CloseBrowser()
     {
    	 quitDriver();
     }
     @AfterClass
     public void M1()
     {
    	 System.out.println("Congratulation!!!!!!!!!!!!!!!!!!!!!!");
     }
}
