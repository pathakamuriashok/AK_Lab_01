package QA.AK.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import QA.AK.DriverSetUP.BaseTest;
import QA.AK.Pages.LoginPage;
import QA.AK.Utilities.ElementActions;

public class TC_001 extends BaseTest
{
	
	LoginPage loginpage=new LoginPage();
	
	ElementActions a;
	
         @BeforeMethod
         public void m1()
         {
        	 DriverSetUP("chrome");
        	 a=new ElementActions(driver);
        	  
         }
         @Test
         public void m2()
         {
        	 EnterURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        	 Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
        	 a.EnterText(loginpage.Username, "Admin");
        	 a.EnterText(loginpage.Psw(), "admin123");        
        	 a.Click(loginpage.LoginBtn); 
             
         }
         @AfterMethod
         public void quit()
         {
        	 quitDriver();
         }
}
