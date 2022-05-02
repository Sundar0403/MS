package passenger;
import java.util.*;

public class PassengerDetails
{
	private int passengerId;
	private String passengerName;
	private int passengerAge;
	private String passengerAddress;
	private String passengerGender;
	private String berthPreference;
	
	public void setPassengerId(int passengerId)
	{
		this.passengerId=passengerId;
	}
	
	public int getPassengerId()
	{
		return passengerId;
	}
	
	public void setPassengerName(String passengerName)
	{
		this.passengerName=passengerName;
	}
	
	public String getPassengerName()
	{
		return passengerName;
	}
	
	public void setPassengerAge(int passengerAge)
	{
		this.passengerAge=passengerAge;
	}
	
	public int getPassengerAge()
	{
		return passengerAge;
	}
	
	public void setPassengerAddress(String passengerAddress)
	{
		this.passengerAddress=passengerAddress;
	}
	
	public String getPassengerAddress()
	{
		return passengerAddress;
	}
	
	public void setPassengerGender(String passengerGender)
	{
		this.passengerGender=passengerGender;
	}
	
	public String getPassengerGender()
	{
		return passengerGender;
	}
	
	public void setBerthPrefernce(String berthPreference)
	{
		this.berthPreference=berthPreference;
	}
	
	public String getBerthPrefernce()
	{
		return berthPreference;
	}
	
	public String toString()
	{
		return " PassengerID = { PassengerName = "+passengerName+" Passenger Age = "+passengerAge+" PassengerAddress = "+passengerAddress+" PassengerGender = "+passengerGender+" BerthPreference = "+berthPreference+" }";
	}
}








