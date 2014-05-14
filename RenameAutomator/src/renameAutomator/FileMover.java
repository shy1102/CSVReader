package renameAutomator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileMover {
	public FileMover() {
		//default constructor
	}
	
	public void makeNewDirectory(String currentPath, ArrayList<String> newDirectoryPath) {
		for (String S: newDirectoryPath) {
			new File(currentPath + "/" + S).mkdir();			
		}
	}
	public void moveFilesToNewDirectory(String currentPath, ArrayList<String> newNameList, ArrayList<String> newDirectoryPath) throws IOException, InterruptedException {
		File folder = new File(currentPath);
	    File[] listOfFiles = folder.listFiles();
	    Arrays.sort(listOfFiles, new Comparator<File>(){
	        public int compare(File f1, File f2)
	        {
	            return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
	        } });
	    for (int i = 0; i < listOfFiles.length; i++) {
	        if (listOfFiles[i].isFile()) {
	        	System.out.println(listOfFiles[i]);
	        	String absolutePath = listOfFiles[i].getAbsolutePath();
	            File f = new File(absolutePath); 	
	            if(!f.renameTo(new File(currentPath + "/" + newDirectoryPath + "/" + listOfFiles[i] +"pdf"))){
	            	System.out.println("moving failed");
	            }
	            wait(100);
	        }
	    }
	}
}