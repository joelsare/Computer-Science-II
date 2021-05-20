// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package schedules;

import java.util.Calendar;

/**
 * Date objects holds the month, day, and year of a given date. Class is Comparable so it can
 * evaluate one Date against another.
 * @author joelsare
 *
 */
public class Date implements Comparable<Date>
{	
	/**
	 * Month as int.
	 */
	private int month;
	
	/**
	 * Day as int.
	 */
	private int day;
	
	/**
	 * Year as int.
	 */
	private int year;
		
	/**
	 * Constructor.
	 * @param dateIn a mm/dd/yyy formed string representing a date.
	 */
	public Date(String dateIn)
	{
		if (dateIn == null || dateIn.equals(""))
		{
			throw new InvalidDateException(dateIn);
		}
		else
		{
			setDate(dateIn);
		}
	}
	
	/**
	 * Takes a string and stores it as a date object.
	 * @param dateIn String representing the date.
	 */
	public void setDate(String dateIn)
	{
		try
		{
			String[] ints = dateIn.split("/");
			
			if (ints.length != 3)
			{
				throw new InvalidDateException(dateIn);
			}
			
			month = Integer.parseInt(ints[0]);
			day = Integer.parseInt(ints[1]);
			year = Integer.parseInt(ints[2]);
		}
		catch (NumberFormatException nfe)
		{
			throw new InvalidDateException("Bad input");
		}
	}
	
	/**
	 * Accessor for the current month.
	 * @return the month.
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * Accessor for day.
	 * @return the day.
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * Accessor for year.
	 * @return the year.
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Returns the date as a String in mm/dd/yyyy format.
	 * @return String representation of the object.
	 */
	public String toString()
	{
		String result = null;
		
		result = String.format("%02d/%02d/%d", month, day, year);
		
		return result;
	}
	
	/**
	 * Returns the comparison of this date to the other date object.
	 * @param other Another date object to compare.
	 * @return A negative value if this date is before the other date, positive value if after,
	 * 0 if same date.
	 */
	public int compareTo(Date other)
	{
		Calendar thisOne = Calendar.getInstance();
		thisOne.clear();
		thisOne.set(year, month, day);
		
		Calendar otherOne = Calendar.getInstance();
		otherOne.clear();
		otherOne.set(other.getYear(), other.getMonth(), other.getDay());

		
		return thisOne.compareTo(otherOne);
	}
}
