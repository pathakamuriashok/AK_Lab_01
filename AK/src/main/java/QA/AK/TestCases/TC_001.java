package QA.AK.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import QA.AK.DriverSetUP.BaseTest;
import QA.AK.ExcellHandling.ExcelUtils;
import QA.AK.Pages.LoginPage;
import QA.AK.Utilities.ElementActions;

public class TC_001 extends BaseTest
{
	
	LoginPage loginpage=new LoginPage();
	
	//ExcelUtils data=new ExcelUtils();
	
	
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
        //	 EnterURL(ExcelUtils.GetData("TC_001", "URL").toString());
        	 Assert.assertEquals(true, driver.getTitle().equals("OrangeHRM"));
        	 a.EnterText(loginpage.Username,ExcelUtils.GetData("TC_001", "UserName"));  
        	 a.EnterText(loginpage.Psw(), ExcelUtils.GetData("TC_001", "Password"));         
        	 a.Click(loginpage.LoginBtn); 
             
         }
         @AfterMethod
         public void quit()
         {
        	 quitDriver();
         }
}
