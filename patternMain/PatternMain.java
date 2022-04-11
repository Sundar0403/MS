package patternMain;
import patternLogic.*;
import java.util.*;

public class PatternMain
{
	Scanner scan=new Scanner(System.in);
	PatternLogic logicObj=new PatternLogic();
	private void rightTrianglePattern()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.rightTrianglePattern(num);
	}
	private void rightPascalTrianglePattern()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.rightPascalTrianglePattern(num);
	}
	private void numberPattern()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.numberPattern(num);
	}
	private void zPattern()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.zPattern(num);
	}
	private void pyramidPattern()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.pyramidPattern(num);
	}
	private void leftTrianglePattern()
	{
		int num=scan.nextInt();
		scan.nextLine();
		logicObj.leftTrianglePattern(num);
	}
	public static void main(String args[])
	{
		PatternMain mainObj=new PatternMain();
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		scan.nextLine();
		
		switch(choice)
		{
			
			case 1:
				mainObj.pyramidPattern();
				break;
			
			case 2:
				mainObj.rightTrianglePattern();
				break;
				
			case 3:
				mainObj.leftTrianglePattern();
				break;	
				
			case 6:
				mainObj.rightPascalTrianglePattern();
				break;	
				
			case 9:
				mainObj.numberPattern();
				break;	
				
			case 14:	
				mainObj.zPattern();
				break;
				
		}
	}
}
