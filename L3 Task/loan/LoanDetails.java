package loan;
import java.util.*;

public class LoanDetails
{
	private int actId;
	private int loanId;
	public Map<String,Double> loanMap=new HashMap<>();
	private double loanAmount;
	private String loanType;
	private int loanCount;
	private boolean loanPending=true;
	private boolean loanApproval=false;
	
	public LoanDetails()
	{
		loanMap.put("EducationLoan",200000.0);
		loanMap.put("HousingLoan",600000.0);
		loanMap.put("GoldLoan",300000.0);
		loanMap.put("PersonalLoan",500000.0);
	}
	
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
	
	public void setLoanType(String loanType)
	{
		this.loanType=loanType;
	}
	
	public String getLoanType()
	{
		return loanType;
	}
	
	public void setLoanCount(int loanCount)
	{
		this.loanCount=loanCount;
	}
	
	public int getLoanCount()
	{
		return loanCount;
	}
	
	public void setLoanPending(boolean loanPending)
	{
		this.loanPending=loanPending;
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
		return "LoanId ="+loanId +" {"+"Loan Amount="+loanAmount+" , "+"LoanType="+loanType+","+"Loan Count="+loanCount+" , "+"Loan Pending="+loanPending+" , "+" Loan Approval="+loanApproval+"}";
	}
}
