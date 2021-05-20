package applications;
import java.util.Scanner;

import uno.collections.stacks.Stack;
import uno.collections.stacks.UnboundedStack;

public class Palindrome
{

	public static boolean isPalindrome(String s)
	{		
		Stack<Character> things = new UnboundedStack<>();
		for (int i = 0 ; i < s.length(); i++)
		{
			things.push(s.charAt(i));
		}
		
		/*
		String reversed = "";
		while (!things.isEmpty())
		{
			reversed += things.pop();
		}
		
		return s.equals(reversed);
		*/
		
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) != things.pop())
			{
				return false;
			}
		}
		return true;
		
		
	}

	
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		while (true)
		{
			System.out.print("String to Check: ");
			String in = s.nextLine();
			
			if (isPalindrome(in))
			{
				System.out.println(in + " is a palindrome!");
			}
			else
			{
				System.out.println(in + " is NOT a palindrome!");
			}
			
		}		
	}
	
}
