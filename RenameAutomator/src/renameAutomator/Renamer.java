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
	/**
	 * renames the files and puts them into a new directory
	 * @param Path
	 * @param newNameList
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String renameFilesInDirectory(String Path, ArrayList<String> newNameList) throws IOException, InterruptedException {
		File folder = new File(Path);
	    File[] listOfFiles = folder.listFiles();
	    new File(Path + "newNames").mkdir();
	    int pdfNamePositionCounter = 0;
	    sortByNumber(listOfFiles); //sorts by numbers
	    for (int i = 0; i < listOfFiles.length; i++) {
	        if (listOfFiles[i].isFile() && isPDF(listOfFiles[i])) {
	        	System.out.println(listOfFiles[i]);
	        	String absolutePath = listOfFiles[i].getAbsolutePath();
	            File f = new File(absolutePath); 	
	            String tempString;
	            tempString = newNameList.get(pdfNamePositionCounter);
	            System.out.println(tempString);
	            if(!f.renameTo(new File(Path + "/newNames/" + tempString +"pdf"))){
	            	System.out.println("rename failed");
	            }
	            Thread.sleep(1000);
	            pdfNamePositionCounter++;
	        }
	    }
	    return Path + "newNames";
	}
	/**
	 * checks whether a file is a pdf
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
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
	/**
	 * sorts pdfs based off numbering
	 * @param files
	 */
    public void sortByNumber(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i = 0;
                try {
                    int s = name.indexOf(' ')+1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(s, e);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0; // if filename does not match the format
                           // then default to 0
                }
                return i;
            }
        });
    }
}
