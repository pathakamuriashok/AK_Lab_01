package QA.AK.PagesObjects;

import org.openqa.selenium.By;

/**
 * @author PATHAKAMURI ASHOK KUMAR
 * This page will have all Login Page locater information 
 */
public class LoginPage_Locaters 
{

	// if user create Locater with Public , then user can call locater by create object for this class
	public By Username=By.name("username");
	
	
	// if user create Locater with Private , Then user can call locater by creating method with return 
	private	By Password=By.name("password");
	
	public By Psw()
	{
		return Password;
	}
	
	public By LoginBtn=By.xpath("//button[@type='submit']"); 
}
