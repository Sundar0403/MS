package customer;
import java.util.*;

public class CustomerDetails
{
	private int tokenId;
	private int spotNumber;
	private String vehicleType;
	private String vehicleName;
	private double customerInfoWallet;
	
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
	
	public void setCustomerInfoWallet(double customerInfoWallet)
	{
		this.customerInfoWallet=customerInfoWallet;
	}
	
	public double getCustomerInfoWallet()
	{
		return customerInfoWallet;
	}
	
	public String toString()
	{
		return "TokenId ={Spot Number = "+spotNumber+" Vehicle Type = "+vehicleType+" Vehicle Name = "+vehicleName+" Customer Info Wallet = $"+customerInfoWallet+"}";
	}
}
