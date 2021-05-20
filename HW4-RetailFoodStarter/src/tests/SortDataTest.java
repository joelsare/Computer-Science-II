// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import schedules.RetailFoodEntry;
import sorting.EntryDateComparator;
import sorting.EntryNameComparator;
import sorting.EntryRatingComparator;
import sorting.EntryRiskComparator;
import sorting.SortData;

public class SortDataTest
{
	public RetailFoodEntry[] rfea()
	{
		RetailFoodEntry a = new RetailFoodEntry("ALLEN", "Address", "FAIR", "10/30/2019", "LOW");
		RetailFoodEntry b = new RetailFoodEntry("BARBARA", "Address", "SUPERIOR", "10/31/2019", "HIGH");
		RetailFoodEntry c = new RetailFoodEntry("SUSAN", "Address", "STANDARD", "10/31/2020", "MEDIUM");
		RetailFoodEntry d = new RetailFoodEntry("JOEL", "Address", "EXCELLENT", "11/31/1998", "LOW");


		RetailFoodEntry[] arr = {d,b,c,a,a,a,d,c,b,b,a,d,c,d,b,d};
		return arr;
	}
	
	public void print(RetailFoodEntry[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
		System.out.println();
	}
	
	@Test
	public void testConstructor()
	{
		SortData a = new SortData();
	}
	
	@Test
	public void testByName()
	{
		RetailFoodEntry[] newarray = rfea();
		System.out.println("Before:");
		print(newarray);
		SortData.sort(newarray, new EntryNameComparator());
		System.out.println("Sorted by name:\n");
		print(newarray);
	}
	
	@Test
	public void testByRating()
	{
		RetailFoodEntry[] newarray = rfea();
		SortData.sort(newarray, new EntryRatingComparator());
		System.out.println("Sorted by rating:\n");
		print(newarray);
	}
	
	@Test
	public void testByRisk()
	{
		RetailFoodEntry[] newarray = rfea();
		SortData.sort(newarray, new EntryRiskComparator());
		System.out.println("Sorted by risk:\n");
		print(newarray);
	}
	
	@Test
	public void testByDate()
	{
		RetailFoodEntry[] newarray = rfea();
		SortData.sort(newarray, new EntryDateComparator());
		System.out.println("Sorted by date:\n");
		print(newarray);
	}

}
