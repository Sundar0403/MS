package seat;
import java.util.*;

public class SeatDetails
{
	private int seatNo;
	private int compatNo;
	private String berthAlloted;
	private boolean bookingStatus=false;
	private String status;
	
	public void setSeatNo(int seatNo)
	{
		this.seatNo=seatNo;
	}
	
	public int getSeatNo()
	{
		return seatNo;
	}
	
	public void setCompatNo(int compatNo)
	{
		this.compatNo=compatNo;
	}
	
	public int getCompatNo()
	{
		return compatNo;
	}
	
	public void setBerthAlloted(String berthAlloted)
	{
		this.berthAlloted=berthAlloted;
	}
	
	public String getBerthAlloted()
	{
		return berthAlloted;
	}
	
	public void setBookingStatus(boolean bookingStatus)
	{
		this.bookingStatus=bookingStatus;
	}
	
	public boolean getBookingStatus()
	{
		return bookingStatus;
	}
	
	public String toString()
	{
		if(bookingStatus==true)
		{
			status="Booked";
		}
		else
		{
			status="Unoccupied";
		}
		return " Berth Alloted = { Seat No = "+seatNo+" Compat No = "+compatNo+" Berth Alloted = "+berthAlloted+" Booking Status = "+status+" }";
	}
}
