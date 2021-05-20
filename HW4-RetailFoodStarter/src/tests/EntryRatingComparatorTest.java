// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import schedules.RetailFoodEntry;
import sorting.EntryRatingComparator;

public class EntryRatingComparatorTest
{

	@Test
	public void testcompareSame()
	{
		EntryRatingComparator erc = new EntryRatingComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		assertEquals(0, erc.compare(a, b));
	}
	
	@Test
	public void testcompareLower()
	{
		EntryRatingComparator erc = new EntryRatingComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "SUPERIOR",
				"10/31/2019", "LOW");
		assertEquals(-1, erc.compare(a, b));
	}
	
	@Test
	public void testcompareHigher()
	{
		EntryRatingComparator erc = new EntryRatingComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "SUPERIOR",
				"10/31/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		assertEquals(1, erc.compare(a, b));
	}
	
	@Test
	public void testcompareAnotherHigher()
	{
		EntryRatingComparator erc = new EntryRatingComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "EXCELLENT",
				"10/31/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "STANDARD",
				"10/31/2019", "LOW");
		assertEquals(1, erc.compare(a, b));
	}

}
