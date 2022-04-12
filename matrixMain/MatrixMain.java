package matrixMain;
import java.util.*;
import matrixLogic.*;

public class MatrixMain
{
	Scanner scan=new Scanner(System.in);
	MatrixLogic logicObj=new MatrixLogic();
	
	public void replaceZeros()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[][]=new int[num][num];
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				arr[i][j]=scan.nextInt();
				scan.nextLine();
			}
		}
		logicObj.replaceZeros(arr);
	}
	
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		MatrixMain mainObj=new MatrixMain();
		
		int choice=scan.nextInt();
		scan.nextLine();
		
		switch(choice)
		{
			case 5:
				mainObj.replaceZeros();
				break;
		}
	}
}
