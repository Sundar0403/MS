package slot;
import java.util.*;
import java.text.*;

public class ParkingDetails
{
	private int tokenId;
	private int floor;
	private String vehicleType;
	private int spotNumber;
	private long entryTime;
	//private SimpleDateFormat exitTime;
	//private double payableAmount;
	private boolean paymentStatus=false;
	
	public void setTokenId(int tokenId)
	{
		this.tokenId=tokenId;
	}
	
	public int getTokenId()
	{
		return tokenId;
	}
	
	public void setSpotNumber(int spotNumber)
	{
		this.spotNumber=spotNumber;	
	}
	
	public int getSpotNumber()
	{
		return spotNumber;
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
	
	/*public void setParkingCount(int parkingCount)
	{
		this.parkingCount=parkingCount;
	}
	
	public int getParkingCount()
	{
		return parkingCount;
	}*/
	
	public void setEntryTime(long entryTime)
	{
		this.entryTime=entryTime;
	}
	
	public long getEntryTime()
	{
		return entryTime;
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
		return "TokenId ={Floor = "+floor+" Vehicle Type = "+vehicleType+" Entry Time = "+new Date(entryTime)+" Payment Status = "+paymentStatus+"}";
	}
}





