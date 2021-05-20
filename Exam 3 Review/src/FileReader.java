import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class FileReader
{
	public static String bestCoffee(String stateIn) throws IOException
	{
		Scanner starbucksScan = new Scanner(new File("starbucks.txt"));
		Scanner dunkinScan = new Scanner(new File("dunkin.txt"));
		int starbucksVal = 0;
		int dunkinVal = 0;
		
		while (starbucksScan.hasNextLine())
		{
			Scanner a = new Scanner (starbucksScan.nextLine());
			a.useDelimiter(",");
			String id = a.next();
			int year = a.nextInt();
			int profit = a.nextInt();
			String state = a.next();
			a.close();
			if (state.equals(stateIn))
			{
				starbucksVal += profit;
			}
		}
		starbucksScan.close();
		while (dunkinScan.hasNextLine())
		{
			Scanner b = new Scanner (dunkinScan.nextLine());
			b.useDelimiter(",");
			String id = b.next();
			int year = b.nextInt();
			int profit = b.nextInt();
			String state = b.next();
			b.close();
			if (state.equals(stateIn))
			{
				dunkinVal += profit;
			}
		}
		dunkinScan.close();
		if (dunkinVal > starbucksVal)
		{
			return "Dunkin";
		}
		else
		{
			return "Starbucks";
		}
		
	}
	public static void main (String[] args) throws IOException
	{
		System.out.println(FileReader.bestCoffee("NE"));
	}
}
