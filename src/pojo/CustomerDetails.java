package pojo;

public class CustomerDetails implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8759154885224469485L;
	private int customerId;
	private boolean customerStatus=true;
	private String customerName;
	private String customerAddress;
	private long mobileNumber;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public boolean isCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(boolean customerStatus) {
		this.customerStatus = customerStatus;
	}
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
		return "CustomerDetails [customerStatus=" + customerStatus + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
