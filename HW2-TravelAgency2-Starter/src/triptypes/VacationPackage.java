// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package triptypes;
/**
 * This class serves as the base class of all types of vacation packages within the travel
 * agency program.
 * @author joelsare
 *
 */
public abstract class VacationPackage
{
	/**
	 * Promotional marketing name for this package.
	 */
	private String name;
	
	/**
	 * Number of days included in this VacationPackage trip.
	 */
	private int numDays;
	
	/**
	 * Initializes a VacationPackage with provided values.
	 * @param nameIn The promotional marketing name for this package.
	 * @param numDaysIn The number of days included in this VacationPackage trip.
	 */
	public VacationPackage(String nameIn, int numDaysIn)
	{
		setName(nameIn);
		setLength(numDaysIn);
	}
	
	/**
	 * Updates the VacationPackage's name. If empty, make name "PACKAGE NAME TBD".
	 * @param nameIn The updated name to use for this package.
	 */
	public void setName(String nameIn)
	{
		if (nameIn == null || nameIn.equals(""))
		{
			name = "PACKAGE NAME TBD";
		}
		else
		{
			name = nameIn;
		}
	}
	
	/**
	 * Updates the length of this VacationPackage. All packages must have a minimum of one day.
	 * @param numDaysIn The new number of days for this package.
	 */
	public void setLength(int numDaysIn)
	{
		if (numDaysIn <= 0)
		{
			numDays = 1;
		}
		else
		{
			numDays = numDaysIn;
		}
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
	 * Gets the number of days included in this package.
	 * @return The number of days for this trip.
	 */
	public int getNumDays()
	{
		return numDays;
	}
	
	/**
	 * Provides the full price of a vacation package.
	 * @return The price of a vacation package in US Dollars.
	 */
	public abstract double getPrice();
	
	/**
	 * The required up front deposit amount for a given vacation.
	 * @return The deposit amount required in US Dollars.
	 */
	public abstract double getDepositAmount();
	
	/**
	 * Provides the remaining amount due to the travel agent for this trip less
	 * any deposit made up front.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return getPrice() - getDepositAmount();
	}
	
	/**
	 * Provides the sub-total for a trip related to lodging expenses (ie, not including 
	 * flights, meals, and incidentals). Lodging rates are determined by
	 * specific package types.
	 * @return The lodging sub-total in US Dollars.
	 */
	public abstract double getLodgingCost();
	
	/**
	 * Prefixed with the $ symbol, followed by trip total price rounded to two decimal places in
	 * a 8 character wide field. Price details should be followed by two spaces and the promotional
	 * name of this trip.
	 * @return The formatted String summary.
	 */
	@Override
	public String toString()
	{
		return String.format("$ %7.2f  %s", getPrice(), getName());
	}
	
	/**
	 * Provides equality comparison for VacationPackages and any other object type.
	 * @param other A reference to another object to be compared with this one.
	 * @return true iff this VacationPackage shares the same promotional name as one referred to by other.
	 * false when other is not a valid VacationPackage object or the names do not match.
	 */
	@Override
	public boolean equals(Object other)
	{
		boolean result = true;
		if (!(other instanceof VacationPackage))
		{
			result = false;
		}
		else if (!((VacationPackage) other).getName().equals(this.getName()))
		{
			result = false;
		}
		return result;
	}
}
