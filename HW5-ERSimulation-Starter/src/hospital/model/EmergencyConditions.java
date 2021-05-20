// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package hospital.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import hospital.exceptions.InvalidConditionException;
import hospital.exceptions.InvalidPriorityException;


/**
 * This class stores and provides information about various emergency conditions recognized by the
 * hispital's ER. Conditions and their triage ratings are loaded from a configurations file at the
 * time the EmergencyConditions object is created.
 * @author joelsare
 *
 */
public class EmergencyConditions
{
	/**
	 * Holds strings containing conditions.
	 */
	private ArrayList<String> conditions = new ArrayList<String>();
	
	/**
	 * Holds integer values representing triage levels.
	 */
	private ArrayList<Integer> numbers = new ArrayList<Integer>();
	/**
	 * Creates a new EmergencyConditions object.
	 * @param fileNameIn The name of the configuration file to be read.
	 * @throws FileNotFoundException When specified file does not exist or cannot be opened for reading.
	 */
	public EmergencyConditions(String fileNameIn) throws FileNotFoundException
	{
		Scanner in = new Scanner(new FileInputStream(fileNameIn));
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			Scanner a = new Scanner(line);
			a.useDelimiter(",");
			
			String condition = a.next();
			int num = a.nextInt();

			
			conditions.add(condition);
			numbers.add(num);
			
			a.close();
		}
		in.close();
	}
	
	/**
	 * Retrieves triage compliance thresholds (in minutes) per fixed hospital policy.
	 * @param priority The priority level of interest.
	 * @return The wait threshold corresponding to the specified priority.
	 * @throws InvalidPriorityException When priority specified lies outside of 1-5 inclusive.
	 */
	public static int timeThreshold(int priority) throws InvalidPriorityException
	{
		final int CASE1 = 0;
		final int CASE2 = 10;
		final int CASE3 = 60;
		final int CASE4 = 120;
		final int CASE5 = 240;
		
		int result;
		switch (priority)
		{
			case 1:
				result = CASE1;
				break;
			case 2:
				result = CASE2;
				break;
			case 3:
				result = CASE3;
				break;
			case 4:
				result = CASE4;
				break;
			case 5:
				result = CASE5;
				break;
			default:
				throw new InvalidPriorityException();
		}
		return result;
	}
	
	/**
	 * This method looks up priority level for a specified condition. Considered in a case-sensitive manner,
	 * including spacing and punctuation.
	 * @param conditionName A String containing the condition of interest.
	 * @return 1-5 corresponding to the provided condition.
	 * @throws InvalidConditionException If a condition is specified that does not exist in the
	 * hospital's configuration file.
	 */
	public int lookup(String conditionName) throws InvalidConditionException
	{
		boolean found = false;
		int index = -1;
		for (int i = 0; i < conditions.size(); i++)
		{
			if (conditions.get(i).equals(conditionName))
			{
				index = i;
				found = true;
				break;
			}
		}
		
		if (found)
		{
			return numbers.get(index);
		}
		else
		{
			throw new InvalidConditionException(conditionName);
		}
	}
}
