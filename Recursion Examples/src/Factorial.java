
public class Factorial
{
	public static long fact(long n)
	{
		//base case
		if (n == 0)
		{
			return 1;
		}
		//general case
		else
		{
			return n * fact(n - 1);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(fact(3));
		
		/*for (int i = 0; i < 15; i++)
		{
			System.out.printf("%d! = %d\n", i, fact(i));
		}*/
	}
}
