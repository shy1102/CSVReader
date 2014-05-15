package renameAutomator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FileMover {
	private List<String> newDirectoryList;
	private String currentPath;
	/**
	 * constructor
	 */
	public FileMover() {
		this.newDirectoryList = new ArrayList<String>();
	}
	/**
	 * makes new directories based off of team names
	 * @param currentPath
	 * @param newDirectoryPath
	 */
	public void makeNewDirectory(String currentPath, ArrayList<String> newFoldernames) {
		this.newDirectoryList.clear();
		for(int i = 0; i < newFoldernames.size(); i++) {
			new File(currentPath + "newNames/" + newFoldernames.get(i)).mkdir();
			newDirectoryList.add(currentPath + "newNames/" + newFoldernames.get(i));
			System.out.println(currentPath + "newNames/" + newFoldernames.get(i));
		}
		setCurrentPath(currentPath + "newNames/");
	}
	public void moveFilesToNewDirectory(String currentPath, ArrayList<String> newFoldernames) throws IOException, InterruptedException {
		File folder = new File(currentPath);
	    File[] listOfFiles = folder.listFiles();
	    sortFileByModifiedTime(listOfFiles);
	    int pdfPositionCounter = 0;
	    for (int i = 0; i < listOfFiles.length; i++) {
	        if (listOfFiles[i].isFile() && isPDF(listOfFiles[i])) {
	        	String absolutePath = listOfFiles[i].getAbsolutePath();
	            File f = new File(absolutePath); 	
	            if(!f.renameTo(new File(currentPath + newFoldernames.get(pdfPositionCounter) + "/" + listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 3) + ".pdf"))){
	            	System.out.println("moving failed");
	            	System.out.println(currentPath);
	            	System.out.println(newFoldernames.get(pdfPositionCounter));
	            	System.out.println(listOfFiles[i].getName().replaceFirst("pdf", ".pdf"));	            	
	            }
	            System.out.println(listOfFiles[i]);
            	System.out.println(currentPath + newFoldernames.get(pdfPositionCounter) + "/" + listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 3) + ".pdf");	            	
	            pdfPositionCounter++;
	        }
	    }
	}
	/**
	 * sorts file by last modified time
	 * @param files
	 */
    public void sortFileByModifiedTime(File[] files) {
	    Arrays.sort(files, new Comparator<File>(){
	        public int compare(File f1, File f2)
	        {
	            return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
	        } });
    }
	// MAKE SURE TO MAKE THIS INTO AN INTERFACE LATER BOTH RENAMES AND Mover uses it
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
	 * @return the currentPath
	 */
	public String getCurrentPath() {
		return currentPath;
	}
	/**
	 * @param currentPath the currentPath to set
	 */
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
}