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
	public void diagonalSorting()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int arr[][]=new int[num][num];
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				arr[i][j]=scan.nextInt();
				//scan.nextLine();
			}
		}
		logicObj.diagonalSorting(arr);
	}
	
	public void letsPlay()
	{
		int num=scan.nextInt();
		scan.nextLine();
		int col=scan.nextInt();
		scan.nextLine();
		int x=scan.nextInt();
		scan.nextLine();
		int arr[][]=new int[num][num];
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scan.nextInt();
				//scan.nextLine();
			}
		}
		System.out.println(logicObj.isSuperSimilar(num,col,arr,x));
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
				
			case 7:
				mainObj.diagonalSorting();
				break;
				
			case 10:
				mainObj.letsPlay();
				break;	
				
					
		}
	}
}
