package vehicle;
import empty.*;
import filled.*;
import java.util.*;

public class VehicleDetails
{
	private String vehicleNumber;
	private String vehicleType;		
	private int customerId;
	
	public void setVehicleNumber(String vehicleNumber)
	{
		this.vehicleNumber=vehicleNumber;
	}
	
	public String getVehicleNumber()
	{
		return vehicleNumber;
	}
	
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType=vehicleType;
	}	
	
	public String getVehicleType()
	{
		return vehicleType;
	}
	
	public void setCustomerId(int customerId)
	{
		this.customerId=customerId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public String toString()
	{
		return " { Vehicle Type = "+vehicleType+" Vehicle Number = "+vehicleNumber+" Customer Id = "+customerId+" } ";
	}
}
