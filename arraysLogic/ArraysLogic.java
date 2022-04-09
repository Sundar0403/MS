package arraysLogic;
import java.util.*;

public class ArraysLogic
{
	Scanner scan=new Scanner(System.in);
	public void printArrays(int arr[])
	{
		int count=0;
		int num=0;
		int arr2[][]=new int[5][5];
		System.out.println("");
		for(int i=0;i<5;i++)
		{
			num=num+i;
			
			for(int j=0;j<=num;j++)
			{
				System.out.println(arr[num]+" ");
			}
			count++;
		}
	}

	public void rotateArrays(int arr[],int num)
	{
		for(int i=num-1;i>num-2;i--)
		{
			System.out.print(arr[i]+" ");
		}
		for(int j=0;j<num-1;j++)
		{
			System.out.print(arr[j]+" ");
		}
	}
	public void countArray(int arr[],int num)
	{
		Map<Integer,Integer> newMap=new HashMap<>();
		HashSet<String> newSet=new HashSet<>();
		for(int i=0;i<num;i++)
		{
			if(newMap.containsKey(arr[i]))
			{
				newMap.put(arr[i],newMap.get(arr[i])+1);
			}
			else
			{
				newMap.put(arr[i],1);
			}
		}
		for(int j=0;j<num;j++)
		{
			newSet.add(String.valueOf(arr[j])+"-"+String.valueOf(newMap.get(arr[j])));
		}
		String[] newArr = newSet.toArray(new String[newSet.size()]);
		for(int k=0;k<newArr.length;k++)
		{
			System.out.println(newArr[k]);
		}
	}
	public int digitSum(int num)
	{
		int rem=0;
		int sum=0;
		while(num>0)
		{
			rem=num%10;
			sum=sum+rem;
			num=num/10;
		}
		return sum;
	}
	public void digitSumArray(int arr[],int num)
	{
		int temp=0;
		HashMap<Integer,Integer> newMap=new HashMap<>();
		for(int i=0;i<num;i++)
		{
			newMap.put(arr[i],digitSum(arr[i]));
		}
		for(int j=0;j<num-1;j++)
		{
			if(newMap.get(arr[j])>newMap.get(arr[j+1]))
			{
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				
				j=-1;
			}
		}
		for(int k=0;k<num;k++)
		{
			System.out.print(arr[k]+" ");
		}
	}
	public void perfectNumber(int num)
	{
		Map<Integer,Integer> newMap=new HashMap<>();
		int count=1;
		
		for(int i=0;i<num;i++)
		{
			if(digitSum(i)==10)
			{
				newMap.put(count,i);
				count++;
			}
		}
		System.out.println("Enter the Number to get Nth Perfect Number");
		int number=scan.nextInt();
		scan.nextLine();
		System.out.println(newMap.get(number));
	}
	public void closestSumArray(int arr[],int num)
	{
		
	}
	public void misMatchArray(String arr1[],String arr2[],int num)
	{
		String result="";
		String result2="";
		String finalResult="";
		int count=0;
		int innerCount=0;
		for(int i=0;i<num;i++)
		{
			if(!arr1[i].equals(arr2[i])&&i<num-1)
			{
				result=result+arr1[i];
				result2=result2+arr2[i];
				count++;
			}
			if(arr1[i].equals(arr2[i])&&count>0)
			{
				
				innerCount++;
				if(innerCount>1)
				{
					finalResult=finalResult+","+result+","+result2;
					result="";
					result2="";
				}
				else
				{
					finalResult=finalResult+result+","+result2;
					result="";
					result2="";
				}	
			}
		}
		finalResult=finalResult+".";
		System.out.println(finalResult);
	}
}
