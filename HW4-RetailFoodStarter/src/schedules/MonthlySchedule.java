// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package schedules;

import java.io.IOException;

import sorting.EntryDateComparator;
import sorting.EntryNameComparator;
import sorting.EntryRatingComparator;
import sorting.EntryRiskComparator;
import sorting.SortData;

/**
 * Class to create a daily schedule starting at a given date. Priority will be given
 * to the date, rating, and risk in that order.
 * @author joelsare
 *
 */
public class MonthlySchedule implements Schedule
{
	/**
	 * Maximum values allowed.
	 */
	private static final int MAX = Schedule.MAX_MONTHLY_INSPECTIONS;
	
	/**
	 * Array to hold RetailFoodEntry objects.
	 */
	private RetailFoodEntry[] entries;
	
	/**
	 * Default constructor for DailySchedule.
	 */
	public MonthlySchedule()
	{
		entries = new RetailFoodEntry[MAX];
	}
	
	/**
	 *  Method to take all RetailFoodEntries in loaded list and pull out the entries that match the given
	 *  date. Schedule will continue in sequential dates until max value of inspections are scheduled. The
	 *  schedule should include date from this date on.
	 * @param data All RetailFoodEntry objects in loaded file.
	 * @param dateIn The Date object to begin search.
	 */
	public void processData(RetailFoodEntry[] data, Date dateIn)
	{
		SortData.sort(data, (new EntryDateComparator()).thenComparing(new EntryRatingComparator()).
				thenComparing(new EntryRiskComparator()));

		int foundIndex = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i].getDate().compareTo(dateIn) >= 0)
			{
				foundIndex = i;
				break;
			}
		}
		for (int j = 0; j < MAX; j++)
		{
			entries[j] = data[foundIndex];
			foundIndex++;
		}
	}
	
	/**
	 * Method to write the schedule to a CSV file.
	 * @param fileName Name of the file to write to.
	 * @return if the writing was successful.
	 */
	public boolean writeSchedule(String fileName)
	{
		boolean isSuccessful = true;
		FileIO writer = new FileIO(fileName);
		try
		{
			writer.writeFile(entries);
		}
		catch (IOException io)
		{
			isSuccessful = false;
		}
		return isSuccessful;
	}
	
	/**
	 * Method to sort the current schedule by various fields. Fields will be "Name", "Date", "Rating" and "Risk".
	 * @param value the field parameter to sort the data by.
	 */
	public void sortBy(String value)
	{
		switch (value)
		{
			case "Name":
				SortData.sort(entries, new EntryNameComparator());
				break;
			case "Date":
				SortData.sort(entries, new EntryDateComparator());
				break;
			case "Rating":
				SortData.sort(entries, new EntryRatingComparator());
				break;
			case "Risk":
				SortData.sort(entries, new EntryRiskComparator());
				break;
			default:
				break;
		}
	}
}
