// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 7 slides.

package recursionlab;

////////////////////////////////////////////////////////////
//
// NOTE: No loops or fields are allowed in this file!
//       Solve these methods using only 
//       recursion.  
//
//       Use of fields will be penalized by WebCAT testing,
//       and points will be scaled proportionally based on 
//       your use of recursion.  If you use for/while to solve
//       these problems you will have points deducted!
//
////////////////////////////////////////////////////////////
/**
 * Class that holds recursive methods.
 * @author joelsare
 *
 */
public class LittleRecursions
{
	/**
	 * Determines if a given String is a palindrome 
	 * (meaning it is the same forwards and backwards).
	 * Comparison of characters are not case sensitive.
	 * 
	 * <P>Thus, the following are palindromes
	 * <BR>RACECAR
	 * <BR>rAcECar
	 * <BR>aBbA
	 * <P>The following are NOT palindromes
	 * <BR>DOG
	 * <BR>Taylor Swift
	 * <BR>OO00
	 * 
	 * @param s The string to check for palindrome status.
	 * @return True if and only if s is a palindrome; false otherwise.
	 */
	public static boolean isPalindrome(String s)
	{
		boolean result;
		if (s.length() == 0 || s.length() == 1)
		{
			result = true;
		}
		else if (Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(s.charAt(s.length() - 1)))
		{
			return isPalindrome(s.substring(1, s.length() - 1));
		}
		else
		{
			result = false;
		}
		return result;
	}
	
	
	/**
	 * Creates a string like the one given in the input parameter, but
	 * with all letters in reverse order.  All non-letters will be 
	 * removed from the final string.  For example:
	 * 
	 * <p>reverseSome("asdf") ==> "fdsa"
	 * <br>reverseSome("this is a test") ==> "tsetasisiht"
	 * <br>reverseSome("ABC 123!") ==> "CBA"
	 * 
	 * @param s The string to reverse.
	 * @return A version of s in which all letter characters are in 
	 * the reverse order of the original.
	 */
	public static String reverseSome(String s)
	{
		if (s == null || s.equals(""))
		{
			return s;
		}
		else if (Character.isLetter(s.charAt(0)))
		{
			return reverseSome(s.substring(1)) + s.charAt(0);
		}
		else
		{
			return reverseSome(s.substring(1));
		}
	}
	
	/**
	 * This method computes the greatest common divisor
	 * of two numbers using Euclid's algorithm. 
	 * 
	 * <p>Mathematically, gcd is recursively defined as:
	 * <br>gcd(x, 0) = x
	 * <br>gcd(x, y) = gcd(y, x mod y)
	 * 
	 * @param x The first operand in the greatest common divisor.
	 * @param y The second operand in the greatest common divisor.
	 * @return The greatest common divisor of x and y.
	 */
	public static int gcd(int x, int y)
	{
		if (y == 0)
		{
			return x;
		}
		else
		{
			return gcd(y, x % y);
		}
	}
	
	/**
	 * Computes the sum of all positive values in the
	 * array parameter.
	 * 
	 * @param array The array of values to consider
	 * @return The additive sum of all integers in array that are
	 *         positive.  The sum will be 0 when the array 
	 *         parameter is null.  
	 */
	public static int sumPositive(int[] array)
	{
		return sumPositiveHelper(array, 0);
	}
	
	/**
	 * Helper method for sumPositive.
	 * @param array the array to be added.
	 * @param left the left index.
	 * @return the sum.
	 */
	private static int sumPositiveHelper(int[] array, int left)
	{
		int sum = 0;
		if (array == null || left > array.length - 1)
		{
			return sum;
		}
		else if (array[left] > 0)
		{
			return sum + array[left] + sumPositiveHelper(array, left + 1);
		}
		else
		{
			return sum + sumPositiveHelper(array, left + 1);
		}
	}
}
