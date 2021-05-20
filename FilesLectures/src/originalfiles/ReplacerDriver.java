package originalfiles;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReplacerDriver
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String inFilename;
		String outFilename;
		String findWord;
		String replaceWord;
		
		System.out.print("Input Filename? ");
		inFilename = in.nextLine();
		
		System.out.print("Output Filename? ");
		outFilename = in.nextLine();
		
		System.out.print("Word to find? ");
		findWord = in.nextLine();
		
		System.out.print("Replace it with? ");
		replaceWord = in.nextLine();
		
		Replacer doIt;
		try
		{
			doIt = new Replacer(inFilename, outFilename);
			int count = doIt.findReplace(findWord, replaceWord);
			System.out.println("DONE!  Replaced " + count + " occurances.");
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}		
	}

}
