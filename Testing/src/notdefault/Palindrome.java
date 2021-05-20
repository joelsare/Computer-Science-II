package notdefault;

import java.util.Stack;

public class Palindrome
{
	public static boolean isPalindrome(String s)
	{
		boolean result = true;
		Stack<Character> ordered = new Stack<Character>();
		Stack<Character> reversed = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++)
		{
			ordered.push(s.charAt(i));
		}
		
		for (int j = s.length() - 1; j >= 0; j--)
		{
			reversed.push(s.charAt(j));
		}
		
		for (int i = 0; i < ordered.size(); i++)
		{
			if (!ordered.pop().equals(reversed.pop()))
			{
				result = false;
			}
		}
		return result;
	}
	
	public static boolean isValid(String text)
	{
		boolean result = true;
		Stack<Character> chars = new Stack<Character>();
		if ((text.length() % 2) != 0)
		{
			result = false;
		}
		
		int middle = text.length() / 2;
		
		for (int i = 0; i < middle; i++)
		{
			chars.add(text.charAt(i));
		}
		
		for (int j = text.length() - 1; j > middle; j--)
		{
			char a = chars.pop();
			char b = text.charAt(j);
			if (!(isMatchingPair(a, b)));
			{
				result = false;
			}
		}
		return result;
	}
	
	 static boolean isMatchingPair(char character1, char character2) 
	    { 
	       if (character1 == '(' && character2 == ')') 
	         return true; 
	       else if (character1 == '{' && character2 == '}') 
	         return true; 
	       else if (character1 == '<' && character2 == '>') 
	         return true; 
	       else
	         return false; 
	    } 
	
	public static void main(String[] args)
	{
		//System.out.println(isPalindrome("able was i saw elba"));
		System.out.println(isValid("(())"));
		
	}
}
