// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package sorting;

/**
 * This utility class provides a basic sorting method that enables a broad range of comparisons.
 * @author joelsare
 *
 */
public class SortData
{
	/**
	 * Default constructor for SortData.
	 */
	public SortData()
	{
		//Instantiates a SortData object.
	}
	
	/**
	 * Generic method to sort a list of objects based on a comparator. The ordering for the sorted list
	 * will be determined by comparator.
	 * @param <E> the type of a single item in the list.
	 * @param <T> the type of the comparator to use for sorting items of type E.
	 * @param list objects to be sorted.
	 * @param compar defines the comparison for the list.
	 */
	public static <E, T extends java.util.Comparator<E>> void sort(E[] list, T compar)
	{
		for (int pass = 0; pass < list.length - 1; pass++)  // count passes
		{
			for (int comp = 0; comp < list.length - 1; comp++)
			{
				if (compar.compare(list[comp], list[comp + 1]) > 0)
				{
					E temp = list[comp];
					list[comp] = list[comp + 1];
					list[comp + 1] = temp;
				}				
			}
		}
	}
}
