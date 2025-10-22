package QA.AK.ExcellHandling;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;


public class GetTagName 
{
    
    	 public static String GetXMLTagValue(String tagname){
    			
    			String val=null;

    			
    			try {
    				
    				// Method to get the xml tag value from any given xml
    					
    				File f = new File("D:\\Git\\Lab1 git\\AK\\Data\\Tags.xml");
    				
    				DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    				
    				Document doc = docBuilder.parse(f);
    				
    				val = doc.getElementsByTagName(tagname).item(0).getTextContent();  
    				
    					
    				}
    			 catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			return val;
    			
    		}
     }

