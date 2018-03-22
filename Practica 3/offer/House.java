package offer;

public class House {
	
	private String city;
	private int zip;
	private String description;
	
	public House(String city, int zip, String description) {
		this.city = city;
		this.zip = zip;
		this.description = description;
	}	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
