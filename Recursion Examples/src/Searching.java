// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Dr. Dorn and Mr. Cavanaugh
// RESOURCES: The iterative algorithm in the lecture
//     slides served as our inspiration.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Searching
{
	public static boolean binarySearch(int[] haystack, int needle)
	{
		// call a helper method to which has a handier parameter list for recursion
		return binarySearchHelper(haystack, needle, 0, haystack.length - 1);
	}

	private static boolean binarySearchHelper(int[] haystack, int needle, int left, int right)
	{
		int mid = (right + left) / 2;

		// Create a temp var to eliminate 4 separate returns. This
		// is an improvement over the code from the video
		// which has a Checkstyle error because of too many
		// return statements (one in each branch).  
		boolean result;  
		
		//base case 1: needle is not found
		if (left > right)
		{
			result = false;
		}
		//base case 2: found it at the mid
		else if (haystack[mid] == needle)
		{
			result = true;
		}
		
		//general case 1: look left
		else if (needle < haystack[mid])
		{
			result = binarySearchHelper(haystack, needle, left, mid - 1);
		}
		//general case 2: look right
		else
		{
			result = binarySearchHelper(haystack, needle, mid + 1, right);
		}
		
		return result;  // return once at the end
	}
	
	public static void main(String[] args)
	{
		final int HOW_MANY = 20;
		int[] myListONums = getEasyArray(HOW_MANY);
		Scanner s = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Num? " );
			int val = s.nextInt();
			System.out.println("Found: " + binarySearch(myListONums, val));
		}	
		
	}
	
	
	public static int[] getSortedRandArray(int size)
	{
		int[] arr = new int[size];
		Random rand = new Random();
		
		for (int i = 0; i < size; i++)
		{
			arr[i] = rand.nextInt();  //any number will do
		}
		
		//just rely on built in sort
		Arrays.sort(arr);		
		return arr;
	}
	
	public static int[] getEasyArray(int size)
	{
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			arr[i] = i; 
		}
				
		return arr;
	}
}
