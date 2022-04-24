package logic;
import java.util.*;

public class ParkingLogic
{
	private int tokenId=0;
	
	public int getTokenId()
	{
		return ++tokenId;
	}
}
