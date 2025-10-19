package QA.AK.ExcellHandling;

import java.io.IOException;

public class Check {

	public static void main(String[] args) throws IOException {
		
		ExcelUtils e=new ExcelUtils();
		e.ExcellFile("D:\\Git\\Lab1 git\\AK\\Data\\", "Data",".xlsx", "TC_001");
		e.GetData();

	}

}
