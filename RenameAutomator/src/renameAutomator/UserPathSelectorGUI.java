package renameAutomator;

import java.awt.Component;

import javax.swing.JFileChooser;

public class UserPathSelectorGUI extends JFileChooser {
	private String CSVAbsolutePath;
	private String DestinationAbsolutePath;
	public UserPathSelectorGUI() {
		JFileChooser j = new JFileChooser();
		j.setName("Choose the CSV File to be used");
		j.setDialogTitle("Choose the CSV File to be used");
		j.setFileSelectionMode(JFileChooser.FILES_ONLY);
		j.showOpenDialog(this);
		Component menu;
		setCSVAbsolutePath(j.getSelectedFile().getAbsolutePath());
		setDestinationAbsolutePath(j.getCurrentDirectory().toString());
	}
	/**
	 * @return the cSVAbsolutePath
	 */
	public String getCSVAbsolutePath() {
		return CSVAbsolutePath;
	}
	/**
	 * @param cSVAbsolutePath the cSVAbsolutePath to set
	 */
	public void setCSVAbsolutePath(String cSVAbsolutePath) {
		CSVAbsolutePath = cSVAbsolutePath;
	}
	/**
	 * @return the destinationAbsolutePath
	 */
	public String getDestinationAbsolutePath() {
		return DestinationAbsolutePath;
	}
	/**
	 * @param destinationAbsolutePath the destinationAbsolutePath to set
	 */
	public void setDestinationAbsolutePath(String destinationAbsolutePath) {
		DestinationAbsolutePath = destinationAbsolutePath;
	}
}