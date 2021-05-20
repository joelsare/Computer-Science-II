// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package schedules;

/**
 * Class to hold an entry of a retail food rating.
 * @author joelsare
 *
 */
public class RetailFoodEntry implements Comparable<RetailFoodEntry>
{
	/**
	 * String that holds the name.
	 */
	private String name;
	
	/**
	 * String that holds the address.
	 */
	private String address;
	
	/**
	 * String that holds the rating.
	 */
	private Rating rating;
	
	/**
	 * String that holds the date.
	 */
	private Date date;
	
	/**
	 * String that holds the risk.
	 */
	private Risk risk;
	
	/**
	 * Constructor that takes all elements of the RetailFoodEntry.
	 * @param nameIn Name of the food establishment.
	 * @param addressIn Address of the entry.
	 * @param ratingIn Rating of the entry.
	 * @param dateIn Date of last inspection.
	 * @param riskIn Risk level of the entry.
	 * @throws IllegalArgumentException if provided ratingIn or riskIn values do not 
	 * correspond to one of the acceptable values.
	 * @throws InvalidDateException if the provided dateIn is invalid.
	 */
	public RetailFoodEntry(String nameIn, String addressIn, String ratingIn,
			String dateIn, String riskIn) throws IllegalArgumentException, InvalidDateException
	{
		name = nameIn;
		address = addressIn;
		rating = Rating.valueOf(ratingIn);
		date = new Date(dateIn);
		risk = Risk.valueOf(riskIn);
	}
	
	/**
	 * Returns the name.
	 * @return The name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the address.
	 * @return The address.
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Returns the date.
	 * @return the date.
	 */
	public Date getDate()
	{
		return date;
	}
	
	/**
	 * Returns the rating.
	 * @return the rating.
	 */
	public Rating getRating()
	{
		return rating;
	}
	
	/**
	 * Returns the risk.
	 * @return the risk.
	 */
	public Risk getRisk()
	{
		return risk;
	}
	
	/**
	 * Compares two RetailFoodEntry objects based on their names.
	 * @param other The other RetailFoodEntry object.
	 * @return -1 if this is ahead of the other in the alphabet, 1 if after, 0 if equal.
	 */
	public int compareTo(RetailFoodEntry other)
	{
		return this.name.compareTo(other.getName());
	}
	
	/**
	 * Returns the String version of a retail food entry with comma separation of fields.
	 * @return String version of name, address, rating, date,risk
	 * for storage in a CSV or display.
	 */
	public String toString()
	{
		return String.format("%s,%s,%s,%s,%s", name, address, rating, date, risk);
	}
}
