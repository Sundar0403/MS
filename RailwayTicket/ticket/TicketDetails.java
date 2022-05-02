package ticket;

public class TicketDetails
{
	private int ticketId;
	private int passengerId;
	private String fromLocation;
	private String toLocation;
	private double paidAmount;
	private String bookingStatus;
	private int seatNo;
	private String berthAlloted;
	
	public void setTicketId(int ticketId)
	{
		this.ticketId=ticketId;
	}
	
	public int getTicketId()
	{
		return ticketId;
	}
	
	public void setPassengerId(int passengerId)
	{
		this.passengerId=passengerId;
	}
	
	public int getPassengerId()
	{
		return passengerId;
	}
	
	public void setFromLocation(String fromLocation)
	{
		this.fromLocation=fromLocation;
	}
	
	public String getFromLocation()
	{
		return fromLocation;
	}
	
	public void setToLocation(String toLocation)
	{
		this.toLocation=toLocation;
	}
	
	public int getToLocation()
	{
		return toLocation;
	}
	
	public void setSeatNo(int seatNo)
	{
		this.seatNo=seatNo;
	}
	
	public int getSeatNo()
	{
		return seatNo;
	}
	
	public void setBerthAlloted(String berthAlloted)
	{
		this.berthAlloted=berthAlloted;
	}
	
	public String getBerthAlloted()
	{
		return berthAlloted;
	}
	
	/*public void setBerthPrefernce(string berthPreference)
	{
		this.berthPreference=berthpreference;
	}*/
	
	public String toString()
	{
		return " PassengerID = { PassengerName = "+passengerName+" Passenger Age = "+passengerAge+" PassengerAddress = "+passengerAddress+" PassengerGender = "+passengerGender+" BerthPreference = "+berthPreference+" }";
	}
}
