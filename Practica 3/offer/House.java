package offer;

import java.io.Serializable;

/**
 * House class. It represents the houses of our system
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class House implements Serializable{
	/**
	 * City: city of the house
	 * Zip: zip code of the house
	 * Description: Features about the house
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private int zip;
	private String description;
	
	/**
	 * Creates a new house
	 * @param city city of the house
	 * @param zip zip code of the house
	 * @param description features about the house
	 */
	public House(String city, int zip, String description) {
		this.city = city;
		this.zip = zip;
		this.description = description;
	}	
	/**
	 * Return the city of the house
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Set a new city for the house
	 * @param city City of the house
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Return the zip code of the house
	 * @return zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * Set a new zip code for the house
	 * @param zip Zip code of the house
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * Return the description of the house
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Set a new description for the house
	 * @param description Description of the house
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		String res = "House:\n";
		return res + "City: " + city + "\nZip code: " + zip + "\nDescription: " + description;
	}
	
}
