import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Replacer
{
	public Replacer(String inFile, String outFile) throws FileNotFoundException 
	{
		Scanner in = new Scanner(new File(inFile));
		FileOutputStream input = new FileOutputStream(outFile, false);
		PrintWriter writer = new PrintWriter(input);
		
		while (in.hasNextLine())
		{
			String result = in.nextLine();
			writer.println(result);
		}
		in.close();
	}
	
	public int findReplace(String findWord, String replaceWord)
	{
		return 0;
	}
}
