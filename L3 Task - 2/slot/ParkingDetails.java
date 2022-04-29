package slot;
import java.util.*;
import java.text.*;

public class ParkingDetails
{
	private int tokenId;
	private int floor;
	private String vehicleType;
	private String vehicleNumber;
	private int spotNumber;
	private long entryTime;
	//private SimpleDateFormat exitTime;
	private double paidAmount;
	private boolean paymentStatus=false;
	
	public void setTokenId(int tokenId)
	{
		this.tokenId=tokenId;
	}
	
	public int getTokenId()
	{
		return tokenId;
	}
	
	public void setFloor(int floor)
	{
		this.floor=floor;
	}
	
	public int getFloor()
	{
		return floor;
	}
	
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType=vehicleType;
	}
	
	public String getVehicleType()
	{
		return vehicleType;
	}
	
	public void setVehicleNumber(String vehicleNumber)
	{
		this.vehicleNumber=vehicleNumber;
	}
	
	public String getVehicleNumber()
	{
		return vehicleNumber;
	}
	
	public void setSpotNumber(int spotNumber)
	{
		this.spotNumber=spotNumber;	
	}
	
	public int getSpotNumber()
	{
		return spotNumber;
	}
	
	public void setEntryTime(long entryTime)
	{
		this.entryTime=entryTime;
	}
	
	public long getEntryTime()
	{
		return entryTime;
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
		return "TokenId ={Floor = "+floor+" Vehicle Type = "+vehicleType+" Vehicle Number = "+vehicleNumber+" Spot Number = "+spotNumber+" Entry Time = "+new Date(entryTime)+" Paid Amount = "+paidAmount+" Payment Status = "+paymentStatus+"}";
	}
}





