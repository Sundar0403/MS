package excep;

import java.io.IOException;

public class CustomException extends Exception
{
	public CustomException(String message)
	{
		super(message);
	}
	
	public CustomException(IOException obj)
	{
		super(obj);
	}
}
