package hashlogic;
import run.*;
import java.util.*;
import excep.*;

public class HashMapFunc
{

	StringFunc strObj=new StringFunc();
	
	public void hashMapCheck(Map<Object,Object> inputMap) throws CustomException
	{
		if(inputMap==null)
		{
			throw new CustomException("HashMap can't be null");
		}
	}
	public Map<Object,Object> createMap()
	{
		Map<Object,Object> inputMap=new HashMap<>();
		return inputMap;
	}
	public int getMapSize(Map<Object,Object> inputMap) throws CustomException
	{
		hashMapCheck(inputMap);
		int length=inputMap.size();
		return length;
	}
	public Map<Object,Object> addInMap(Map<Object,Object> inputMap,Object key,Object value) throws CustomException //2,3,4,5,6,7th
	{
		hashMapCheck(inputMap);
		inputMap.put(key,value);
		return inputMap;
	}
	public boolean checkKeyInMap(Map<Object,Object> inputMap,Object key) throws CustomException //8th
	{
		hashMapCheck(inputMap);
		boolean keyCheck=inputMap.containsKey(key);
		return keyCheck;
	}
	public boolean checkValueInMap(Map<Object,Object> inputMap,Object value) throws CustomException //9th
	{
		hashMapCheck(inputMap);
		boolean valueCheck=inputMap.containsValue(value);
		return valueCheck;
	}
	public Map<Object,Object> changeAllKeyValueInMap(Map<Object,Object> inputMap,Map<Object,Object> outputMap) throws CustomException //10,18th
	{
		hashMapCheck(inputMap);
		hashMapCheck(outputMap);
		inputMap.putAll(outputMap);
		return inputMap;
	}
	public Object getKeyValueInMap(Map<Object,Object> inputMap,Object key) throws CustomException //11,12th
	{
		hashMapCheck(inputMap);
		Object value=inputMap.get(key);
		return value;
	}
	public Object getNonExistKeyValueInMap(Map<Object,Object> inputMap,Object key,Object value) throws CustomException //13th
	{
		hashMapCheck(inputMap);
		Object insertValue=inputMap.getOrDefault(key,value);
		return insertValue;
	}
	public Map<Object,Object> removeKeyInMap(Map<Object,Object> inputMap,Object key) throws CustomException //14th
	{
		hashMapCheck(inputMap);
		inputMap.remove(key);
		return inputMap;
	}
	public Map<Object,Object> removeKeyValueInMap(Map<Object,Object> inputMap,Object key,Object value) throws CustomException //15th
	{
		hashMapCheck(inputMap);
		inputMap.remove(key,value);
		return inputMap;
	}
	public Map<Object,Object> replaceInMap(Map<Object,Object> inputMap,Object key,Object value) throws CustomException //16th
	{
		hashMapCheck(inputMap);
		inputMap.replace(key,value);
		return inputMap;
	}
	public Map<Object,Object> replaceForValueInMap(Map<Object,Object> inputMap,Object key,Object oldValue,Object newValue) throws CustomException //17th
	{
		hashMapCheck(inputMap);
		inputMap.replace(key,oldValue,newValue);
		return inputMap;
	}
	public void iterateInMap(Map<Object,Object> inputMap) throws CustomException //19th
	{
		hashMapCheck(inputMap);
		Iterator <Map.Entry<Object,Object>> iteration=inputMap.entrySet().iterator();
		while(iteration.hasNext())
		{
			Map.Entry<Object,Object>entry=iteration.next();
			System.out.println(" Key = "+entry.getKey()+" Value = "+entry.getValue());
		}
	}
	public Map<Object,Object> removeMap(Map<Object,Object> inputMap) throws CustomException //20th
	{
		hashMapCheck(inputMap);
		inputMap.clear();
		return inputMap;
	}
}








