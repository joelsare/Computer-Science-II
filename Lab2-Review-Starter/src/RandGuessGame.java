// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: I used the RandGuessGame Javadoc.

/**
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 * @author Joel Sare
 */
public class RandGuessGame
{

	//Declare data members
	/**
	 * Number of generated numbers.
	 */
	private static final int ARR_SIZE = 5;
	/**
	 * Maximum value of randomly generated values.
	 */
	private static final int MAX_VALUE = 100;
	/**
	 * Stores the sum of the array.
	 */
	private int arraySum;
	/**
	 * The player's guess.
	 */
	private char guess;
	/**
	 * Number the player must guess against which is calculated with MAX_VALUE and ARR_SIZE.
	 */
	private int guessTarget;
	/**
	 * Determines if the middle values are hidden.
	 */
	private boolean hideMiddleValues;
	/**
	 * Array that stores the randomly generated values.
	 */
	private int[] numbers;
	/**
	 * Random number generator used for game.
	 */
	private java.util.Random rand;
	/**
	 * Specific constructor for game.
	 * @param randIn random number generator object.
	 */
	public RandGuessGame(java.util.Random randIn)
	{
		numbers = new int[ARR_SIZE];
		arraySum = 0;
		guessTarget = ARR_SIZE * (MAX_VALUE / 2);
		rand = randIn;
		hideMiddleValues = true;
	}
	
	/**
	 * Assigns random values to the array 'numbers' between 1 and MAX_VALUE.
	 */
	public void populateArray()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(MAX_VALUE) + 1;
		}
		arraySum = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			arraySum += numbers[i];
		}
	}
	
	/**
	 * Retrieves the numbers array. Used for testing, do not change.
	 * @return The numbers array.
	 */
	public int[] getNumbers()
	{
		return numbers;
	}
	
	/**
	 * Toggles value of hideMiddleValues. If true assign false and vice-versa.
	 */
	public void toggleHidden()
	{
		if (hideMiddleValues)
		{
			hideMiddleValues = false;
		}
		else
		{
			hideMiddleValues = true;
		}
	}
	
	/**
	 * Returns a string, hides middle values depending on if 'hideMiddleValue' is true or false.
	 * @return a string of the values in 'numbers' hiding the middle values depending on 'hideMiddleValues'.
	 */
	public String toString()
	{
		if (hideMiddleValues)
		{
			return String.format("%d X X X %d ", numbers[0], numbers[4]);
		}
		else
		{
			return String.format("%d %d %d %d %d ", numbers[0], numbers[1], numbers[2], 
					numbers[3], numbers[4]);
		}
	}
	
	/**
	 * This method determines if the player answered with 'Y' or 'N'.
	 * @param guessIn The player's guess.
	 * @return true if input is valid, false if it is not.
	 */
	public boolean validatePlayerGuess(char guessIn)
	{
		if (guessIn == 'Y' || guessIn == 'N')
		{
			guess = guessIn;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Determines if the player won the game.
	 * @return a String determining if the player won the game or not.
	 */
	public String getResult()
	{
		arraySum = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			arraySum += numbers[i];
		}
		if (guess == 'Y' && arraySum > guessTarget || guess == 'N' && arraySum < guessTarget)
		{
			return String.format("You guessed correctly! The sum was %d!", arraySum);
		}
		else
		{
			return String.format("You guessed wrong! The sum was %d!", arraySum);
		}
	}
	/**
	 * Retrieves the sum of the numbers in the array. Used for testing, do not change.
	 * @return The value of arraySum.
	 */
	public int getArraySum()
	{
		return arraySum;
	}
}
