package renameAutomator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Renamer {
	public Renamer() {// constructor
		
	}
	public String renameFilesInDirectory(String Path, ArrayList<String> newNameList) throws IOException, InterruptedException {
		File folder = new File(Path);
	    //File folder = new File("\\Projects\\sample");
	    File[] listOfFiles = folder.listFiles();
	    new File(Path + "newNames").mkdir();
	    int pdfNamePositionCounter = 0;
	    Arrays.sort(listOfFiles, new Comparator<File>(){
	        public int compare(File f1, File f2)
	        {
	            return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
	        } });
	    //some sorting mechanicsm
	    for (int i = 0; i < listOfFiles.length; i++) {
	        if (listOfFiles[i].isFile() && isPDF(listOfFiles[i])) {
	        	System.out.println(listOfFiles[i]);
	        	String absolutePath = listOfFiles[i].getAbsolutePath();
	            File f = new File(absolutePath); 	
	            //File f = new File("c:\\Projects\\sample\\"+listOfFiles[i].getName()); 
	            //f.renameTo(new File("c:\\Projects\\sample\\"+i+".txt"));
	            String tempString;
	            tempString = newNameList.get(pdfNamePositionCounter);
	            System.out.println(tempString);
	            if(!f.renameTo(new File(Path + "/newNames/" + tempString +"pdf"))){
	            	System.out.println("rename failed");
	            }
	            wait(100);
	            pdfNamePositionCounter++;
	        }
	    }
	    return Path + "newNames";
	}
	public boolean isPDF(File file) throws FileNotFoundException{
		 FileReader reader = new FileReader(file);
			Scanner input = new Scanner(reader);
		    while (input.hasNextLine()) {
		        final String checkline = input.nextLine();
		        if(checkline.contains("%PDF-")) { 
		        	return true;
		        }
		    }
		    return false;
		}
}
