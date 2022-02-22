package utility;
import excep.*;
public class UtilityClass 
{
	public void stringCheck(String inputString) throws CustomException
    {
        if(inputString==null||inputString.isEmpty())
        {
            throw new CustomException("String Can't be Null or Empty");
        }
    }
    
	public void stringArrayCheck(String inputString[]) throws CustomException
    {
        for(String checkString:inputString)
        {
            stringCheck(checkString);
        }
    }
    
    public void numCheck(int length,int number) throws CustomException
    {
    	if(number<0||number>length)
    	{
    		throw new CustomException("Number Can't be Less Than 0 or Out of Range");
    	}
    }
    
    public void ObjectCheck(Object object) throws CustomException
    {
        if(object==null)
        {
            throw new CustomException("Object Can't be Null");
        }
    }
}