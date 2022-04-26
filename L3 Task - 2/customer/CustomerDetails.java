package customer;
import java.util.*;

public class CustomerDetails
{
	private int tokenId;
	private int spotNumber;
	private String vehicleType;
	private String vehicleName;
	
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
	
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType=vehicleType;
	}
	
	public String getVehicleType()
	{
		return vehicleType;
	}
	
	public void setVehicleName(String vehicleName)
	{
		this.vehicleName=vehicleName;
	}
	
	public String getVehicleName()
	{
		return vehicleName;
	}
	
	public String toString()
	{
		return "TokenId ={Vehicle Type = "+vehicleType+" Vehicle Name = "+vehicleName+"}";
	}
}
