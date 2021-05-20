// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package triptypes;

/**
 * This class encapsulates details related to an all-inclusive resort vacation package.
 * Flight information to/from the resort location can be added an additional price. Once
 * at the resort, all-inclusive packages are bulled using a flat fee, regardless of the
 * number of included amenities.
 * @author joelsare
 *
 */
public class AllInclusiveResort extends FlightOptionalPackage
{
	/**
	 * The name of the resort.
	 */
	private String resort;
	/**
	 * The number of guests allowed per room at the included price.
	 */
	private int guestsPerRoom;
	/**
	 * The price of the stay per night.
	 */
	private double pricePerNight;
	/**
	 * A lost of amenities available for free at the resort.
	 */
	private String[] amenitiesList;
	/**
	 * Creates a new AllInclusiveResort package.
	 * @param nameIn The promotional name for this package.
	 * @param numDaysIn The number of days included in this vacation package.
	 * @param resortIn The name of the resort.
	 * @param guestsPerRoomIn The number of guests allowed per room at the included price.
	 * @param pricePerNightIn The price of the stay per night.
	 * @param amenitiesListIn A list of amenities available for free at the resort.
	 */
	public AllInclusiveResort(String nameIn, int numDaysIn, String resortIn, int guestsPerRoomIn,
			double pricePerNightIn, String[] amenitiesListIn)
	{
		super(nameIn, numDaysIn);
		resort = resortIn;
		guestsPerRoom = guestsPerRoomIn;
		pricePerNight = pricePerNightIn;
		amenitiesList = amenitiesListIn;
	}
	
	/**
	 * Retrieves a String containing all of the available amenities at the resort. Individual amenities
	 * should be separated by a single comma and space character, with no such separator at the end of the String.
	 * @return The amenities list.
	 */
	public String getAmenities()
	{
		String result = "";
		for (int i = 0; i < amenitiesList.length; i++)
		{
			if (i == amenitiesList.length - 1)
			{
				result += amenitiesList[i];
			}
			else
			{
				result += amenitiesList[i];
				result += ", ";
			}
		}
		return result;
	}
	
	/**
	 * Retrieves the number of guests allowed per room at the specified rate.
	 * @return The number of guests per room.
	 */
	public int getGuestsPerRoom()
	{
		return guestsPerRoom;
	}
	
	/**
	 * The full price for this all-inclusive package, including any optional flight pricing.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		if (hasFlights())
		{
			return getFlightCosts() + getLodgingCost();
		}
		else
		{
			return getLodgingCost();
		}
	}
	
	/**
	 * The required deposit amount to be made at the time of booking. All up front flight-related costs
	 * and 50% of the total lodging costs for this trip must be paid as a deposit.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		if (hasFlights())
		{
			return getFlightCosts() + (getLodgingCost() / 2.0);
		}
		else
		{
			return getLodgingCost() / 2.0;
		}
	}
	
	/**
	 * A formatted summary String with details about this all-inclusive resort package. The String will contain 
	 * information as described by FlightOptionalPackage followed by details about the resort and the number of 
	 * people included at the specified price. The second line should be prefixed with 11 blank spaces for 
	 * alignment below the trip name.
	 * @return The formatted String summary.
	 */
	public String toString()
	{
		String result = super.toString();
		result += String.format("\n           An all-inclusive stay at %s for %d people!", 
				resort, guestsPerRoom);
		return result;
	}
	
	/**
	 * Retrieves the sub-total for lodging associated with this all inclusive resort stay based on the 
	 * number of nights in the package and the base price.
	 * @return The lodging sub-total in US Dollars.
	 */
	public double getLodgingCost()
	{
		int numNights = getNumDays() - 1;
		return pricePerNight * numNights;
	}
}
