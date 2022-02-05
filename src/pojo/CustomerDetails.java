package pojo;

public class CustomerDetails {
	private String customerName;
	private String customerAddress;
	private long mobileNumber;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "CustomerDetails [AccountHolderName=" + customerName + ", AccountHolderAddress=" + customerAddress +  ", mobileNumber=" + mobileNumber + "]";
	}
	
}
