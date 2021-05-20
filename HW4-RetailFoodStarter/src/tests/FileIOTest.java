// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import schedules.FileIO;
import schedules.InvalidDateException;
import schedules.RetailFoodEntry;

public class FileIOTest
{
	
	public RetailFoodEntry[] RFE()
	{
		RetailFoodEntry a = new RetailFoodEntry("1000 Degrees Neapolitan Pizzeria","17676 WELCH PLZ STE 9","EXCELLENT","10/25/2018","MEDIUM");
		RetailFoodEntry[] b = {a,a,a,a,a,a,a,a,a};
		return b;
	}
	
	public RetailFoodEntry[] badRatingRFE()
	{
		RetailFoodEntry a = new RetailFoodEntry("1000 Degrees Neapolitan Pizzeria","17676 WELCH PLZ STE 9","nice","10/25/2018","MEDIUM");
		RetailFoodEntry[] b = {a,a,a,a,a,a,a,a,a};
		return b;
	}
	
	public RetailFoodEntry[] badDateRFE()
	{
		RetailFoodEntry a = new RetailFoodEntry("1000 Degrees Neapolitan Pizzeria","17676 WELCH PLZ STE 9","EXCELLENT","10/2d5/2018","MEDIUM");
		RetailFoodEntry[] b = {a,a,a,a,a,a,a,a,a};
		return b;
	}
	
	@Test
	public void testConstrucor()
	{
		FileIO test = new FileIO("output.txt");
	}
	
	@Test
	public void testWrite() throws IOException
	{
		RetailFoodEntry[] entries = RFE();
		FileIO test = new FileIO("output.txt");
		test.writeFile(entries);
	}
	
	@Test
	public void testRead() throws IOException
	{
		RetailFoodEntry[] entries;
		FileIO test = new FileIO("output.txt");
		entries = test.readFile();
		
		assertEquals(9, entries.length);
		
		for (int i = 0; i < entries.length; i++)
		{
			assertEquals("1000 Degrees Neapolitan Pizzeria,17676 WELCH PLZ STE 9,EXCELLENT,10/25/2018,MEDIUM",
					entries[i].toString());
		}
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testBadInput() throws IOException
	{
		thrown.expect(IllegalArgumentException.class);
		RetailFoodEntry[] entries = badRatingRFE();
		FileIO test = new FileIO("output.txt");
		test.writeFile(entries);
	}
	
	@Test
	public void testBadDate() throws IOException
	{
		thrown.expect(InvalidDateException.class);
		RetailFoodEntry[] entries = badDateRFE();
		FileIO test = new FileIO("output.txt");
		test.writeFile(entries);
	}
	
	@Test
	public void testReadBadFile() throws IOException
	{
		RetailFoodEntry[] entries;
		FileIO test = new FileIO("entries.txt");
		entries = test.readFile();
		
		assertEquals(7, entries.length);
		
		for (int i = 0; i < entries.length; i++)
		{
			assertEquals("1000 Degrees Neapolitan Pizzeria,17676 WELCH PLZ STE 9,EXCELLENT,10/25/2018,MEDIUM",
					entries[i].toString());
		}
	}
	
	@Test
	public void testReadCSV() throws IOException
	{
		RetailFoodEntry[] entrieser;
		FileIO tester = new FileIO("Rating_List.csv");
		entrieser = tester.readFile();
		
		System.out.println(entrieser.length);
	}
}
