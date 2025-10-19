package QA.AK.ExcellHandling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	   FileInputStream fin;
	   XSSFWorkbook wb;
	   static XSSFSheet ws;
	   static Row row; 
	   static Cell cell; 
	   static int LastRow; 
	   static int NumberOfCells;
	 
	   static ArrayList<String> headers;
	   
	   static HashMap<String, HashMap<String, String>> dataMap ;
	   
	   
       public XSSFSheet ExcellFile(String filepath,String fileName,String fileExtentio,String SheetName) throws IOException
       {
    	   fin=new FileInputStream(filepath+fileName+fileExtentio);
    	   wb=new XSSFWorkbook(fin);
    	   ws=wb.getSheet(SheetName);
    	   
    	   LastRow=ws.getLastRowNum();
    	   NumberOfCells=ws.getRow(0).getLastCellNum();
    	   System.out.println("Number of Rows :: "+LastRow);  
    	   GetHeaders();
    	   
		   return ws;     
       }
       
       public void GetHeaders() throws IOException
       { 
    	   
    	      headers=new ArrayList<String>();
			  
			  int LastCell=ws.getRow(0).getLastCellNum()-1;

			  for (int Columns = 0; Columns <=LastCell; Columns++) 
			  {
			  
			  headers.add(getCellValueType(ws.getRow(0).getCell(Columns))) ;
			  
			  } 	 
		
       }
       
       public static  HashMap<String, HashMap<String, String>> GetCellvalues()
       {
    	   
           dataMap = new HashMap<>();
           
           // Loop rows (skip header)
           for (int r = 1; r <= LastRow; r++) {

        	   row = ws.getRow(r);
                
               if (row == null) continue;

               String tcNo = row.getCell(0).getStringCellValue(); // TC_NO
                     
               HashMap<String, String> rowData = new HashMap<>();

               for (int c = 1; c < NumberOfCells; c++) {
         
            	   String header = headers.get(c);
                   String value=getCellValueType(row.getCell(c));
                   rowData.put(header, value);
               }

               dataMap.put(tcNo, rowData);
           }
      
           return dataMap;
    	   
       }
       
		  public static String GetData(String tcid,String header) { 
		    
			  String value="";
		  HashMap<String, HashMap<String,String>> dataMap1 = new HashMap<>(); 
		  
		  dataMap1=GetCellvalues();
	    
		  
		  try {
			  value=dataMap1.get(tcid).get(header);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			String s=e.getMessage();
			Message(s);
		}
		  return value;
		  
		  }
		  
          
     
       
       public static String getCellValueType(Cell cell) {
    	 
    	   String cellValue = "";
    	   
    	   if (cell == null) {
               return "";  // Handle null cells
           }

       
           switch (cell.getCellType()) { 
               case STRING:
                   cellValue = cell.getStringCellValue();
                   break;

               case NUMERIC:
                   if (DateUtil.isCellDateFormatted(cell)) {
                       cellValue = cell.getDateCellValue().toString(); // Convert date to String
                   } else {
                       cellValue = String.valueOf(cell.getNumericCellValue());
                   }
                   break;

               case BOOLEAN:
                   cellValue = String.valueOf(cell.getBooleanCellValue());
                   break;

               case FORMULA:
                   // Evaluate formula and return the result
                   FormulaEvaluator evaluator = cell.getSheet().getWorkbook()
                           .getCreationHelper().createFormulaEvaluator();
                   CellValue evaluatedValue = evaluator.evaluate(cell);

                   switch (evaluatedValue.getCellType()) {
                       case STRING:
                           cellValue = evaluatedValue.getStringValue();
                           break;
                       case NUMERIC:
                           cellValue = String.valueOf(evaluatedValue.getNumberValue());
                           break;
                       case BOOLEAN:
                           cellValue = String.valueOf(evaluatedValue.getBooleanValue());
                           break;
                       default:
                           cellValue = "";
                   }
                   break;

               case BLANK:
                   cellValue = "";
                   break;

               default:
                   cellValue = "";
           }

           return cellValue.trim();
       
   }   
       public static void Message(String message)
       {
    	   String systemUser = System.getProperty("user.name");
    	   
    	   System.out.println();
           System.out.println("***********************************************************************************************");
           System.out.println("===============================================================================================");
           System.out.println("========================= ⚠️  EXCEL DATA VALIDATION ALERT ⚠️ =================================");
           System.out.println("===============================================================================================");
           System.out.println("===== Hi " + systemUser + ", please check your data sheet — it may contain:");
           System.out.println("===== → Empty cells");
           System.out.println("===== → Wrong data formats");
           System.out.println("===== → Missing test case IDs");
           System.out.println("===== → Missing test data in cells");
           System.out.println("-----------------------------------------------------------------------------------------------");
           System.out.println("Message: " + message);
           System.out.println("===============================================================================================");
           System.out.println("***********************************************************************************************");
           System.out.println();
		
       }
}
