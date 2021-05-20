import java.util.Random;

public class First
{
	public static void main (String[] args)
	{
		Random r = new Random();
		int decider = r.nextInt();
		
		if (decider == 0)
		{
			System.out.println("Thinkpad");
		}
		else
		{
			System.out.println("MacBook");
		}
	}
}







































































