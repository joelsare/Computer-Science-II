// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Dr. Dorn, Mr. Cavanaugh, and the Dietels
// RESOURCES: This code is based on the merge sort
//      code from the textbook with our added 
//      annotations to help you see what is happening.

/**
 * This class provides an implementation of mergeSort.
 * 
 * @author Dr. Dorn, Mr. Cavanaugh, and the Dietels!
 */
public class MergeSort
{

	/**
	 * Sorts passed data using Merge Sort by modifying the input array. 
	 * 
	 * @param data The data to be sorted.
	 */
	public static void sort(int[] data)
	{
		mergeSortHelper(data, 0, data.length - 1);
	}
	
	/**
	 * Recursive helper method for mergeSort.
	 * @param data The data in which the sub-array is located
	 * @param left Lower index of the sub-array.
	 * @param right Upper index of the sub-array.
	 */
	private static void mergeSortHelper(int[] data, int left, int right)
	{
		//General Case: The sublist has at least one item in it.
		if ((right - left) >= 1)	
		{
			int middle1 = (left + right) / 2;
			int middle2 = middle1 + 1;
			
			mergeSortHelper(data, left, middle1);
			mergeSortHelper(data, middle2, right);

			merge(data, left, middle1, middle2, right);
		}
	}
	
	/**
	 * Helper method for merge sort. Merges two sub-arrays into sorted order.
	 * 
	 * @param data The data in which the sub-arrays are located
	 * @param left Lower index of first sub-array.
	 * @param middle1 Upper index of first sub-array.
	 * @param middle2 Lower index of second sub-array.
	 * @param right Upper index of second sub-array.
	 */
	private static void merge(int[] data, int left, int middle1, int middle2, int right)
	{
		int leftIndex = left;					// Local variables for tracking left and right
		int rightIndex = middle2;				// while merging.
		
		int[] combined = new int[data.length];	// A temporary place where we can store our merged results 
		
		int combinedIndex = left;		        //The position we are at filling up combined
		                                
		// As long as both subarray pieces have data still in them, 
		// we need to keep picking the next smallest from the start
		// of each and putting it into combined
		while (leftIndex <= middle1 && rightIndex <= right)
		{
			// Is the first item of the left subarray smaller?
			if (data[leftIndex] <= data[rightIndex])
			{
				combined[combinedIndex++] = data[leftIndex++];
			}
			// Or is the first item in the right one smaller?
			else 
			{
				combined[combinedIndex++] = data[rightIndex++];
			}
		}

		// If the left sub-array has run out of values, we need
		// to go through emptying the remainder from the right
		if (leftIndex == middle2)
		{
			while (rightIndex <= right)
			{
				combined[combinedIndex++] = data[rightIndex++];
			}
		}
		// Otherwise, check whether the right one is empty and 
		// grab any remaining values from the left sub-array
		else
		{
			while (leftIndex <= middle1)
			{
				combined[combinedIndex++] = data[leftIndex++];
			}
		}
			
		// Lastly, copy the merged array values back into the 
		// original input array so it will be sorted after
		// returning from merge.
		for (int i = left; i <= right; i++)
		{
			data[i] = combined[i];
		}		
	}
}

