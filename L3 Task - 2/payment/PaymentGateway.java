package payment;
import java.util.*;

public class PaymentGateway
{
	private int tokenId;
	private String paymentMode;
	private double paidAmount=0.0;
	private long exitTime;
	private boolean paymentStatus=false;
	
	public void setTokenId(int tokenId)
	{
		this.tokenId=tokenId;
	}
	
	public int getTokenId()
	{
		return tokenId;
	}
	
	public void setExitTime(long exitTime)
	{
		this.exitTime=exitTime;
	}
	
	public long getExitTime()
	{
		return exitTime;
	}
	
	public void setPaymentMode(String paymentMode)
	{
		this.paymentMode=paymentMode;
	}
	
	public String setPaymentMode()
	{
		return paymentMode;
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
		return "TokenId ={Exit Time = "+new Date(exitTime)+" Payment Mode = "+paymentMode+" Paid Amount = $"+paidAmount+" Payment Status = "+paymentStatus+"}";
	}
}
