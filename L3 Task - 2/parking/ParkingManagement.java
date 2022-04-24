package parking;
import customer.*;
import java.util.*;

public class ParkingManagement
{
	Map<Integer,CustomerDetails> vehicleMap=new HashMap<>();
	private void getTicket()
	{
		
	}
	public static void main(String args[])
	{
		ParkingManagement mainObj=new ParkingManagement();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your Choice :");
		int choice=scan.nextInt();
		scan.nextLine();
		
		switch(choice)
		{
			case 1:
				mainObj.getTicket();
				break;
		}
	}
}
