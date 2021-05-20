import java.util.Scanner;

public class ToLower
{
	public static String toLower(String s)
	{
		//base case
		if(s == null || s.equals(""))
		{
			return s;
		}
		//general case
		else
		{
			char c = s.charAt(0);
			c = Character.toLowerCase(c);
			return c + toLower(s.substring(1));
		}
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String temp;
		do
		{
			System.out.print("Enter a string: ");
			temp = s.nextLine();
			temp = toLower(temp);
			System.out.println("Lowered Version: " + temp);
		} while (!temp.equals("quit"));
	}
}
