// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: <a disclosure of the resources used>
/**	
 * Lab to practice Checkstyle formatting. 	
 * @author Joel Sare
 */  	
public class CheckstyleLab
{
    /**
     * Constant variable for the size of an array.
     */
	private static final int ARR_SIZE = 10;
    /**
     * Main method which calculates the sum of the squares of the integers 1 to 10 inclusive.	
     * @param args Command line arguments (Unused)	
     */
	public static void main(String[] args)
	{
		int[] squares = new int[ARR_SIZE];
		for (int i = 0; i < 10; i++)
		{
			squares[i] = (int) Math.pow(i + 1, 2);
			System.out.printf("Square of %d is %d\n", i + 1, squares[i]);  	
		}
		System.out.printf("The sum of the squares is %d!\n", sumArray(squares));	
	}
    /** 	
     * This method returns the sum of the values in the arr parameter or zero when arr is null.  	
     * @param arr with integer values.  	
     * @return integer value that is the sum of all values.	
     */
	public static int sumArray(int[] arr)
	{
		int sum = 0;
		if (arr != null) 
		{
			for (int i = 0; i < arr.length; i++)
			{
				sum += arr[i];
			}
		}
		return sum;
	}
}