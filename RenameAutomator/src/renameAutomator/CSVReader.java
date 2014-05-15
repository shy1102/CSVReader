package renameAutomator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class CSVReader {
	private ArrayList<String> productCode;
	private ArrayList<String> teamName;
	public CSVReader() {
		// TODO Auto-generated constructor stub
	}		 
	/**
	 * reads a CSV and grabs data
	 * @param Path CSV absolute path
	 * @param position
	 * @return
	 */
		  public ArrayList<String> readCSV(String Path) {
			String csvFile = Path;

			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			productCode = new ArrayList<String>();
			teamName = new ArrayList<String>();
			teamName.clear();
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
					if (!country[1].equals("Team Name") && !productCode.contains(country[1])) {
						teamName.add(country[1]);
						System.out.println("teamname is : " + country[1]);
					}
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
			setTeamName(replaceSpacesFromNames(teamName));
			System.out.println("Reading CSV completed");
			return productCode;
		  }
		  
	public ArrayList<String> replaceSpacesFromNames(ArrayList<String> temp) {
		ArrayList<String> newList = new ArrayList<String>();
		newList.clear();
		for(int i = 0; i < temp.size(); i++ ) {
			newList.add(temp.get(i).replace(' ', '_'));
			System.out.println(temp.get(i).replace(' ', '_'));
		}
		return newList;
	}
	/**
	 * @return the productCode
	 */
	public ArrayList<String> getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(ArrayList<String> productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the teamName
	 */
	public ArrayList<String> getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(ArrayList<String> teamName) {
		this.teamName = teamName;
	}
		 
		}
