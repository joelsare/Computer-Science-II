package d;

public class isInOrder
{
	public static void main (String[] args)
	{
		//System.out.println(inOrder("a"));
		
		System.out.println(clean("HELLO"));
	}
	
	public static String clean(String in)
	{
		if (in == null || in.equals(""))
		{
			return in;
		}
		else if (Character.isLetter(in.charAt(0)))
		{
			return Character.toLowerCase(in.charAt(0)) + clean(in.substring(1));
		}
		else
		{
			return clean(in.substring(1));
		}
	}
	
	public static boolean inOrder(String a)
	{
		return inOrderHelper(a, 0);
	}
	
	private static boolean inOrderHelper(String a, int start)
	{
		if (start >= a.length() - 1)
		{
			return true;
		}
		else if (a.charAt(start) > a.charAt(start + 1))
		{
			return false;
		}
		else
		{
			return inOrderHelper(a, start + 1);
		}
	}
}
