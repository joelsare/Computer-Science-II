package originalfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Replacer
{
	private Scanner inFile;
	private PrintWriter outFile;
	private FileOutputStream input;
	
	
	public Replacer(String inFileName, String outFileName) throws FileNotFoundException
	{	
		inFile = new Scanner(new File(inFileName));
		input = new FileOutputStream(outFileName, false);
	}
	
	/**
	 * This method will search the input file and replace all occurrences of
	 * findWord with replaceWord and write the new contents to the output file.
	 * 
	 * @param findWord The word to find.
	 * @param replaceWord The word to replace.
	 * @return The total number of times the findWord was replaced.
	 */
	public int findReplace(String findWord, String replaceWord)
	{	
		int sum = 0;
		PrintWriter outFile = new PrintWriter(input);
		
		while (inFile.hasNextLine())
		{
			String input = inFile.nextLine();
			Scanner lineReader = new Scanner(input);
			String word = null;
			while (lineReader.hasNext())
			{
				word = lineReader.next();
				if (word.equals(findWord))
				{
					
				}
			}
			
		}
		inFile.close();
		outFile.close();
		
		return sum;
	}
	

}
