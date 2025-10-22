package QA.AK.ExcellHandling;

import java.io.IOException;

public class Check {

	public static void main(String[] args) throws IOException {
		
		ExcelUtils e=new ExcelUtils();
		//e.ExcellFile("D:\\Git\\Lab1 git\\AK\\Data\\", "Data",".xlsx", "TC_001");
	//	String value=e.GetData("TC_005","UserName");
	//	System.out.println("Values ::: "+value);
		
		GetTagName g=new GetTagName();
		
		String str1=g.GetXMLTagValue("Data_xl_path");
		String str2=g.GetXMLTagValue("XLFile_Name");
     	String str3=g.GetXMLTagValue("XLFile_Extention");
		
		System.out.println("=====> "+str1);
		System.out.println("=====> "+str2);
		System.out.println("=====> "+str3);
		
		
	}

}
