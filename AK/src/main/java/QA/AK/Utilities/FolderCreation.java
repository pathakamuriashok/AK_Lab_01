package QA.AK.Utilities;

import java.io.File;

public class FolderCreation {

	public static String Folder(String folderPath)  
	{
	    // Create a File object
        File folder = new File(folderPath);

        // Check if folder already exists
        if (!folder.exists()) {
            // Create the folder
            boolean created = folder.mkdir();  // Use mkdirs() to create nested folders
            if (created) {
                System.out.println("Folder created: " + folder.getAbsolutePath());
            } else {
                System.out.println("Failed to create folder!");
            }
        } else {
            System.out.println("Folder already exists: " + folder.getAbsolutePath());
        }
      	return folder.getAbsolutePath();   
    }
}
