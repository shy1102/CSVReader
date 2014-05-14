package renameAutomator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class commandCenter {
	private commandCenter commandCenterInstance; //instance of a command center. Only a singleton instance is allowed
	public commandCenter(){
		if(commandCenterInstance == null) {
			commandCenterInstance = new commandCenter();
		}
	}
	public static void run() throws IOException, InterruptedException{
		String renamedDirectoryPath;
		CSVReader mainReader = new CSVReader();
		Renamer mainRenamer = new Renamer();
//		FileMover mainFileMover = new FileMover();
//		ArrayList<String> destList = mainReader.getTeamName();
		System.out.println("Processing");
		String CSVPath = "/Users/Automation/Desktop/Automation Test/Aaron-Donald-Data.csv";
		String directoryPath = "/Users/Automation/Desktop/Automation Test/";
		renamedDirectoryPath = mainRenamer.renameFilesInDirectory(directoryPath, mainReader.readCSV(CSVPath));
		
	}
	public static void main(String[] args) throws IOException, InterruptedException{
		commandCenter.run();
		
	}
}
