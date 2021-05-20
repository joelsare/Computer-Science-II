package exam3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exam3Driver
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Exam3 e;
		System.out.print("Enter file name: ");
		e = new Exam3(input.next());
		
		try
		{
			e.processFile();
		}
		catch (FileNotFoundException nfne)
		{
			System.out.println("File not found");
		}
	}
}
