// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package triptypes;

/**
 * This class encapsulates information about travel packages that can include optional flight
 * arrangements. Trips that have this format price flight information as an additional charge
 * to a base package price captured in a concrete subclass of FlightOptionalPackage.
 * @author joelsare
 *
 */
public abstract class FlightOptionalPackage extends VacationPackage
{
	/**
	 * Represents the maximum allowed flights, which is 12.
	 */
	private static final int MAX_FLIGHTS = 12;
	
	/**
	 * Array representing the flights.
	 */
	private Flight[] flightList = new Flight[MAX_FLIGHTS];
	
	/**
	 * Represents the current index for flightList.
	 */
	private int currentIndex = 0;
	
	/**
	 * Initializes details for a newly created FlightOptionalPackage. Upon creation, this package
	 * will contain no flight bookings. However, flight legs can be added at a later point.
	 * @param name The promotional name of this package.
	 * @param numDaysIn The number of days this travel package covers.
	 */
	public FlightOptionalPackage(String name, int numDaysIn)
	{
		super(name, numDaysIn);
	}
	
	/**
	 * Adds a flight to this package.
	 * @param details A valid flight object to append to this itinerary. Invalid values (ie, null) 
	 * or flights in excess of the 12 maximum will be ignored and will not impact this FlightOptionalPackage object.
	 */
	public void addFlightLeg(Flight details)
	{
		if (currentIndex < MAX_FLIGHTS && details != null)
		{
			flightList[currentIndex] = details;
			currentIndex++;
		}
	}
	
	/**
	 * Identifies whether a concrete object in this class has at least one flight attached to it.
	 * @return true when at least one flight has been added, false otherwise.
	 */
	public boolean hasFlights()
	{
		return currentIndex > 0;
	}
	
	/**
	 * Retrieves the current itinerary for this travel package. Flights are positioned in the returned array
	 * in the order in which they were added to this FLightOptionalPackage.
	 * @return The current itinerary array of Flight objects. null when no flights have been added yet.
	 */
	public Flight[] getFlightItinerary()
	{
		if (currentIndex > 0)
		{
			return flightList;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Returns the current index.
	 * @return the current index.
	 */
	public int getIndex()
	{
		return currentIndex;
	}
	
	/**
	 * The total cost of all legs in this FlightOptionalPackage.
	 * @return The sum of all individual flight costs in this package.
	 */
	public double getFlightCosts()
	{
		double sum = 0.0;
		for (int i = 0; i < currentIndex; i++)
		{
			sum += flightList[i].getPrice();
		}
		return sum;
	}
	
	/**
	 * Retrieves a formatted String.
	 * @return The formatted string summary.
	 */
	public String toString()
	{
		String result = super.toString();
		if (hasFlights())
		{
			result += " (Flight Included)";
		}
		else
		{
			result += " (Flight Not Included)";
		}
		return result;
	}
}
