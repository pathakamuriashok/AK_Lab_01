package QA.AK.DriverSetUP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public static WebDriver driver;
 
	
	 public static void initDriver(String browser) {
	      
		   try {
	            switch (browser.toLowerCase()) {
	            
	                case "chrome":
	                    WebDriverManager.chromedriver().setup();
	                    ChromeOptions options = new ChromeOptions();
	                    options.addArguments("--incognito"); 
	                    options.addArguments("--start-maximized");
	                    driver=new ChromeDriver(options);
	                    
	                    break;
	                    
	                case "edge":
	                    WebDriverManager.edgedriver().setup();
                         driver=new EdgeDriver();
                        
	                    break;
	                    
	                case "firefox":
	                    WebDriverManager.firefoxdriver().setup();
	                     driver=new FirefoxDriver();
	                    break;
	                    
	                default:
	                    throw new IllegalArgumentException("Invalid browser: " + browser);
	            
	        }
		   } catch (Exception e) {
			   System.out.println("Please provide valide Browser Name");
			    e.getMessage();
				e.printStackTrace();
			}
	    }
	 
	   public static WebDriver getDriver()
       {
    	  
		   return driver;
       }     
}
