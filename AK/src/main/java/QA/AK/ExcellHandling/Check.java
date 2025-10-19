package QA.AK.ExcellHandling;

import java.io.IOException;

public class Check {

	public static void main(String[] args) throws IOException {
		
		ExcelUtils e=new ExcelUtils();
		e.ExcellFile("D:\\Git\\Lab1 git\\AK\\Data\\", "Data",".xlsx", "TC_001");
		//e.GetHeaders();
		String value=e.GetData("TC_738","UserName");
		String value1=e.GetData("TC_345","UserName");
		String value2=e.GetData("TC_908","UserName");
		String value3=e.GetData("TC_257","UserName");
		String value4=e.GetData("TC_267","UserName");
		String value5=e.GetData("TC_670","UserName");
		
		
		System.out.println(value); 
		System.out.println(value1); 
		System.out.println(value2); 
		System.out.println(value3); 
		System.out.println(value4); 
		System.out.println(value5); 
		
	}

}
