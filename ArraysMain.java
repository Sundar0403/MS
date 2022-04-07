package arrayMain;
import java.util.*;

public class ArraysMain
{
	Scanner scan=new Scanner(System.in);
	private void printArray()
	{
		int num=scan.nextLine();
		scan.nextLine();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
			scan.nextLine();
		}
		
	}
	public static void main(String args[])
	{
		ArraysMain mainObj=new ArraysMain();
		int choice=scan.nextInt();
		scan.nextLine();
		switch(choice)
		{
			case 20:
				mainObj.printArray();
				break;
		}
	}
}	
