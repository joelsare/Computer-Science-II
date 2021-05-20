// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import schedules.RetailFoodEntry;
import sorting.EntryRiskComparator;

public class EntryRiskComparatorTest
{

	@Test
	public void testcompareSame()
	{
		EntryRiskComparator erc = new EntryRiskComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		assertEquals(0, erc.compare(a, b));
	}
	
	@Test
	public void testcompareLess()
	{
		EntryRiskComparator erc = new EntryRiskComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "MEDIUM");
		assertEquals(-1, erc.compare(a, b));
	}
	
	@Test
	public void testcompareHigher()
	{
		EntryRiskComparator erc = new EntryRiskComparator();
		RetailFoodEntry a = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "HIGH");
		RetailFoodEntry b = new RetailFoodEntry("NAME", "ADDRESS", "FAIR",
				"10/31/2019", "LOW");
		assertEquals(1, erc.compare(a, b));
	}

}
