package renameAutomator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class commandCenter {
	private String currentPath;
	private String CSVPath;
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
		FileMover mainFileMover = new FileMover();
		UserPathSelectorGUI mainUserPathSelectorGUI = new UserPathSelectorGUI();
		String CSVPath = mainUserPathSelectorGUI.getCSVAbsolutePath();
		String directoryPath = mainUserPathSelectorGUI.getDestinationAbsolutePath() + "/";
		System.out.println("Processing");
		renamedDirectoryPath = mainRenamer.renameFilesInDirectory(directoryPath, mainReader.readCSV(CSVPath));
		ArrayList<String> destList = mainReader.getTeamName();
		mainFileMover.makeNewDirectory(directoryPath, destList);
		mainFileMover.moveFilesToNewDirectory(mainFileMover.getCurrentPath(), destList);
	}
	public static void main(String[] args) throws IOException, InterruptedException{
		commandCenter.run();
		//documenting the parameters + needs for the jobs
		//
	}
}
