// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package molecule;

import java.util.Stack;

import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * Objects of the Molecule class represent a single chemical molecule made up of any number
 * of H, C, and O atoms. The class provides functionality to compute the atomic weight of
 * the molecule.
 * @author joelsare
 *
 */
public class Molecule implements Cloneable, Comparable<Molecule>
{
	/**
	 * Sequence of C's H's and O's.
	 */
	private String sequence;
	/**
	 * Creates a new Molecule made up of the H, C, and O atoms in the configuration specified by
	 * sequenceIn.
	 * @param sequenceIn The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException if any non C, H, O atoms exists in sequenceIn.
	 * @throws InvalidSequenceException if unmatched parentheses exist in sequenceIn or incoming
	 * sequenceIn is null or empty String.
	 */
	public Molecule(String sequenceIn) throws InvalidAtomException, InvalidSequenceException
	{
		setSequence(sequenceIn);
	}
	
	/**
	 * Updates the sequence of atoms represented by this Molecule.
	 * @param sequenceIn The new molecular sequence to be used for this Molecule.
	 * @throws InvalidAtomException if any non C, H, O atoms exists in sequenceIn.
	 * @throws InvalidSequenceException if unmatched parentheses exist in sequenceIn or incoming
	 * sequenceIn is null or empty String.
	 */
	public void setSequence(String sequenceIn) throws InvalidAtomException, InvalidSequenceException
	{
		if (sequenceIn == null || sequenceIn.equals("") || Character.isDigit(sequenceIn.charAt(0)))
		{
			throw new InvalidSequenceException();
		}
		
		String parantheses = "";
		String elements = "";

		for (int i = 0; i < sequenceIn.length(); i++)
		{
			if (sequenceIn.charAt(i) == '(' || sequenceIn.charAt(i) == ')')
			{
				parantheses += sequenceIn.charAt(i);
			}
			else if (Character.isAlphabetic(sequenceIn.charAt(i)))
			{
				elements += sequenceIn.charAt(i);
			}
			else if (!Character.isDigit(sequenceIn.charAt(i)))
			{
				throw new InvalidAtomException(sequenceIn.charAt(i));
			}
				
		}
		
		if (!isValid(parantheses))
		{
			throw new InvalidSequenceException();
		}
		
		validChars(elements);
		
		sequence = sequenceIn;
	}
	
	/**
	 * Checks to see if string has correctly nested parentheses.
	 * @param str String to be checked.
	 * @return true if valid, false if not.
	 */
	private boolean isValid(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		if (!str.equals(""))
		{
			for (int i = 0; i < str.length(); i++)
			{ 
				char ch = str.charAt(i);
				if (ch == '(')
				{
					stack.push(ch);
				}
				else
				{
					if (stack.isEmpty())
					{
						return false;
					}
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
	
	/**
	 * Checks to see if string contains only O, C, or H.
	 * @param str String to be checked.
	 */
	public static void validChars(String str)
	{
		if (str.equals(""))
		{
			throw new InvalidSequenceException();
		}
		for (int i = 0; i < str.length(); i++)
		{
			boolean valid = Character.toLowerCase(str.charAt(i)) == 'c' 
					|| Character.toLowerCase(str.charAt(i)) == 'o'
					|| Character.toLowerCase(str.charAt(i)) == 'h';
			if (!valid)
			{
				throw new InvalidAtomException(str.charAt(i));
			}
		}
	}
	
	/**
	 * Retrieves a String containing this Molecule's sequence of atoms.
	 * @return Molecular sequence of the Molecules.
	 */
	public String getSequence()
	{
		return sequence;
	}
	
	/**
	 * Retrieves this Molecule's weight, which is calculated based on the Molecule's sequence per
	 * the algorithm specified.
	 * @return Weight of the Molecule.
	 */
	public int getWeight()
	{
		Stack<Integer> stack = new Stack<Integer>();
		String string = "(" + sequence + ")";
		
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == '(')
			{
				stack.push(-1);
			}
			else if (Character.isLetter(string.charAt(i)))
			{
				stack.push(atomWeight(string.charAt(i)));
			}
			else if (Character.isDigit(string.charAt(i)))
			{
				String str = getNums(string, i);
				i += str.length() - 1;
				int num = Integer.parseInt(str);
				int topInt = stack.pop();
				int result = num * topInt;
				stack.push(result);
			}
			else
			{
				int sum = 0;
				while (stack.peek() != -1)
				{
					sum += stack.pop();
				}
				stack.pop();
				stack.push(sum);
			}
		}
		return stack.pop();
	}
	
	/**
	 * Reads all integers.
	 * I had to make this public and static in order to call it in tests directly to get 100% in coverage tests,
	 * I know because it's a helper method, it should be private.
	 * @param str String to be checked.
	 * @param index Index where to start.
	 * @return A number found in str.
	 */
	public static String getNums(String str, int index)
	{
		String result = "";
		for (int i = index; i < str.length(); i++)
		{
			if (Character.isDigit(str.charAt(i)))
			{
				result += String.valueOf(str.charAt(i));
			}
			else
			{
				break;
			}
		}
		return result;
	}
	
	/**
	 * Generates and returns a String with Molecule's sequence and weight.
	 * @return The generated String.
	 */
	public String toString()
	{
		return String.format("%-25s: %d", getSequence(), getWeight());
	}
	
	/**
	 * Return atomic weight of a given atom. Supported ones are C, H, and O. Case insensitive.
	 * @param atom Character for atom abbreviation.
	 * @return Atomic weight of passed atom.
	 * @throws InvalidAtomException If an unsupported atom is passed.
	 */
	public static int atomWeight(char atom) throws InvalidAtomException
	{
		final int H = 1;
		final int C = 12;
		final int O = 16;
		
		char c = Character.toLowerCase(atom);
		int val = 0;
		switch (c)
		{
			case 'h':
				val = H;
				break;
			case 'c':
				val = C;
				break;
			case 'o':
				val = O;
				break;
			default:
				throw new InvalidAtomException(c);
		}
		return val;
	}
	
	/**
	 * Compares this Molecule to a passed Molecule, determining natural order. Molecules with same
	 * weight are equal.
	 * @param other Molecule to be compared with this local Molecule.
	 * @return An int < 0 if local is < other. int > 0 if local is > other. 0 if Molecules are equal.
	 */
	public int compareTo(Molecule other)
	{
		return Integer.compare(this.getWeight(), other.getWeight());
	}
	
	/**
	 * Returns a deep copy of the Molecule. The reference returned should refer to a completely different
	 * molecule with no direct or indirect aliasing of any instance data in the original.
	 * @return Deep copy of the calling Molecule.
	 */
	public Object clone()
	{
		try
		{
			Molecule clone = (Molecule) super.clone();
			String localSequence = sequence;
			clone.setSequence(localSequence);
			return clone;
		}
		catch (CloneNotSupportedException cns)
		{
			throw new RuntimeException();
		}
	}
}
