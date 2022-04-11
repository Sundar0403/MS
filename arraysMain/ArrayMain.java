package arraysMain;
import arraysLogic.*;
import java.util.*;

public class ArrayMain
{
	Scanner scan=new Scanner(System.in);
	ArrayLogic logicObj=new ArrayLogic();
	private void printArray()
	{
		
		
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[15];
		for(int i=0;i<15;i++)
		{
			arr[i]=scan.nextInt();
				
		}
		logicObj.printArrays(arr,num);
	}
	private void closestSumArray()
	{
		
		int num=scan.nextInt();
		scan.nextLine();
		int closest=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
				
		}
		logicObj.closestSumArray(arr,num,closest);
	}
	private void sumPairArray()
	{
		
		int num=scan.nextInt();
		scan.nextLine();
		int sum=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
				
		}
		logicObj.sumPairArray(arr,num,sum);
	}
	private void rotateArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.rotateArrays(arr,num);
	}
	private void countArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.countArray(arr,num);
	}
	
	private void closestArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		//logicObj.closestArray(arr,num);
	}
	
	private void perfectNumber()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.perfectNumber(num);
	}

	private void digitSumArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.digitSumArray(arr,num);
	}
	private void multiplyArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();	
		}
		logicObj.multiplyArray(arr,num);
	}
	private void misMatchArray()
	{
		int num=scan.nextInt();
		scan.nextLine();
		String arr[]=new String[num];
		String arr2[]=new String[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextLine();	
		}
		for(int j=0;j<num;j++)
		{
			arr2[j]=scan.nextLine();
		}
		logicObj.misMatchArray(arr,arr2,num);
	}
	public static void main(String args[])
	{
		ArrayMain mainObj=new ArrayMain();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Your Choice:");
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice)
		{
		
			case 3:
				mainObj.closestSumArray();
				break;
			
			case 4:
				mainObj.rotateArray();
				break;		
				
			case 5:
				mainObj.misMatchArray();
				break;
				
			case 6:
				mainObj.sumPairArray();
				break;		
				
			case 9:
				mainObj.countArray();
				break;
				
			case 15:
				mainObj.multiplyArray();
				break;	
				
			case 16:
				mainObj.perfectNumber();
				break;		
				
			case 18:
				mainObj.digitSumArray();
				break;	
			
			case 20:
				mainObj.printArray();
				break;
		}
	}
}	
