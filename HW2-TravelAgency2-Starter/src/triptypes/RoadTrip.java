// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package triptypes;

/**
 * This class represents a RoadTrip vacation that includes a rental car, overnight lodging, and
 * fuel cost estimation.
 * @author joelsare
 *
 */
public class RoadTrip extends VacationPackage
{
	/**
	 * Array representing all the stops on the road trip.
	 */
	private String[] stops;
	/**
	 * Cost of fuel per gallon.
	 */
	private double fuelCost;
	/**
	 * How many miles are driven.
	 */
	private int miles;
	/**
	 * Number of people for whom this trip package will be budgeted.
	 */
	private int maxPersons;
	/**
	 * Quality level of hotel, must be within 1-5 inclusive.
	 */
	private int hotelStars;
	
	/**
	 * Creates a newly initialized RoadTrip object using the parameter data.
	 * @param nameIn Name to use for this RoadTrip in the travel agency system.
	 * @param numDaysIn Number of days required for this RoadTrip.
	 * @param stopsIn Lost of destinations that will be visited along the way on this RoadTrip.
	 * @param fuelCostIn Estimated cost of fuel in US Dollars per gallon.
	 * @param milesIn Total number of miles for this RoadTrip.
	 * @param maxPersonsIn The number of people for whom this trip package will be budgeted.
	 * @param hotelStarsIn Quality level of the hotels.
	 */
	public RoadTrip(String nameIn, int numDaysIn, String[] stopsIn, double fuelCostIn,
			int milesIn, int maxPersonsIn, int hotelStarsIn)
	{
		super(nameIn, numDaysIn);
		stops = stopsIn;
		setFuelPrice(fuelCostIn);
		miles = milesIn;
		maxPersons = maxPersonsIn;
		setHotelStars(hotelStarsIn);
	}
	
