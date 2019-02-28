package objects;
/**
 * 
 */

/**
 * @author Alex Cortes
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	private String fName;
	private String lName;
	private String licenseNum;
	private Car driverCar;
	private int driverNum;
	
	//constructor
	public Driver() {
		
	}
	
	//overloaded constructor
	public Driver(String f, String l, String lNum, Car d, int dNum) {
		this.fName = f;
		this.lName = l;
		this.licenseNum = lNum;
		this.driverCar = d;
		this.driverNum = dNum;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the licenseNum
	 */
	public String getLicenseNum() {
		return licenseNum;
	}

	/**
	 * @param licenseNum the licenseNum to set
	 */
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	/**
	 * @return the driverCar
	 */
	public Car getDriverCar() {
		return driverCar;
	}

	/**
	 * @param driverCar the driverCar to set
	 */
	public void setDriverCar(Car driverCar) {
		this.driverCar = driverCar;
	}

	/**
	 * @return the driverNum
	 */
	public int getDriverNum() {
		return driverNum;
	}

	/**
	 * @param driverNum the driverNum to set
	 */
	public void setDriverNum(int driverNum) {
		this.driverNum = driverNum;
	}
}