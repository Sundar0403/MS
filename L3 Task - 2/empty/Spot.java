package empty;

public class Spot
{
	private int spotNumber;
	private String vehicleType;
	private int floor;
	
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
	
	public void setFloor(int floor)
	{
		this.floor=floor;
	}
	
	public int getFloor()
	{
		return floor;
	}
	
	public String toString()
	{
		return " { SpotNumber = "+spotNumber+", VehicleType = "+vehicleType+" , Floor = "+floor+" } ";
	}
}
