package QA.AK.Utilities;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import QA.AK.DriverSetUP.DriverFactory;

/**
 * @author PATHAKAMURI ASHOK KUMAR
 * This class will helps to get the Web Element actions 
 */
public class ElementActions extends DriverFactory
{
	private WebDriver driver;
    private WebDriverWait wait;
    
	public ElementActions(WebDriver driver)  
	{
		//this.driver=driver;
		//driver=this.driver;
		driver=DriverFactory.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	/**
	 * This Method will helps to Enter the Text in to filed
	 * @param locater
	 * @param value
	 * @author PATHAKAMURI ASHOK KUMAR
	 */
     public void EnterText(By locater,String value)
     {
    	 WebElement element;
    	
    	 try {
    		 
    		 element=driver.findElement(locater);  
    		 element.clear();
    		 element.sendKeys(value);  
    		 
		} catch (Exception e) {
		     
		     element=wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
		     element.clear();
		     element.sendKeys(value);  
		}
    	 
     }
     
 	/**
 	 * This Method will helps to click on the filed
 	 * @param locater
 	 * @author PATHAKAMURI ASHOK KUMAR
 	 */
     public void Click(By locater)
     {
    	 WebElement element;
    	 try {
    		 element=wait.until(ExpectedConditions.elementToBeClickable(locater));    		
    		 element.click();

		} catch (Exception e) {
			 element=driver.findElement(locater);
			 element.click();
			e.printStackTrace();
			e.getMessage();
		}
     }
     /**
  	 * This Method will helps to Get the Text from the web page
  	 * @param locater
  	 * @author PATHAKAMURI ASHOK KUMAR
  	 */
     public String GetText(By locater) 
     {
    	 WebElement element;
    	 String text="";
    	 try {
    		 element=driver.findElement(locater);  	
    		 text=element.getText();

		} catch (Exception e) {
			 element=wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
		 	 text=element.getText();
			 e.printStackTrace();
			 e.getMessage();
		}
    	 return text;
     }
}
