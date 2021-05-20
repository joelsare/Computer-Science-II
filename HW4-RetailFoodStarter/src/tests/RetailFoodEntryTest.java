// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import schedules.Rating;
import schedules.RetailFoodEntry;
import schedules.Risk;

public class RetailFoodEntryTest
{

	public RetailFoodEntry newRFE()
	{
		RetailFoodEntry a = new RetailFoodEntry("Name", "Address", "FAIR", "01/31/2019",
				"LOW");
		return a;
	}
	
	@Test
	public void testConstructor()
	{
		RetailFoodEntry a = newRFE();
	}
	
	@Test
	public void testgetName()
	{
		RetailFoodEntry a = newRFE();
		assertEquals("Name", a.getName());
	}
	
	@Test
	public void testgetAddress()
	{
		RetailFoodEntry a = newRFE();
		assertEquals("Address", a.getAddress());
	}
	
	@Test
	public void testgetDate()
	{
		RetailFoodEntry a = newRFE();
		assertEquals("01/31/2019", a.getDate().toString());
	}
	
	@Test
	public void testgetRating()
	{
		RetailFoodEntry a = newRFE();
		assertEquals(Rating.FAIR, a.getRating());
	}
	
	@Test
	public void testgetRisk()
	{
		RetailFoodEntry a = newRFE();
		assertEquals(Risk.LOW, a.getRisk());
	}
	
	@Test
	public void testtoString()
	{
		RetailFoodEntry a = newRFE();
		assertEquals("Name,Address,FAIR,01/31/2019,LOW", a.toString());
	}
	
	@Test
	public void testcompareToSame()
	{
		RetailFoodEntry a = newRFE();
		RetailFoodEntry b = newRFE();
		assertTrue(a.compareTo(b) == 0);
	}
	
	@Test
	public void testcompareToLower()
	{
		RetailFoodEntry a = newRFE();
		RetailFoodEntry b = new RetailFoodEntry("Zame", "Address", "FAIR", "01/31/2019",
				"LOW");
		assertTrue(a.compareTo(b) < 0);
	}
	
	@Test
	public void testcompareToHigher()
	{
		RetailFoodEntry a = newRFE();
		RetailFoodEntry b = new RetailFoodEntry("Zame", "Address", "FAIR", "01/31/2019",
				"LOW");
		assertTrue(b.compareTo(a) > 1);
	}

}
