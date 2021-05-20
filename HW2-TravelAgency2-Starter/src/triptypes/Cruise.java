// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package triptypes;

import java.util.Calendar;

/**
 * This class represents a cruise package within the travel agency. I stores required
 * information about the cruise ship, including departure and arrival times. It allows
 * for optional off-ship excursion packages to be added to a trip for an additional price.
 * @author joelsare
 *
 */
public class Cruise extends FlightOptionalPackage
{
	/**
	 * Maximum amount of excursions allowed.
	 */
	private static final int MAX_EXCURSIONS = 10;
	/**
	 * The ship name for this Cruise.
	 */
	private String vesselName;
	/**
	 * The departure port for this Cruise.
	 */
	private String portCity;
	/**
	 * The time and data of departure from the port.
	 */
	private Calendar departs;
	/**
	 * The time and date of return to the port.
	 */
	private Calendar returns;
	/**
	 * The base price for the cheapest tier cabin (interior) on the ship. Cabin upgrades can be
	 * accommodated through a subsequent setter call.
	 */
	private double basePrice;
	/**
	 * Price of all excursions.
	 */
	private double excursionCosts;
	/**
	 * Array of Strings holding excursions.
	 */
	private String[] excursions = new String[MAX_EXCURSIONS];
	/**
	 * Current index to be used for excursions array.
	 */
	private int currentIndex = 0;
	/**
	 * Represents the cabin type.
	 */
	private CabinType cabin = CabinType.INTERIOR;
	
	/**
	 * Creates a new Cruise trip with specified values for all data except optional excursions.
	 * @param nameIn The promotional name of the travel package.
	 * @param numDaysIn The number of days for this travel package.
	 * @param vesselNameIn In The ship name for this Cruise.
	 * @param portCityIn The departure port for this Cruise.
	 * @param departsIn The time and data of departure from the port.
	 * @param returnsIn The time and date of return to the port.
	 * @param basePriceIn The base price for the cheapest tier cabin (interior) on the ship. Cabin upgrades can be
	 * accommodated through a subsequent setter call.
	 */
	public Cruise(String nameIn, int numDaysIn, String vesselNameIn, String portCityIn,
			Calendar departsIn, Calendar returnsIn, double basePriceIn)
	{
		super(nameIn, numDaysIn);
		vesselName = vesselNameIn;
		portCity = portCityIn;
		departs = departsIn;
		returns = returnsIn;
		basePrice = basePriceIn;
	}
	
	/**
	 * Adds a named excursion to this Cruise. Excursions may or may not have an additional charge associated.
	 * @param excursion The name of the excursion to add to this package. Empty excursion values are invalid and
	 * should not result in a change to the Cruise package configurations.
	 * @param price The price of the excursion. Prices must be >= 0, with any negative values being treated as
	 * equivalent to 0.
	 */
	public void addExcursion(String excursion, double price)
	{
		if (excursion != null && !excursion.equals("") && currentIndex < MAX_EXCURSIONS)
		{
			excursions[currentIndex] = excursion;
			currentIndex++;
			if (price >= 0)
			{
				excursionCosts += price;
			}
			else
			{
				excursionCosts += 0;
			}
		}
	}
	
	/**
	 * Retrieves an array containing all of the excursions which have been added to this Cruise, in the order in
	 * which they were added.
	 * @return The list of excursions.
	 */
	public String[] getExcursions()
	{
		return excursions;
	}
	
	/**
	 * Updates the cabin configuration for this Cruise. This method can be used to upgrade a cruise from the base
	 * price corresponding to the cheapest cabin (an interior cabin without any ocean view).
	 * @param cabinIn A valid alternate cabin level for this package.
	 */
	public void setCabinType(CabinType cabinIn)
	{
		cabin = cabinIn;
	}
	
	/**
	 * Retrieves the cabin level currently associated with this Cruise package.
	 * @return The current cabin level.
	 */
	public CabinType getCabinType()
	{
		return cabin;
	}
	
	/**
	 * Retrieves the home port of the cruise ship for this package.
	 * @return The city from which this Cruise departs.
	 */
	public String getHomePort()
	{
		return portCity;
	}
	
	/**
	 * Retrieves the data and time of departure for this Cruise.
	 * @return The departure time at the port.
	 */
	public Calendar getDepartureDate()
	{
		return departs;
	}
	
	/**
	 * Retrieves the data and time of arrival for this Cruise.
	 * @return The arrival time at the port.
	 */
	public Calendar getReturnDate()
	{
		return returns;
	}
	
	/**
	 * Retrieves the name of ship sailing for this Cruise.
	 * @return The ship name.
	 */
	public String getVesselName()
	{
		return vesselName;
	}
	
	/**
	 * Retrieves the total cost for all added excursions on this Cruise.
	 * @return The excursions total in US Dollars.
	 */
	public double getExcursionCosts()
	{
		return excursionCosts;
	}
	
	/**
	 * Retrieves the number of excursions which have been added to this Cruise package.
	 * @return The number of excursions.
	 */
	public int getNumExcursions()
	{
		return currentIndex;
	}
	
	/**
	 * Retrieves the full price of this Cruise package, including pre-cruise flight arrangements
	 * (as applicable), full lodging costs, and any additional excursion costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		if (hasFlights())
		{
			return getFlightCosts() + getLodgingCost() + excursionCosts;
		}
		else
		{
			return getLodgingCost() + excursionCosts;
		}
	}
	
	/**
	 * Retrieves the deposit amount required up front for this Cruise. Cruise package require that all
	 * applicable flight costs and 50% of expected lodging costs are paid at the time of booking. Optional
	 * excursion costs are not included in the deposit amount, but must be paid prior to departure. 
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
	 * Retrieves the lodging charge for this Cruise package, calculated from the base price scaled based 
	 * on the cabin level according to the following fee schedule.
	 * @return The lodging sub-total in US Dollars.
	 */
	public double getLodgingCost()
	{
		double scale = 1.0;
		final double INTERIOR_SCALE = 1.0;
		final double OCEAN_VIEW_SCALE = 1.5;
		final double BALCONY_SCALE = 3.0;
		final double SUITE_SCALE = 5.0;
		
		switch (getCabinType())
		{
			case INTERIOR:
				scale = INTERIOR_SCALE;
				break;
			case OCEAN_VIEW:
				scale = OCEAN_VIEW_SCALE;
				break;
			case BALCONY:
				scale = BALCONY_SCALE;
				break;
			case SUITE:
				scale = SUITE_SCALE;
				break;
			default:
				
		}
		return basePrice * scale;
	}
	
	/**
	 * Retrieves a formatted String summarizing this Cruise package.
	 * @return The formatted String summary.
	 */
	public String toString()
	{
		String result = super.toString();
		if (currentIndex == 0)
		{
			result += String.format("\n           Cruising from %s on the %s", 
					portCity, vesselName);
		}
		else
		{
			result += String.format("\n           Cruising from %s on the %s (includes %d excursions)", 
					portCity, vesselName, getNumExcursions());
		}
		return result;
	}
}
