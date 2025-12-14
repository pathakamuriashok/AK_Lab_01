package QA.AK.ReportGeneration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import QA.AK.Utilities.FolderCreation;
import QA.AK.Utilities.Screenshots;

public class Reports {


	static com.relevantcodes.extentreports.ExtentReports report;
	static ExtentTest test;
	static String directoryPath=System.getProperty("user.dir"); 
	static String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    public static String FolderPath_AK; 
	
	public static ExtentTest ExtentReports(String ReportName)
	{
	
		String folderPath=FolderCreation.Folder(directoryPath+"\\src\\test\\java\\Screenshorts\\"+ReportName); 
		  
		//report=new com.relevantcodes.extentreports.ExtentReports(directoryPath+"\\src\\test\\java\\Screenshorts\\"+ReportName+".html");
		report=new com.relevantcodes.extentreports.ExtentReports(folderPath+"\\"+ReportName + "_" +timestamp+".html"); 
		
		 FolderPath_AK=folderPath+"\\"+ReportName;
		
		test = report.startTest("PATHAKAMURI ASHOK KUMAR ");
	
		report.endTest(test);
		
		return test;
	
	}
	
	public static void PASS(String Comment) throws IOException
	{
		test.log(LogStatus.PASS,Comment+test.addScreenCapture(Screenshots.takeScreenshot(Comment)));    
	}
	public static void FAIL(String Comment) throws IOException
	{
		test.log(LogStatus.FAIL,Comment+test.addScreenCapture(Screenshots.takeScreenshot(Comment)));  
	}
	
	public static void SKIP(String Comment) throws IOException
	{
		test.log(LogStatus.SKIP,Comment+test.addScreenCapture(Screenshots.takeScreenshot(Comment)));  
	}
	public static void INFO(String Comment) throws IOException
	{
		test.log(LogStatus.INFO,Comment+test.addScreenCapture(Screenshots.takeScreenshot(Comment)));
	}
	
	public static void ExtentReports_End()
	{
		report.flush();		
	}
}
