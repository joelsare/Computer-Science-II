import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileIOTester
{
	public static void main (String[] args) throws FileNotFoundException
	{
		FileIO io = new FileIO("p.txt");
		
		String[] entries = {"Hello", "There", "how", "are", "you doing today"};
		io.write(entries);
		
		ArrayList results = io.read();
		
		for (int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i));
		}
	}
}
