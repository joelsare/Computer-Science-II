// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 6 slides.

package datautils.test;

import java.util.Random;
import datautils.ArrayOrder;
import datautils.Sorting;

/**
 * This test driver is provided to help partially verify components of your
 * sorting algorithms and v.
 * 
 * @author bdorn
 *
 */
public class SortingDriver
{		
	/**
	 * This main method conducts a series of timing experiments on sorting algorithms. 
	 * 
	 * @param args Command line arguments, not used.
	 */
	public static void main(String[] args)
	{
		// TODO: STEP 2: Conduct Timing Experiments, modify this code to conduct the necessary timing experiments
		// to complete the worksheet.
		
		// Here's an example to get you started.
		runExperiment("Small Array  (n=100), Random Values", generateIntegerArray(100, ArrayOrder.RANDOM));

	}
	
	
	/**
	 * A helper method that conducts a timing run of each sorting algorithm on a copy of the 
	 * input data.
	 * @param msg A descriptive name for this experiment to be printed to the screen along 
	 * 			  with timing results.
	 * @param array The values to use for this experiment.
	 */
	private static void runExperiment(String msg, int[] array)
	{
		System.out.println("  EXPERIMENT: " + msg);
		
		//Create 3 separate copies of this array so that the algorithms don't interfere with each
		//other
		int[] copy1 = copyArray(array);
		int[] copy2 = copyArray(array);
		int[] copy3 = copyArray(array);

		long start;
		long end;		
		
		// Run Bubble Sort
		start = System.nanoTime();
		Sorting.bubbleSort(copy1);
		end = System.nanoTime();
		System.out.println("       BUBBLE SORT: " + (end - start) + " nanoseconds");
		
		//TODO: STEP 1: Add the necessary timing code here to also time selection and insertion sorts. 
		//      This will look similar to the code for bubble sort you see above.  Be sure to use a 
		//      different copy of the array for each sorting call so that you're comparing apples to apples.
		
	}
	
	
	/**
	 * Generates an array of values for testing purposes.
	 * 
	 * @param size the number of elements in the returned array
	 * @param shape specifies what kind of array should be generated wrt its initial ordering
	 *              
	 * @return the array that was created per the parameters
	 */
	private static int[] generateIntegerArray(int size, ArrayOrder shape)
	{
		int[] result = new int[size];
		Random nums = new Random();
		for (int i = 0; i < size; i++)
		{
			switch (shape)
			{
				case RANDOM:
					result[i] = nums.nextInt();
					break;
				case INORDER:
					result[i] = i;
					break;
				case REVERSE: 
					result[i] = size - i;
					break;
				default:
					throw new RuntimeException("Invalid shape parameter value!");
			}
		}
		return result;
	}
	
	/**
	 * Utility method to print an array to the console.
	 * 
	 * @param data The data to be displayed
	 */
	private static void printArray(int[] data)
	{
		System.out.print("{");
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i]);
			if (i < data.length - 1)
			{
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	/**
	 * Utility method to copy an array.
	 * @param data The array to be copied
	 * @return A shallow copy of the items in the array specified.
	 */
	private static int[] copyArray(int[] data)
	{
		int[] result = new int[data.length];	
		for (int i = 0; i < data.length; i++)
		{
			result[i] = data[i];
		}
		return result;
	}
}
