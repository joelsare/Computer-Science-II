// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Dr. Dorn
// RESOURCES: No outside resources were used in creating this file.

/**
 * A simple abstraction for a US street address.
 * 
 * @author bdorn
 *
 */
public class Address
{
	/**
	 * The required first line of the street address.
	 */
	private String street1;
	/**
	 * Optional second line for the street address, should maintain
	 * a value of "" if no second line is specified by client code.
	 */
	private String street2;
	/**
	 * The required city for the address.
	 */
	private String city;
	/**
	 * The 2 letter US state abbreviation.
	 */
	private String state;
	/**
	 * The 5 or 9 digit zip code for this address.  If 9 digit, a 
	 * hyphen should be placed between digits 5 and 6.
	 */
	private String zip;
	
	/**
	 * Builds a new Address based on the data provided by
	 * the parameters.
	 * 
	 * @param str1In The primary street address of this Address (required)
	 * @param str2In An optional second line for the street address, if not
	 *               needed this value should be given as null.
	 * @param cityIn The city of this Address (required)
	 * @param stateIn The 2-letter state abbrevation for this Address (required)
	 * @param zipIn The 5 or 9 digit postal zip code for this address (required)
	 */
	public Address(String str1In, String str2In, String cityIn,
			String stateIn, String zipIn)
	{
		this.street1 = str1In;  // required
		if (str2In == null) //optional second line of address 
		{
			this.street2 = "";
		}
		else
		{
			this.street2 = str2In; 
		}
		this.city = cityIn;
		this.state = stateIn;
		this.zip = zipIn;
	}
	
	/**
	 * Retrieves the data for this string formatted as a standard
	 * US postal address
	 * 
	 * @return the formatted string with no trailing whitespace
	 */
	public String toString()
	{
		String result = this.street1 + "\n";
		if (!street2.equals(""))
		{
			result += this.street2 + "\n";
		}
		result += this.city + ", " + this.state + " " + this.zip;
		return result;
	}
}
