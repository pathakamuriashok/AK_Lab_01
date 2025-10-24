package QA.AK.ExcellHandling;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


/**
 * @author PATHAKAMURI ASHOK KUMAR
 * This class will be help's to get the value from XML file with the help of tag name
 */
public class GetTagName 
{
    
    	 public static String GetXMLTagValue(String tagname){
    			
    			String val=null;

    			
    			try {
    				
    				// Method to get the xml tag value from any given xml
    				
    				String Tags=System.getProperty("user.dir");
    					
    				File f = new File(Tags+"\\Data\\Tags.xml");
    				
    				DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    				
    				Document doc = docBuilder.parse(f);
    				
    				val = doc.getElementsByTagName(tagname).item(0).getTextContent();  
    				
    					
    				}
    			 catch (Exception e) {
    				System.out.println("Kindly check your xml file !!!!!!!!!!!!");
    				e.printStackTrace();
    			}
    			
    			return val;
    			
    	 }
     }

