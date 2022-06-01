package user;

public class UserDetails {
	
	private String userName;
	private String emailId;
	private long mobileNo;
	private int h_ID;
	private String password;
	private double intial_RC_deposit;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getH_ID() {
		return h_ID;
	}
	public void setH_ID(int h_ID) {
		this.h_ID = h_ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getIntial_RC_deposit() {
		return intial_RC_deposit;
	}
	public void setIntial_RC_deposit(double intial_RC_deposit) {
		this.intial_RC_deposit = intial_RC_deposit;
	}
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", h_ID="
				+ h_ID + ", password=" + password + ", intial_RC_deposit=" + intial_RC_deposit + "]";
	}
	
	
	
	
}
