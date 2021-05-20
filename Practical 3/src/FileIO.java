import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO
{
	private String fileName;
	
	public FileIO(String fileNameIn)
	{
		fileName = fileNameIn;
	}
	
	public void write(String[] entries) throws FileNotFoundException
	{
		FileOutputStream out = new FileOutputStream(fileName);
		PrintWriter writer = new PrintWriter(out);
		
		for (int i = 0; i < entries.length; i++)
		{
			if (i == entries.length - 1)
			{
				writer.print(entries[i]);
			}
			else
			{
				writer.println(entries[i]);
			}
		}
		
		writer.close();
	}
	
	public ArrayList<String> read() throws FileNotFoundException
	{
		ArrayList<String> a = new ArrayList<String>();
		Scanner in = new Scanner(new File(fileName));
		
		while (in.hasNextLine())
		{
			a.add(in.nextLine());
		}
		in.close();
		
		return a;
	}
}
