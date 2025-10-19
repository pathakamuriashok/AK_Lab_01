package QA.AK.ExcellHandling;

import java.io.FileInputStream;
import java.io.IOException;
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
	   XSSFSheet ws;
	   Row r;
	   Cell c;
	   
	   
       public XSSFSheet ExcellFile(String filepath,String fileName,String fileExtentio,String SheetName) throws IOException
       {
    	   fin=new FileInputStream(filepath+fileName+fileExtentio);
    	   wb=new XSSFWorkbook(fin);
    	   ws=wb.getSheet(SheetName);
          
		   return ws;     
       }
       
       public void GetData() throws IOException
       { 
    	   int LastRow=ws.getLastRowNum();
    	   System.out.println("Number of Rows in the "+LastRow);  
    	  
    	   for (int Rows = 0; Rows <=LastRow; Rows++) {
			   int LastCell=ws.getRow(Rows).getLastCellNum()-1;
    		   for (int Columns = 0; Columns <=LastCell; Columns++) {
    			    
    			//   CellType a=ws.getRow(Rows).getCell(Columns).getCellType();  
    			 //  System.out.println("Cell type :: "+a); 
    			   String cellvalue=getCellValue(ws.getRow(Rows).getCell(Columns));
    			   System.out.println(cellvalue); 
    			
    		   }
		}
    	   
       }
       
       public static String getCellValue(Cell cell) {
           if (cell == null) {
               return "";  // Handle null cells
           }

           String cellValue = "";
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
       
       /*
       public void GetData2(String filepath,String fileName,String fileExtentio,String SheetName) throws IOException
       {
    	   fin=new FileInputStream(filepath+fileName+fileExtentio);
    	   wb=new XSSFWorkbook(fin);
    	   ws=wb.getSheet(SheetName);
           
    	   int LastRow=ws.getLastRowNum();
    	   System.out.println("Number of Rows in the "+SheetName+" are "+LastRow);  
    	  
    	   for (int Rows = 0; Rows <=LastRow; Rows++) {
			 
    		   int LastCell=ws.getRow(Rows).getLastCellNum();
    		   
    		   for (int Columns = 0; Columns <=LastCell; Columns++) {
    			   
    			   String s=ws.getRow(Rows).getCell(Columns).getStringCellValue();
    			   System.out.println(s);  
    		   }
		}
    	   
       }*/
}
