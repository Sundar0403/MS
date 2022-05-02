package booking;
import passenger.*;
import ticket.*;
import logic.*;
import java.util.*;

public class RailwayTicketBooking
{
	RailwayTicketLogic logicObj=new RailwayTicketLogic();
	Scanner scan=new Scanner(System.in);
	Map<Integer,PassengerDetails> passengerMap=new HashMap<>();
	
	public void setPassenger() throws Exception
	{
		PassengerDetails passengerObj=new PassengerDetails();
		
		int passengerId=logicObj.getCustId();
		passengerObj.setPassengerId(passengerId);
		
		System.out.println("Enter the Passenger Name:");
		String passengerName=scan.nextLine();
		passengerObj.setPassengerName(passengerName);
		
		System.out.println("Enter the Passenger Age:");
		int passengerAge=scan.nextInt();
		scan.nextLine();
		passengerObj.setPassengerAge(passengerAge);
		
		System.out.println("Enter the Passenger Address :");
		String passengerAddress=scan.nextLine();
		passengerObj.setPassengerAddress(passengerAddress);
		
		System.out.println("Enter the Passenger Gender :");
		String passengerGender=scan.nextLine();
		
		if(passengerGender.equals("Male")||passengerGender.equals("Female")||passengerGender.equals("Trans Gender"))
		{
			passengerObj.setPassengerGender(passengerGender);
		}
		else
		{
			throw new Exception("Invalid Data is Entered :");
		}
		
		System.out.println("Enter the Passenger Berth Preference :");
		String berthPreference=scan.nextLine();
		
		if(berthPreference.equals("Lower")||berthPreference.equals("Middle")||berthPreference.equals("Upper")||berthPreference.equals("SideUpper")||berthPreference.equals("RAC"))
		{
			passengerObj.setBerthPrefernce(berthPreference);
		}
		else
		{
			throw new Exception("Invalid Data is Entered :");
		}
		
		passengerMap=logicObj.setPassenger(passengerId,passengerObj);
		
		System.out.println(passengerMap);
	}
	public static void main(String args[])
	{
		RailwayTicketBooking bookingObj=new RailwayTicketBooking();
		Scanner scan=new Scanner(System.in);
		int choice=0;
		boolean flag=true;
		while(flag)
		{
			System.out.println("Enter Your Choice");
			System.out.println("-------------------- 1 . SET PASSENGER INFO ---------------------");
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
				case 1:
					try
					{
						bookingObj.setPassenger();
						break;
					}
					catch(Exception e)
					{
						System.out.println("Error Occured :"+e.getMessage());
						break;
					}
					
				default:
				
					try
					{
						flag=false;
						break;
					}		
					catch(Exception e)
					{
						System.out.println("Error Occured :"+e.getMessage());
						break;
					}
			}
		}
	}
}
