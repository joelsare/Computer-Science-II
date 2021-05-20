import java.io.IOException;

public class Serial extends IOException implements Comparable<Serial>
{	
	public Serial (String msg)
	{
		super(msg);
	}
	
	public int compareTo(Serial o)
	{
		return 0;
	}
	
	public static void main(String[] args) throws Serial
	{
		try
		{
			throw new Serial("test");
		}
		catch (Serial ser)
		{
			System.out.println("Serial detected");
		}
	}
}
