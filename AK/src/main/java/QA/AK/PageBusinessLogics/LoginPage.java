package QA.AK.PageBusinessLogics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import QA.AK.ExcellHandling.ExcelUtils;
import QA.AK.PagesObjects.HomePage_Locaters;
import QA.AK.PagesObjects.LoginPage_Locaters;
import QA.AK.ReportGeneration.Reports;
import QA.AK.Utilities.ElementActions;

public class LoginPage 
{
	WebDriver driver;
	String TC_ID="";
	
	ExcelUtils data=new ExcelUtils();
	ElementActions a=new ElementActions(driver);
	LoginPage_Locaters loginpage=new LoginPage_Locaters();
	HomePage_Locaters homepage=new HomePage_Locaters();

	
	public LoginPage(WebDriver driver,String TestCaseName)
	{
		driver=this.driver;
		TC_ID=TestCaseName;		
	}
	
    public void login() throws IOException  
    {
    	 try {
    		 a.EnterText(loginpage.Username,ExcelUtils.GetData(TC_ID, "UserName")); 
      		 Reports.PASS("User is able to Enter USERNAME as expected");  
    	} catch (Exception e) {
			 Reports.FAIL("User is NOT able to Enter UserName as expected");
		}
    	 
    	 try {
    		 a.EnterText(loginpage.Psw(), ExcelUtils.GetData(TC_ID, "Password"));   
    		 Reports.PASS("User is able to Enter PASSWORD as expected"); 
    	    	
    	 } catch (Exception e) {
 			 Reports.FAIL("User is NOT able to Enter PASSWORD as expected");
 		}
    	 
    	 try {
    		 a.Click(loginpage.LoginBtn); 
    		 String Dashboard=a.GetText(homepage.HomePage_Dashboard_RibbonBar);
    		 Assert.assertEquals(true, Dashboard.equals("Dashboard"));
       		 Reports.PASS("User is able to Click on LOGIN Button as expected"); 
        } catch (Exception e) {
 			 Reports.FAIL("User is NOT able to Click on LOGIN Button as expected");
 		}
    }
}