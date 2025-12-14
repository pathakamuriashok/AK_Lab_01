package QA.AK.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import QA.AK.DriverSetUP.DriverFactory;
import QA.AK.ReportGeneration.Reports;

public class Screenshots extends DriverFactory
{
	static String directoryPath=System.getProperty("user.dir"); 
	
	public static String takeScreenshot(String ScreenshotName) throws IOException { 
		
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
   //     String filePath = directoryPath+"\\src\\test\\java\\Screenshorts\\" + ScreenshotName + "_" + timestamp + ".png";
      
     //   String filePath = Reports.a+"\\" + ScreenshotName + "_" + timestamp + ".png";    --> this will create subfolder and keep all screenshots in that folder
         String filePath = Reports.FolderPath_AK + ScreenshotName + "_" + timestamp + ".png";
        
        File destFile = new File(filePath);
        FileUtils.copyFile(srcFile, destFile);
        
        return destFile.getAbsolutePath();
    }
}
