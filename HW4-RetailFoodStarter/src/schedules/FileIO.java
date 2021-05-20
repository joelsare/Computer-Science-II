// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package schedules;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class to read and write RetailFoodEntry values to a file.
 * @author joelsare
 *
 */
public class FileIO
{
	/**
	 * Max number of entries.
	 */
	private static final int MAX_ENTRIES = 10000; 
	
	/**
	 * Name of file.
	 */
	private String fileName;
	
	/**
	 * Constructor takes the file name of a file to read or write to.
	 * @param fileIn input file name.
	 */
	public FileIO(String fileIn)
	{
		fileName = fileIn;
	}
	
	/**
	 * Method to read all entries in the file. Files contain the comma separated values.
	 * Following the a header row, each line corresponds to one RetailFoodEntry.
	 * @return Array of all valid RetailFoodEntry objects in the read file.
	 * @throws FileNotFoundException if the file specified in the constructor does not exist.
	 */
	public RetailFoodEntry[] readFile() throws FileNotFoundException
	{
		RetailFoodEntry[] result = new RetailFoodEntry[MAX_ENTRIES];
		Scanner in = new Scanner(new FileInputStream(fileName));
		in.nextLine();
		in.useDelimiter(",");
		int i = 0;
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			Scanner a = new Scanner(line);
			a.useDelimiter(",");
			
			try
			{
				String name = a.next();
				String address = a.next();
				String rating = a.next();
				String date = a.next();
				String risk = a.next();
				result[i] = new RetailFoodEntry(name, address, rating, date, risk);
				i++;
			}
			catch (IllegalArgumentException iae)
			{
				System.out.println("Skipping entry - illegal argument");
			}
			catch (InvalidDateException ide)
			{
				System.out.println("Skipping entry - bad date");
			}
			catch (java.util.NoSuchElementException nsee)
			{
				System.out.println("Skiping entry - no such element");
			}
			finally
			{
				a.close();
			}
		}
		in.close();
		
		RetailFoodEntry[] cleaned = new RetailFoodEntry[i];
		for (int j = 0; j < i; j++)
		{
			cleaned[j] = result[j];
		}
		
		return cleaned;
	}
	
	/**
	 * Method to write the entries to the file.
	 * @param entries The entries to be written to this file.
	 * @throws FileNotFoundException if file cannot be found.
	 */
	public void writeFile(RetailFoodEntry[] entries) throws FileNotFoundException
	{
		FileOutputStream out = new FileOutputStream(fileName);
		PrintWriter writer = new PrintWriter(out);
		
		writer.println("Name,Address,RATING,CURRENT,RISK");
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
	
	
}
