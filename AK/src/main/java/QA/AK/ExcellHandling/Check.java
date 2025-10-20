package QA.AK.ExcellHandling;

import java.io.IOException;

public class Check {

	public static void main(String[] args) throws IOException {
		
		ExcelUtils e=new ExcelUtils();
		e.ExcellFile("D:\\Git\\Lab1 git\\AK\\Data\\", "Data",".xlsx", "TC_001");
		//e.GetHeaders();
		String value=e.GetData("TC_005","UserName");
		System.out.println("Values ::: "+value);
		
		
	}

}
