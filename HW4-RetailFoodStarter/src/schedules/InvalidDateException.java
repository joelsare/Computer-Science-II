package schedules;
/**
 * An Exception to be thrown if an entry does not have a valid date.
 */
public class InvalidDateException extends RuntimeException 
{
	/**
	 * Sets the message of the Exception to "Invalid Date".
	 * @param input The invalid date value causing the exception.
	 */
	public InvalidDateException(String input)
	{
		super("Invalid Date: " + input);
	}
}
