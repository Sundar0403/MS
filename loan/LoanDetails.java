package loan;

public class LoanDetails
{
	private int actId;
	private int loanId;
	private double loanAmount;
	private double loanEmi;
	private boolean loanPending=true;
	private boolean loanApproval=false;
	
	public void setActId(int actId)
	{
		this.actId=actId;
	}
	
	public int getActId()
	{
		return actId;
	} 
	
	public void setLoanId(int loanId)
	{
		this.loanId=loanId;
	}
	
	public int getLoanId()
	{
		return loanId;
	}
	
	public void setLoanAmount(double loanAmount)
	{
		this.loanAmount=loanAmount;
	}
	
	public double getLoanAmount()
	{
		return loanAmount;
	}
	
	public void setLoanEmi(double loanEmi)
	{
		this.loanEmi=loanEmi;
	}
	
	public double getLoanEmi()
	{
		return loanEmi;
	}
	
	public void setLoanPending(boolean loanPending)
	{
		this.loanStatus=loanStatus;
	}
	
	public boolean getLoanPending()
	{
		return loanPending;
	}
	
	public void setLoanApproval(boolean loanApproval)
	{
		this.loanApproval=loanApproval;
	}
	
	public boolean getLoanApproval()
	{
		return loanApproval;
	}
	
	public String toString()
	{
		return "LoanId ="+loanId +" {"+"Loan Amount="+loanAmount+" , "+"Loan EMI="+loanEmi+" , "+"Loan Pending="+loanStatus+" , "+" Loan Approval="+loanApproval+"}";
	}
}
