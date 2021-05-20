// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package sorting;

import java.util.Comparator;

import schedules.Rating;
import schedules.RetailFoodEntry;

/**
 * Compares two RetailFoodEntry objects based on Rating.
 * @author joelsare
 *
 */
public class EntryRatingComparator implements Comparator<RetailFoodEntry>
{
	/**
	 * Default constructor. :)
	 */
	public EntryRatingComparator()
	{
		//just instantiates an object
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
		int aVal = getValue(a.getRating());
		int bVal = getValue(b.getRating());
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
	 * @param rating Rating value to be checked.
	 * @return Int depending on Rating value.
	 */
	private int getValue(Rating rating)
	{
		int val = 0;
		switch (rating)
		{
			case SUPERIOR:
				val = 4;
				break;
			case EXCELLENT:
				val = 3;
				break;
			case STANDARD:
				val = 2;
				break;
			case FAIR:
				val = 1;
				break;
			default:
				break;
		}
		return val;
	}
}

