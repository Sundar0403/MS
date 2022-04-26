package payment;
import java.util.*;

public class PaymentGateway
{
	private int tokenId;
	private double payableAmount;
	private double paidAmount=0.0;
	private Date exitTime;
	private boolean paymentStatus=false;
	
	public void setTokenId(int tokenId)
	{
		this.tokenId=tokenId;
	}
	
	public int getTokenId()
	{
		return tokenId;
	}
	
	public void setExitTime(Date exitTime)
	{
		this.exitTime=exitTime;
	}
	
	public Date getExitTime()
	{
		return exitTime;
	}
	
	public void setPaidAmount(double paidAmount)
	{
		this.paidAmount=paidAmount;
	}
	
	public double getPaidAmount()
	{
		return paidAmount;
	}
	
	public void setPaymentStatus(boolean paymentStatus)
	{
		this.paymentStatus=paymentStatus;
	}
	
	public boolean getPaymentStatus()
	{
		return paymentStatus;
	}
	
	public String toString()
	{
		return "TokenId ={Exit Time = "+exitTime+" Paid Amount = "+paidAmount+" Payment Status = "+paymentStatus+"}";
	}
}