	/**
	 * Sets the hotel stars, making sure they are within 1-5 inclusive.
	 * @param starsIn value for hotelStars
	 */
	private void setHotelStars(int starsIn)
	{
		if (starsIn > 5)
		{
			hotelStars = 5;
		}
		else if (starsIn < 1)
		{
			hotelStars = 1;
		}
		else
		{
			hotelStars = starsIn;
		}
	}
	
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		return hotelStars;
	}
	
	/**
	 * Provides the full price of this RoadTrip object. RoadTrip prices are computed
	 * based on the total rental car, lodging, and fuel estimated costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return getCarCost() + getLodgingCost() + getEstimatedFuelCost();
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object. The required deposit
	 * for a RoadTrip includes the full lodging cost plus the full rental car cost.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return getLodgingCost() + getCarCost();
	}
	
	/**
	 * All RoadTrips must be fully paid in advance, with the exception of fuel costs. Fuel costs are
	 * paid to the gas station, and not the travel agent. Thus, the balance due on RoadTrips is always 0.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return 0.0;
	}
	
	/**
	 * Provides the total lodging cost for a RoadTrip object. Lodging is computed based on the length of the
	 * vacation, the quality of the hotel (in stars), the number of rooms needed for the party and a base charge
	 * of $35.20 per room per night. Lodging costs assume a maximum 2 person occupancy per room.
	 * @return The lodging sub-total in US Dollars.
	 */
	public double getLodgingCost()
	{
		final double BASE_COST = 35.20;
		int numRooms;
		int numNights = getNumDays() - 1;	
		
		if (maxPersons % 2 == 0)
		{
			numRooms = maxPersons / 2;
		}
		else
		{
			numRooms = (maxPersons / 2) + 1;
		}
		
		return BASE_COST * getHotelStars() * numNights * numRooms;
	}
	
	/**
	 * Provides the total cost for the rental car based on the trip duration and the size of car needed. Rental 
	 * cars are billed based on full days, with no partial day rentals allowed. Further, the travel agency uses 
	 * a standard daily rental car charge based on the number of occupants riding along.
	 * @return The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		double dailyCharge;
		final double CHARGE12 = 36.75;
		final double CHARGE34 = 50.13;
		final double CHARGE56 = 60.25;
		final double CHARGE78 = 70.50;
		final double CHARGE9PLUS = 150.00;
		
		if (maxPersons == 1 || maxPersons == 2)
		{
			dailyCharge = CHARGE12;
		}
		else if (maxPersons == 3 || maxPersons == 4)
		{
			dailyCharge = CHARGE34;
		}
		else if (maxPersons == 5 || maxPersons == 6)
		{
			dailyCharge = CHARGE56;
		}
		else if (maxPersons == 7 || maxPersons == 8)
		{
			dailyCharge = CHARGE78;
		}
		else
		{
			dailyCharge = CHARGE9PLUS;
		}
		
		return dailyCharge * getNumDays();
	}
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		return stops.length;
	}
	
	/**
	 * Updates the number of people to be used for budgeting this RoadTip within the travel agency.
	 * @param maxPersonsIn The new number of people to use in calculations.
	 */
	public void setPersons(int maxPersonsIn)
	{
		maxPersons = maxPersonsIn;
	}
	
	/**
	 * Retrieves the number of people included for budget calculations by this RoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return maxPersons;
	}
	
	/**
	 * Updates the cost of fuel in US Dollars per gallon. This value is used for projecting out costs for
	 * this RoadTrip. Prices must be positive values, and a default assumption of $2.50 per gallon will
	 * be used if an invalid price is specified.
	 * @param pricePerGallon The new price to use for cost projections.
	 */
	public void setFuelPrice(double pricePerGallon)
	{
		final double DEFAULT_PRICE = 2.50;
		if (pricePerGallon <= 0)
		{
			fuelCost = DEFAULT_PRICE;
		}
		else
		{
			fuelCost = pricePerGallon;
		}
	}
	
	/**
	 * Retrieves the current fuel price used for cost projections.
	 * @return The fuel price in US Dollars per gallon.
	 */
	public double getFuelPrice()
	{
		return fuelCost;
	}
	
	/**
	 * Provides a projection of the total fuel cost for this trip based on the total number of miles to be
	 * traveled, the fuel efficiency of the rental car, and the cost of fuel. Standard rental cars used have
	 * decreasing fuel efficiency as the size gets bigger. Thus, efficiency is a function of passenger count.
	 * @return The projected fuel cost in US Dollars.
	 */
	public double getEstimatedFuelCost()
	{
		double mpg;
		final double MPG12 = 45;
		final double MPG34 = 32;
		final double MPG56 = 28;
		final double MPG78 = 22;
		final double MPG9PLUS = 15;
		
		if (maxPersons == 1 || maxPersons == 2)
		{
			mpg = MPG12;
		}
		else if (maxPersons == 3 || maxPersons == 4)
		{
			mpg = MPG34;
		}
		else if (maxPersons == 5 || maxPersons == 6)
		{
			mpg = MPG56;
		}
		else if (maxPersons == 7 || maxPersons == 8)
		{
			mpg = MPG78;
		}
		else
		{
			mpg = MPG9PLUS;
		}
		return (getMiles() * getFuelPrice()) / mpg;
	}
	
	/**
	 * Returns miles.
	 * @return Miles.
	 */
	public int getMiles()
	{
		return miles;
	}
	
	/**
	 * Retrieves the list of stops in this RoadTrip as a single String with values separated by a comma and
	 * a single space. The last stop has no punctuation after it.
	 * @return The lost of stops.
	 */
	public String getStops()
	{
		String result = "";
		for (int i = 0; i < stops.length; i++)
		{
			if (i == stops.length - 1)
			{
				result += stops[i];
			}
			else
			{
				result += stops[i];
				result += ", ";
			}
		}
		return result;
	}
	
	/**
	 * Provides a string summary of this RoadTrip.
	 * @return The formatted String summary.
	 */
	public String toString()
	{
		String result = super.toString() + "\n           A road trip with stops at ";
		for (int i = 0; i < stops.length; i++)
		{
			if (i == stops.length - 1)
			{
				result += stops[i];
			}
			else
			{
				result += stops[i];
				result += ", ";
			}
		}
		return result;
	}
}
