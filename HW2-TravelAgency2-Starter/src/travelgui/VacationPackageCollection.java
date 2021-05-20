// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package travelgui;

import triptypes.VacationPackage;
import triptypes.Cruise;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;
import triptypes.AllInclusiveResort;
import triptypes.RoadTrip;

/**
 * This class serves as a collection to store, filter, and explore VacationPackages within
 * the trip search user interface. Up to 25 VacationPackages can be stored in a single collection.
 * @author joelsare
 *
 */
public class VacationPackageCollection
{
	/**
	 * The maximum number of allowed VacationPackages, which is 25.
	 */
	private static final int MAX_PACKAGES = 25;
	/**
	 * Array of VacationPackage objects, max it can hold is 25.
	 */
	private VacationPackage[] list;
	/**
	 * Current index to be used for instance variable list.
	 */
	private int currentIndex;

	/**
	 * Creates a new empty VacationPackageCollection.
	 */
	public VacationPackageCollection()
	{
		list = new VacationPackage[MAX_PACKAGES];
		currentIndex = 0;
	}
	
	/**
	 * Retrieves the number of trip packages that have been added to this collection for purchase.
	 * @return The total number of available packages.
	 */
	public int getNumTrips()
	{
		return currentIndex;
	}
	
	/**
	 * Retrieves an array of all available packages from the collection. Valid packages are guaranteed
	 * to be stored contiguously in the left most array cells. Any empty cells will appear to the right
	 * of the last valid VacationPackage.
	 * @return The list of available packages.
	 */
	public VacationPackage[] getAllVacations()
	{
		if (currentIndex == 0)
		{
			VacationPackage[] empty = null;
			return empty;
		}
		else
		{
			return list;
		}
	}
	
	/**
	 * Adds a single trip package to the collection at the next available position. If adding this trip
	 * would result in more than 25 total packages, it will not be added to the collection.
	 * @param trip The trip to add to the collection.
	 */
	public void addVacation(VacationPackage trip)
	{
		if (currentIndex < MAX_PACKAGES)
		{
			list[currentIndex] = trip;
			currentIndex++;
		}
	}
	
	/**
	 * Retrieves a filtered sub-collection of trips corresponding to a specific sub-type. Should no trips
	 * of a specified type be present in this VacationPackageCollection an empty collection containing zero
	 * packages will be returned.
	 * @param selection An integer signaling what type of packages to extract. 1 represents RoadTrips, 2
	 * represents Cruises, and 3 represents AllInclusiveResort packages.
	 * @return The filtered sub-collection of packages, or an empty collection if no matching packages exist in
	 * this collection.
	 */
	public VacationPackageCollection filterVacationsFor(int selection)
	{
		VacationPackageCollection result = new VacationPackageCollection();
		if (selection == 1)
		{
			for (int i = 0; i < currentIndex; i++)
			{
				if (list[i] instanceof RoadTrip)
				{
					result.addVacation(list[i]);
				}
			}
		}
		else if (selection == 2)
		{
			for (int i = 0; i < currentIndex; i++)
			{
				if (list[i] instanceof Cruise)
				{
					result.addVacation(list[i]);
				}
			}
		}
		else if (selection == 3)
		{
			for (int i = 0; i < currentIndex; i++)
			{
				if (list[i] instanceof AllInclusiveResort)
				{
					result.addVacation(list[i]);
				}
			}
		}
		return result;
	}
	
	/**
	 * Produces a summary of flight information inside a VacationPackage for detail display elsewhere. In addition
	 * to properly extracting flight details when the given index corresponds to a FlightOptionalPackage with one or
	 * more flight legs, this method will also detect various error conditions. In erroneous situations, one of the
	 * following strings will be produced:
	 * ERROR: Index is out of range!
	 * ERROR: No flights are allowed for this type of trip!
	 * ERROR: The selected trip has no flight information.
	 * Each of these errors corresponds to invalid range input, packages for which flights cannot be added 
	 * in the first place, and packages which potentially could (but do not yet) have flight data.
	 * @param index The index position in the collection from which to extract flight information.
	 * @return The formatted flight details, with one Flight per line and each Flight displayed as detailed 
	 * in Flight.toString.
	 */
	public String getFlightDetails(int index)
	{
		String result = "";
		if (index < 0 || index >= currentIndex)
		{
			result = "ERROR: Index is out of range!";
		}
		else if (!(list[index] instanceof FlightOptionalPackage))
		{
			result = "ERROR: No flights are allowed for this type of trip!";
		}
		else if (list[index] instanceof FlightOptionalPackage)
		{
			if (((FlightOptionalPackage) list[index]).hasFlights())
			{
				Flight[] flightInfo = ((FlightOptionalPackage) list[index]).getFlightItinerary();
				int howManyFlights = ((FlightOptionalPackage) list[index]).getIndex();
				for (int i = 0; i < howManyFlights; i++)
				{
					result += flightInfo[i].toString() + "\n";
				}
			}
			else
			{
				result = "ERROR: The selected trip has no flight information.";
			}
		}
		return result;
	}
	
	/**
	 * Provides 0-based indexed access to the VacationPackageCollection.
	 * @param index The index position whose VacationPackage should be returned.
	 * @return The selected VacationPackage when index is valid. The method will return null otherwise.
	 */
	public VacationPackage getItemAt(int index)
	{
		if (index >= 0 && index < MAX_PACKAGES)
		{
			return list[index];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Produces a stable sort of the contents of this VacationPackageCollection, with the sort order determined by
	 * an externally specified criteria. When byPrice is true, the method will sort all available packages in 
	 * ascending order by total package price. When false, the method sorts packages in standard lexicographically 
	 * ascending order by package name.
	 * @param byPrice A flag which sets the sort criteria as described above.
	 */
	public void sortCollection(boolean byPrice)
	{
		if (byPrice)
		{
			for (int pass = 0; pass < currentIndex - 1; pass++)
			{
				for (int comp = 0; comp < currentIndex - 1; comp++)
				{
					if (list[comp].getPrice() > list[comp + 1].getPrice())
					{
						VacationPackage temp = list[comp];
						list[comp] = list[comp + 1];
						list[comp + 1] = temp;
					}
				}
			}
		}
		else
		{
			for (int pass = 0; pass < currentIndex - 1; pass++)
			{
				for (int comp = 0; comp < currentIndex - 1; comp++)
				{
					if (list[comp].getName().compareTo(list[comp + 1].getName()) > 0)
					{
						VacationPackage temp = list[comp];
						list[comp] = list[comp + 1];
						list[comp + 1] = temp;
					}
				}
			}
		}
	}
}
