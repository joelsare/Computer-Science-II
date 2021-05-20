// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package sorting;

import java.util.Comparator;

import schedules.RetailFoodEntry;
import schedules.Risk;

/**
 * Compares two RetailFoodEntry objects based on Risk.
 * @author joelsare
 *
 */
public class EntryRiskComparator implements Comparator<RetailFoodEntry>
{
	/**
	 * Default constructor.
	 */
	public EntryRiskComparator()
	{
		//Instantiates the object.
	}
	
	/**
	 * Comparison method will take in two RetailFOodEntry objects and compare the Rating
	 * of each of them. Dates are ordered as follows:
	 * SUPERIOR > EXCELLENT > STANDARD > POOR
	 * @param a The first RetailFoodEntry
	 * @param b The second RetailFoodEntry
	 * @return a negative integer, zero or a positive integer as the first argument is less
	 * than, equal to, or greater than the second.
	 */
	public int compare(RetailFoodEntry a, RetailFoodEntry b)
	{
		int aVal = getValue(a.getRisk());
		int bVal = getValue(b.getRisk());
		int result;
		
		if (aVal == bVal)
		{
			result = 0;
		}
		else if (aVal < bVal)
		{
			result = -1;
		}
		else
		{
			result = 1;
		}
		return result;
	}
	
	/**
	 * Returns an int depending on Rating value.
	 * HIGH > MEDIUM > LOW
	 * @param rating Rating value to be checked.
	 * @return Int depending on Rating value.
	 */
	private int getValue(Risk rating)
	{
		int val = 0;
		switch (rating)
		{
			case HIGH:
				val = 3;
				break;
			case MEDIUM:
				val = 2;
				break;
			case LOW:
				val = 1;
				break;
			default:
				break;
		}
		return val;
	}
}
