package hashmain;
import hashlogic.*;
import java.util.*;
import excep.*;

public class HashMapMain
{
	
	
	HashMapFunc hashObj=new HashMapFunc();
	Scanner scan=new Scanner(System.in);
	
	private Map<Object,Object> display(Map<Object,Object> inputMap)
	{
		try
		{
			System.out.println(" Enter Number of Elements in HashMap");
			int num=scan.nextInt();
			scan.nextLine();
			for(int i=0;i<num;i++)
			{
				System.out.println("Enter the Key : ");
				Object key=scan.nextLine();
				System.out.println("Enter the value : ");
				Object value=scan.nextLine();
				inputMap=hashObj.addInMap(inputMap,key,value);
			}
			
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
		return inputMap;
	}
	private void stringMap(Map<Object,Object> inputMap)
	{
		try
		{
			//Map<Object,Object> inputMap=hashObj.createMap();
			inputMap=display(inputMap);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void intMap(Map<Object,Object> inputMap)
	{
		try
		{
			int num=scan.nextInt();
			scan.nextLine();
			for(int i=0;i<num;i++)
			{
				System.out.println("Enter the Key : ");
				Object key=scan.nextInt();
				System.out.println("Enter the value : ");
				Object value=scan.nextInt();
				scan.nextLine();
				inputMap=hashObj.addInMap(inputMap,key,value);
			}
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void stringIntMap(Map<Object,Object> inputMap)
	{
		try
		{
			int num=scan.nextInt();
			scan.nextLine();
			for(int i=0;i<num;i++)
			{
				System.out.println("Enter the Key : ");
				Object key=scan.nextLine();
				System.out.println("Enter the value : ");
				Object value=scan.nextInt();
				scan.nextLine();
				inputMap=hashObj.addInMap(inputMap,key,value);
			}
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void objectMap(Map<Object,Object> inputMap)
	{
		try
		{
			int num=scan.nextInt();
			scan.nextLine();
			for(int i=0;i<num;i++)
			{
				System.out.println("Enter the Key : ");
				Object key=scan.nextLine();
				Object value=hashObj;
				inputMap=hashObj.addInMap(inputMap,key,value);
			}
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void nullValueInMap(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println("Enter the Key : ");
			Object key=scan.nextLine();
			inputMap=hashObj.addInMap(inputMap,key,null);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void nullKeyInMap(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println("Enter the value : ");
			Object value=scan.nextLine();
			inputMap=hashObj.addInMap(inputMap,null,value);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void checkKey(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println("Enter the Key to be Checked : ");
			Object key=scan.nextLine();
			System.out.println("The Given Key is Present in the Map :"+hashObj.checkKeyInMap(inputMap,key));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void checkValue(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println("Enter the Value to be Checked : ");
			Object value=scan.nextLine();
			System.out.println("The Given Value is Present in the Map :"+hashObj.checkValueInMap(inputMap,value));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void changeValue(Map<Object,Object> inputMap,Map<Object,Object> outputMap)
	{
		try
		{
			inputMap=display(inputMap);
			outputMap=display(outputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println(" HashMap After Changing the Values :");
			inputMap=hashObj.changeAllKeyValueInMap(inputMap,outputMap);
			hashObj.iterateInMap(inputMap); 
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void getValue(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println("Enter the Key to Get it's Value : ");
			Object key=scan.nextLine();
			System.out.println("The Required Value is :"+hashObj.getKeyValueInMap(inputMap,key));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void getKey(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println("Enter the Key for Which the Value to be get :");
			Object key=scan.nextLine();
			System.out.println("The Required Value is :"+hashObj.getKeyValueInMap(inputMap,key));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void removeKeyInMap(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Enter the Key to be Removed :");
			Object key=scan.nextLine();
			inputMap=hashObj.removeKeyInMap(inputMap,key);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void getNonExistKeyValue(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Enter the Default Value : ");
			Object value=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Key for Which the Value to be get :");
			Object key=scan.nextLine();
			System.out.println("The Required Value for the Given Key is :"+hashObj.getNonExistKeyValueInMap(inputMap,key,value));
			System.out.println(" HashMap After Changing the Values :");
			hashObj.iterateInMap(inputMap); 
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
					
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void removeKeyValueInMap(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Enter the Value and Its Specified Key to be Removed :");
			Object key=scan.nextLine();
			Object value=scan.nextLine();
			inputMap=hashObj.removeKeyValueInMap(inputMap,key,value);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void replace(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Enter the Value for the Key to Be Replaced :");
			Object key=scan.nextLine();
			Object value=scan.nextLine();
			inputMap=hashObj.replaceInMap(inputMap,key,value);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void replaceValue(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Enter the Value for the Specified Key to Be Replaced :");
			Object key=scan.nextLine();
			Object oldValue=scan.nextLine();
			Object newValue=scan.nextLine();
			inputMap=hashObj.replaceForValueInMap(inputMap,key,oldValue,newValue);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void addMap(Map<Object,Object> inputMap,Map<Object,Object> outputMap)
	{
		try
		{
			inputMap=display(inputMap);
			outputMap=display(outputMap);
			System.out.println(" HashMap Before Changing the Values :");
			hashObj.iterateInMap(inputMap);
			hashObj.iterateInMap(outputMap);
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Size of the HashMap Before Changing Values is : "+hashObj.getMapSize(outputMap));
			System.out.println(" HashMap After Changing the Values :");
			inputMap=hashObj.changeAllKeyValueInMap(inputMap,outputMap);
			hashObj.iterateInMap(inputMap); 
			hashObj.iterateInMap(outputMap);
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(inputMap));
			System.out.println("Size of the HashMap After Changing the Values is : "+hashObj.getMapSize(outputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void iterateMap(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	private void clearMap(Map<Object,Object> inputMap)
	{
		try
		{
			inputMap=display(inputMap);
			System.out.println(" HashMap Before the Change :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
			inputMap=hashObj.removeMap(inputMap);
			System.out.println(" HashMap After the Change :");
			hashObj.iterateInMap(inputMap);
			System.out.println("Size of the HashMap is : "+hashObj.getMapSize(inputMap));
		}
		catch(CustomException e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured : "+e.getMessage());
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		HashMapFunc hashObj=new HashMapFunc();
		Scanner scan=new Scanner(System.in);
		HashMapMain hashMain=new HashMapMain();
		Map<Object,Object> newMap=hashObj.createMap();
		int choice=0;
		System.out.println("Enter Your Choice :");
		try
		{
			choice=scan.nextInt();
			scan.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("Invalid Integer Intialization ");
		}	
		
		switch(choice)
		{
			case 1:
				try
				{
					System.out.println("The Size of the HashMap is"+hashObj.getMapSize(newMap));
				}
				catch(Exception e)
				{
					System.out.println(" Exception Occured : "+e.getMessage());
				}	
				break;
				
			case 2:
				
				hashMain.stringMap(newMap);
				break;
				
			case 3:
				
				hashMain.stringMap(newMap);		
				break;
				
			case 4:
				
				hashMain.stringIntMap(newMap);		
				break;
				
			case 5:
				
				hashMain.objectMap(newMap);		
				break;
				
			case 6:
				
				hashMain.nullValueInMap(newMap);		
				break;
				
			case 7:
				
				hashMain.nullKeyInMap(newMap);		
				break;
				
			case 8:
				
				hashMain.checkKey(newMap);	
				break;
				
			case 9:
				
				hashMain.checkValue(newMap);		
				break;
				
			case 10:
				
				Map<Object,Object> outputsMap=hashObj.createMap();
				hashMain.changeValue(newMap,outputsMap);		
				break;
				
			case 11:
				
				hashMain.getValue(newMap);		
				break;
				
			case 12:
				
				hashMain.getKey(newMap);		
				break;
				
			case 13:
				
				hashMain.getNonExistKeyValue(newMap);		
				break;	
								
			case 14:
				
				hashMain.removeKeyInMap(newMap);		
				break;	
				
			case 15:
				
				hashMain.removeKeyValueInMap(newMap);		
				break;
				
			case 16:
				
				hashMain.replace(newMap);		
				break;
			
			case 17:
				
				hashMain.replaceValue(newMap);		
				break;
				
			case 18:
				
				Map<Object,Object> outputMap=hashObj.createMap();
				hashMain.addMap(newMap,outputMap);		
				break;
				
			case 19:
				
				hashMain.iterateMap(newMap);
				break;
				
			case 20:
				
				hashMain.clearMap(newMap);
				break;
					
																
		}	
	}
}


