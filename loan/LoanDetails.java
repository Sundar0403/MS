package loan;

public class LoanDetails
{
	private static int loanId;
	private static double loanAmount;
	private static double loanEmi;
	private static boolean loanStatus=true;
	
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
	
	public void setLoanStatus(boolean loanStatus)
	{
		this.loanStatus=loanStatus;
	}
	
	public boolean getLoanStatus()
	{
		return loanStatus;
	}
	
	public String toString()
	{
		return "LoanId ="+loanId +" {"+"Loan Amount="+loanAmount+" , "+"Loan EMI="+loanEmi+" , "+"Loan Status="+loanStatus+"}";
	}
}
