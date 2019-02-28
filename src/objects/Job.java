package objects;
/**
 * Class that holds a Job information
 * @author Ratthead
 *
 */
public class Job {
	private int jobNum;
	private String pickUp;
	private String dropOff;
	private String phoneNum;
	private String customerName;
	private double price;
	private String time;
	private boolean complete;
	private int jobDriver;
	
	//constructor
	public Job() {
		
	}
	
	//overloaded constructor
	public Job(int j, String p, String d, String pNum, String cName, double m, String t, boolean c, int dName) {
		this.jobNum = j;
		this.pickUp = p;
		this.dropOff = d;
		this.phoneNum = pNum;
		this.customerName = cName;
		this.price = m;
		this.time = t;
		this.complete = c;
		this.jobDriver = dName;
	}
	/**
	 * @return the jobNum
	 */
	public int getJobNum() {
		return jobNum;
	}

	/**
	 * @param jobNum the jobNum to set
	 */
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}

	/**
	 * @return the pickUp
	 */
	public String getPickUp() {
		return pickUp;
	}

	/**
	 * @param pickUp the pickUp to set
	 */
	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	/**
	 * @return the dropOff
	 */
	public String getDropOff() {
		return dropOff;
	}

	/**
	 * @param dropOff the dropOff to set
	 */
	public void setDropOff(String dropOff) {
		this.dropOff = dropOff;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the complete
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @param complete the complete to set
	 */
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	/**
	 * @return the jobDriver
	 */
	public int getJobDriver() {
		return jobDriver;
	}

	/**
	 * @param jobDriver the jobDriver to set
	 */
	public void setJobDriver(int jobDriver) {
		this.jobDriver = jobDriver;
	}
}
