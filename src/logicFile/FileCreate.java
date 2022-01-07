package logicFile;
import java.io.BufferedWriter;
import pojo.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import utility.*;

import excep.CustomException;


public class FileCreate {
	
	UtilityClass utilObj=new UtilityClass();
	
	public void fileCheck(File fileObj) throws CustomException
	{
		if(fileObj==null)
		{
			throw new CustomException("File Can't be Null");
		}
	}
	
	public File createFile(String fileDestination,String fileName) throws CustomException
	{
		
		try
		{
			utilObj.stringCheck(fileDestination);
			utilObj.stringCheck(fileName);
			File fileObj=new File(fileDestination,fileName);
			if(fileObj.createNewFile())
			{
				return fileObj;
			}
			throw new CustomException("File Already Exists");
		} 
		catch (IOException e) 
		{
			throw new CustomException(e);
			//e.printStackTrace();
		} 
	}
	
	public Properties createProperty()
	{
		Properties newObj=new Properties();
		return newObj;
	}
	
	public void newFileCreate(File fileObj,String content) throws CustomException
	{
		fileCheck(fileObj);
		utilObj.stringCheck(content);
		try(FileWriter writer=new FileWriter(fileObj);
				BufferedWriter buffer=new BufferedWriter(writer);)
		{
			buffer.write(content);
			buffer.newLine();
		}
	
		catch(IOException e)
		{
			throw new CustomException(e);
		}
	}
	
	public void newProperties(Properties newObj,String path,String key,String value) throws CustomException
	{
		utilObj.stringCheck(path);
		utilObj.stringCheck(key);
		utilObj.stringCheck(value);
		utilObj.ObjectCheck(newObj);
		try(FileOutputStream outputStream=new FileOutputStream(path);)
		{
			newObj.setProperty(key,value);
			
			newObj.store(outputStream,"");
		}
		catch(IOException e)
		{
			throw new CustomException(e);
		}
	}
	
	public Properties getProperties(Properties newObj,String path) throws CustomException
	{
		utilObj.stringCheck(path);
		utilObj.ObjectCheck(newObj);
		try
		{
			FileInputStream inputStream=new FileInputStream(path);
			newObj.load(inputStream);
			return newObj;
		}
		catch(IOException e)
		{
			throw new CustomException(e);
		}
	}
}	




