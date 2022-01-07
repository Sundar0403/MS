package mainFile;
import single.*;
import java.io.*;
import enumeration.*;
import utility.*;
import excep.*;
import logicFile.*;
import java.util.*;
import construct.*;
import pojo.*;
import java.lang.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class FileMain 
{
	
	Scanner scan=new Scanner(System.in);
	FileCreate newFile=new FileCreate();
	UtilityClass utilObj=new UtilityClass();
	
	private void fileCreation()
	{
		try
		{
			System.out.println("Enter the Filepath :");
			String filePath=scan.nextLine();
			System.out.println("Enter the Filename :");
			String fileName=scan.nextLine();
			File fileObj=newFile.createFile(filePath,fileName);
			System.out.println("Enter the Length of the Line");
			int length=scan.nextInt();
			scan.nextLine();
			String stored[]=new String[length];
			String content="";
			for(int i=0;i<length;i++)
			{
				stored[i]=scan.nextLine();
			}
			utilObj.stringArrayCheck(stored);
			for(String dummy : stored)
			{
				content=content+dummy;
			}
			newFile.newFileCreate(fileObj,content);
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
	private void propertiesClass()
	{
		try
		{
			System.out.println("Enter the Filepath :");
			String filePath=scan.nextLine();
			System.out.println("Enter the Filename :");
			String fileName=scan.nextLine();
			Properties prop=newFile.createProperty();
			System.out.println("Enter the Length of the Line");
			int length=scan.nextInt();
			scan.nextLine();
			String path=filePath+fileName;
			for(int i=0;i<length;i++)
			{
				System.out.println("Enter the Key :");
				String key=scan.nextLine();
				System.out.println("Enter the Value :");
				String value=scan.nextLine();
				newFile.newProperties(prop,path,key,value);
			}	
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
	private void getPropertiesClass()
	{
		try
		{
			System.out.println("Enter the Filepath :");
			String filePath=scan.nextLine();
			System.out.println("Enter the Filename :");
			String fileName=scan.nextLine();
			Properties prop=newFile.createProperty();	
			String path=filePath+fileName;
			prop=newFile.getProperties(prop,path);
			System.out.println(prop);
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
	private int getOrdinal(Color colors)
	{
		int a =colors.ordinal();
		return a+1;
	}
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		FileMain mainObj=new FileMain();
		FileCreate newFile=new FileCreate();
		
		//Properties property=null;
		int choice=0;
		try
		{
			choice=scan.nextInt();
			scan.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		}
		switch(choice)
		{
			case 1:
			{
					mainObj.fileCreation();
					break;
			}		
			case 2:
			{	
					mainObj.propertiesClass();
					break;
			}		
			case 3:
			{
					mainObj.getPropertiesClass();
					break;
			}		
			case 4:
			{
					mainObj.fileCreation();
					mainObj.propertiesClass();
					mainObj.getPropertiesClass();
					break;
			}		
			case 5:
			{
					ConstructorClass constructObj=new ConstructorClass("Mani");	
					System.out.println(constructObj);
					break;
			}		
			case 6:
			{
					PojoClass pojo=new PojoClass("Mani Sundar",23);
					System.out.println(pojo);
					break;
			}		
			case 7:
			{
					PojoClass pojoObj=new PojoClass();
					pojoObj.setName("Mani");
					pojoObj.setAge(23);
					System.out.println("The String is : "+pojoObj.getName());
					System.out.println("The Integer is : "+pojoObj.getAge());
					break;
			}
			case 8:
			{
				try
				{
					Class classObj=Class.forName("pojo.PojoClass");
					System.out.println("Enter Your Name :");
					String name=scan.nextLine();
					System.out.println("Enter Your Age : ");
					int age=scan.nextInt();
					scan.nextLine();
					Object obj=classObj.getDeclaredConstructor(String.class,int.class).newInstance(name,age);
					Object obj1=classObj.getDeclaredConstructor().newInstance();
					
					Method methodObj=classObj.getDeclaredMethod("setName",String.class);
					methodObj.invoke(obj1,name);
					Method methObj=classObj.getDeclaredMethod("getName");
					System.out.println(methObj.invoke(obj1));
					
				}
				catch(Exception e)
				{
					System.out.println("Exception Occured:");
				}
				break;
			}
			case 9:
			{	
				Color[] color=Color.values();
				System.out.println("The Colors are :");
				for(Color colors : color)
				{
					System.out.println("Color : "+colors);
					System.out.println("Value of Color : "+mainObj.getOrdinal(colors));
				}
			}
			case 10:
			{
				Singleton sing=Singleton.getInstance();
				sing.getMessages();
			}
		}
	}

}
