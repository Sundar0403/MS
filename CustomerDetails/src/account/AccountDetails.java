package account;
//import java.io.*;

public class AccountDetails implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1159782091811450246L;
	private int accountId;
	private int temp;
	private long accountNumber;
	private boolean accountStatus=true;
	private double accountBalance;
	private String branchName;
	private int customerId;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	/*public int getTemp()
	{
		temp=accountId;
		return temp;
	}*/
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public boolean isAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "AccountDetails [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountStatus="
				+ accountStatus + ", accountBalance=" + accountBalance + ", branchName=" + branchName + ", customerId="
				+ customerId + "]";
	}
	
	
	
	
}
