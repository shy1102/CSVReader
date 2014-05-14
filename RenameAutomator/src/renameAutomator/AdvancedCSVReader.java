package renameAutomator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AdvancedCSVReader {
	private String csvFileName;
	private Set<String> productCodeList;
	private Set<String> teamName;
	private ArrayList<String> series;
	private ArrayList<String> firstName;
	private ArrayList<String> lastName;
	private ArrayList<String> jerseyImage;
	private ArrayList<String> jerseyArtwork;
	private ArrayList<String> helmetRender;
	private ArrayList<String> frontRender;
	private ArrayList<String> faceArtwork;
	private ArrayList<String> vectorTeamHelmet;
	private ArrayList<String> vectorTeamLogo;
	private ArrayList<String> upc;
	
	public AdvancedCSVReader(String Path, String CSVFileName) {
		this.setCsvFileName(CSVFileName);
		initialize();
		//constructor
	}
	
	public void initialize() {
		this.setProductCodeList(new HashSet<String>());
		this.setTeamName(new HashSet<String>());
		this.setSeries(new ArrayList<String>());
		this.setFirstName(new ArrayList<String>());
		this.setLastName(new ArrayList<String>());
		this.setJerseyImage(new ArrayList<String>()); 
		this.setJerseyArtwork(new ArrayList<String>()); 
		this.setHelmetRender(new ArrayList<String>()); 
		this.setFrontRender(new ArrayList<String>()); 
		this.setFaceArtwork(new ArrayList<String>()); 
		this.setVectorTeamHelmet(new ArrayList<String>()); 
		this.setVectorTeamLogo(new ArrayList<String>()); 
		this.upc = new ArrayList<String>(); 
	}
	  public ArrayList<String> readCSV(String Path) {
		//String csvFile = "/Users/Automation/Desktop/Automation Test/Aaron-Donald-Data.csv";
		String csvFile = Path;

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String> productCode = new ArrayList<String>();
		productCode.clear();
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] country = line.split(cvsSplitBy);
				if(!country[0].equals("Product Code") && !productCode.contains(country[0])) {
					productCode.add(country[0]);
				//	System.out.println("Proudct Code added " + country[0]);
				}
				//System.out.println("Proudct Code " + country[0] 
	            //                     + " , name=" + country[5] + "]");
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
		return productCode;
	  }

	/**
	 * @return the csvFileName
	 */
	public String getCsvFileName() {
		return csvFileName;
	}

	/**
	 * @param csvFileName the csvFileName to set
	 */
	public void setCsvFileName(String csvFileName) {
		this.csvFileName = csvFileName;
	}

	/**
	 * @return the series
	 */
	public ArrayList<String> getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(ArrayList<String> series) {
		this.series = series;
	}

	/**
	 * @return the productCodeList
	 */
	public Set<String> getProductCodeList() {
		return productCodeList;
	}

	/**
	 * @param productCodeList the productCodeList to set
	 */
	public void setProductCodeList(Set<String> productCodeList) {
		this.productCodeList = productCodeList;
	}

	/**
	 * @return the teamName
	 */
	public Set<String> getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(Set<String> teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the firstName
	 */
	public ArrayList<String> getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(ArrayList<String> firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public ArrayList<String> getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(ArrayList<String> lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the jerseyImage
	 */
	public ArrayList<String> getJerseyImage() {
		return jerseyImage;
	}

	/**
	 * @param jerseyImage the jerseyImage to set
	 */
	public void setJerseyImage(ArrayList<String> jerseyImage) {
		this.jerseyImage = jerseyImage;
	}

	/**
	 * @return the jerseyArtwork
	 */
	public ArrayList<String> getJerseyArtwork() {
		return jerseyArtwork;
	}

	/**
	 * @param jerseyArtwork the jerseyArtwork to set
	 */
	public void setJerseyArtwork(ArrayList<String> jerseyArtwork) {
		this.jerseyArtwork = jerseyArtwork;
	}

	/**
	 * @return the helmetRender
	 */
	public ArrayList<String> getHelmetRender() {
		return helmetRender;
	}

	/**
	 * @param helmetRender the helmetRender to set
	 */
	public void setHelmetRender(ArrayList<String> helmetRender) {
		this.helmetRender = helmetRender;
	}

	/**
	 * @return the frontRender
	 */
	public ArrayList<String> getFrontRender() {
		return frontRender;
	}

	/**
	 * @param frontRender the frontRender to set
	 */
	public void setFrontRender(ArrayList<String> frontRender) {
		this.frontRender = frontRender;
	}

	/**
	 * @return the faceArtwork
	 */
	public ArrayList<String> getFaceArtwork() {
		return faceArtwork;
	}

	/**
	 * @param faceArtwork the faceArtwork to set
	 */
	public void setFaceArtwork(ArrayList<String> faceArtwork) {
		this.faceArtwork = faceArtwork;
	}

	/**
	 * @return the vectorTeamHelmet
	 */
	public ArrayList<String> getVectorTeamHelmet() {
		return vectorTeamHelmet;
	}

	/**
	 * @param vectorTeamHelmet the vectorTeamHelmet to set
	 */
	public void setVectorTeamHelmet(ArrayList<String> vectorTeamHelmet) {
		this.vectorTeamHelmet = vectorTeamHelmet;
	}

	/**
	 * @return the vectorTeamLogo
	 */
	public ArrayList<String> getVectorTeamLogo() {
		return vectorTeamLogo;
	}

	/**
	 * @param vectorTeamLogo the vectorTeamLogo to set
	 */
	public void setVectorTeamLogo(ArrayList<String> vectorTeamLogo) {
		this.vectorTeamLogo = vectorTeamLogo;
	}
}