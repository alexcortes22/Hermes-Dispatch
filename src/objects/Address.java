package objects;
/**
 * 
 */

/**
 * @author Ratthead
 *
 */
public class Address {
	private int houseNum;
	private String street;
	private String city;
	private int zip;
	
	//constructor
	public Address() {
		
	}
	
	//overloaded constructor
	public Address(int h, String s, String c, int z) {
		this.houseNum = h;
		this.street = s;
		this.city = c;
		this.zip = z;
	}

	/**
	 * @return the houseNum
	 */
	public int getHouseNum() {
		return houseNum;
	}

	/**
	 * @param houseNum the houseNum to set
	 */
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
}
