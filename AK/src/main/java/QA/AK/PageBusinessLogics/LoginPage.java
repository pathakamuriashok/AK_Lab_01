package QA.AK.PageBusinessLogics;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import QA.AK.ExcellHandling.ExcelUtils;
import QA.AK.PagesObjects.LoginPage_Locaters;
import QA.AK.Utilities.ElementActions;

public class LoginPage 
{
	WebDriver driver;
	String TC_ID="";
	
	ExcelUtils data=new ExcelUtils();
	ElementActions a=new ElementActions(driver);
	LoginPage_Locaters loginpage=new LoginPage_Locaters();

	
	public LoginPage(WebDriver driver,String TestCaseName)
	{
		driver=this.driver;
		TC_ID=TestCaseName;		
	}
	
    public void login() throws IOException  
    {
    	 a.EnterText(loginpage.Username,ExcelUtils.GetData(TC_ID, "UserName"));  
    	 a.EnterText(loginpage.Psw(), ExcelUtils.GetData(TC_ID, "Password"));         
    	 a.Click(loginpage.LoginBtn); 
    }
}