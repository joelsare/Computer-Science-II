package applications;
import java.util.Scanner;

import uno.collections.stacks.Stack;
import uno.collections.stacks.UnboundedStack;

public class Brackets
{
	//TODO: stuff
	public static boolean isValid(String text)
	{
		UnboundedStack<Character> s = new UnboundedStack<>();
		for (int i = 0; i < text.length(); i++)
		{
			switch(text.charAt(i))
			{
				case '{':
				case '<':
					s.push(text.charAt(i));
					break;
				case '}':
					if (s.isEmpty() || s.pop() !='{')  
						return false;
					break;
				case '>':
					if (s.isEmpty() || s.pop() !='<')  
						return false;
					break;
			}
		}
		return s.isEmpty();
		
		
	}

	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		while (true)
		{
			System.out.print("String to Check: ");
			String in = s.nextLine();
			
			if (isValid(in))
			{
				System.out.println(in + " is valid!");
			}
			else
			{
				System.out.println(in + " is NOT valid!");
			}
			
		}		
	}
	
}
