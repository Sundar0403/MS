package cache;
import passenger.*;
import seat.*;
import java.util.*;

public class CacheLayer
{
	Map<Integer,PassengerDetails> passengerMap=new HashMap<>();
	Map<Integer,Map<String,List<SeatDetails>>> occupyMap=new HashMap<>();
	Map<String,List<SeatDetails>> seatMap=new HashMap<>();
	List<SeatDetails> seatList=new ArrayList<>();
	
	Scanner scan=new Scanner(System.in);
	
	public CacheLayer()
	{
		System.out.println("Enter the Number of Compats");
		int compats=scan.nextInt();
		scan.nextLine();
		
		//System.out.println("Enter the Number of Seats:");
		int berth=9;
		
		for(int i=1;i<=compats;i++)
		{
			
			
			for(int j=1;j<=berth;j++)
			{
				SeatDetails seatObj=new SeatDetails();
				seatObj.setCompatNo(i);
				seatObj.setSeatNo(j);	
				
				seatMap=occupyMap.get(i);
				if(seatMap==null)
				{
					seatMap=new HashMap<>();
					occupyMap.put(i,seatMap);
				}
				
				if(i<=2)
				{
					seatList=seatMap.get("Lower");
					if(seatList==null)
					{
						seatList=new ArrayList<>();
						seatMap.put("Lower",seatList);
					}
					seatObj.setBerthAlloted("Lower");
					seatList.add(seatObj);
				}
				if(i<=4)
				{
					seatList=seatMap.get("Middle");
					if(seatList==null)
					{
						seatList=new ArrayList<>();
						seatMap.put("Middle",seatList);
					}
					seatObj.setBerthAlloted("Middle");
					seatList.add(seatObj);
				}
				if(i<=6)
				{
					seatList=seatMap.get("Upper");
					if(seatList==null)
					{
						seatList=new ArrayList<>();
						seatMap.put("Upper",seatList);
					}
					seatObj.setBerthAlloted("Upper");
					seatList.add(seatObj);
				}
				if(i<=8)
				{
					seatList=seatMap.get("RAC");
					if(seatList==null)
					{
						seatList=new ArrayList<>();
						seatMap.put("RAC",seatList);
					}
					seatObj.setBerthAlloted("RAC");
					seatList.add(seatObj);
				}
				if(i==9)
				{
					seatList=seatMap.get("SideUpper");
					if(seatList==null)
					{
						seatList=new ArrayList<>();
						seatMap.put("SideUpper",seatList);
					}
					seatObj.setBerthAlloted("SideUpper");
					seatList.add(seatObj);
				}
			}
		}
		System.out.println(occupyMap);
	}
	public Map<Integer,PassengerDetails> setPassenger(int passengerId,PassengerDetails passengerObj) throws Exception
	{
		passengerMap.put(passengerId,passengerObj);
		return passengerMap;
	}
}
