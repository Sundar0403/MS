package vehicle;
import java.util.*;

public class VehicleDetails
{
	private int tokenId;
	public Map<String,Integer> countMap=new HashMap<>();
	countMap.put("Compact",5);
	countMap.put("Large",5);
	countMap.put("Handicapped",5);
	countMap.put("Motor Cycle",5);
	
	public Map<String,List<String>> vehicleMap=new HashMap<>();
	List<String> newList=new ArrayList<>();
	newList.add("Van");
	newList.add("Car");
	vehicleMap.put("Compact",newList);
	newList=new ArrayList<>();
	newList.add("Truck");
	newList.add("Lorry");
	newList.add("Bus");
	vehicleMap.put("Large",newList);
	newList=new ArrayList<>();
	newList.add("HandiCapped MotorCycle");
	vehicleMap.put("Handicapped",newList);
	newList=new ArrayList<>();
	newList.add("Bike");
	vehicleMap.put("Motor Cycle",newList);	
}
