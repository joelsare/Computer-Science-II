// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.Cruise;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;
import triptypes.RoadTrip;
import triptypes.VacationPackage;

/**
 * Tests the VacationPackageCollection class.
 * @author joelsare
 *
 */
public class VacationPackageCollectionTest
{
	/**
	 * Creates a new VacationPackageCollection object with some values.
	 * @return A new VacationPackageCollection object.
	 */
	public VacationPackageCollection newVacationPackageCollection()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 1, 20, 23, 59);
		
		Calendar returns = Calendar.getInstance();
		returns.set(2019, 2, 2, 11, 30);
		
		Cruise ship = new Cruise("Scandinavia Cruise", 17, "Scandinavian Princess",
				"Reykjavik", departs, returns, 1500);
		
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip rt = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 3);
		
		String[] amenities = {"This", "Is", "A", "Test"};
		AllInclusiveResort air = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		
		VacationPackageCollection a = new VacationPackageCollection();
		a.addVacation(ship);
		a.addVacation(rt);
		a.addVacation(ship);
		a.addVacation(air);
		return a;
	}
	
	/**
	 * Tests the getNumTrips method with 4 trips.
	 */
	@Test
	public void testNumTrips()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		int r = vpc.getNumTrips();
		assertEquals(4, r);
		assertEquals(4, vpc.getNumTrips());
	}
	
	/**
	 * Tests the sortCollection by price method with 4 trips.
	 */
	@Test
	public void testsortCollectionPrice()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		vpc.sortCollection(true);
	}
	
	/**
	 * Tests the sortCollection by name method with 4 trips.
	 */
	@Test
	public void testsortCollectionName()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		vpc.sortCollection(false);
	}
	
	/**
	 * Tests the sortCollection by price method with 4 trips.
	 */
	@Test
	public void testgetAllVacations()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		VacationPackage[] list = vpc.getAllVacations();
		assertEquals(25, list.length);
	}
	
	/**
	 * Tests the addVacation method with more than 25 trips.
	 */
	@Test
	public void testaddVacationMAX()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		VacationPackage trip = vpc.getItemAt(0);
		for (int i = 0; i < 30; i++)
		{
			vpc.addVacation(trip);
		}
		assertEquals(25, vpc.getNumTrips());
	}
	
	/**
	 * Tests the filterVacationsFor by price method with 4 trips.
	 */
	@Test
	public void testfilterVacationsForRT()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		VacationPackageCollection roadTrips = vpc.filterVacationsFor(1);
		assertTrue(roadTrips.getItemAt(0) instanceof RoadTrip);
	}
	
	/**
	 * Tests the filterVacationsFor method with 4 trips.
	 */
	@Test
	public void testfilterVacationsForCruise()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		VacationPackageCollection cruises = vpc.filterVacationsFor(2);
		assertTrue(cruises.getItemAt(0) instanceof Cruise);
	}
	
	/**
	 * Tests the filterVacationsFor method with 4 trips.
	 */
	@Test
	public void testfilterVacationsForAIR()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		VacationPackageCollection airs = vpc.filterVacationsFor(3);
		assertTrue(airs.getItemAt(0) instanceof AllInclusiveResort);
	}
	
	/**
	 * Tests the filterVacationsFor method with 4 trips.
	 */
	@Test
	public void testfilterVacationsForInvalid()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		VacationPackageCollection nvpc = vpc.filterVacationsFor(0);
		assertEquals(0, nvpc.getNumTrips());
	}
	
	/**
	 * Tests the getFlightDetails method with 4 trips and no flights.
	 */
	@Test
	public void testgetFlightDetailsNone()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		assertEquals("ERROR: The selected trip has no flight information.", vpc.getFlightDetails(0));
	}
	
	/**
	 * Tests the getFlightDetails method with 4 trips and invalid index.
	 */
	@Test
	public void testgetFlightDetailsTooSmall()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		assertEquals("ERROR: Index is out of range!", vpc.getFlightDetails(-1));
	}
	
	/**
	 * Tests the getFlightDetails method with 4 trips and invalid index.
	 */
	@Test
	public void testgetFlightDetailsTooBig()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		assertEquals("ERROR: Index is out of range!", vpc.getFlightDetails(25));
	}
	
	/**
	 * Tests the getFlightDetails method with 4 trips, used on RT object.
	 */
	@Test
	public void testgetFlightDetailsRoadTrip()
	{
		VacationPackageCollection vpc = newVacationPackageCollection();
		assertEquals("ERROR: No flights are allowed for this type of trip!", vpc.getFlightDetails(1));
	}
	
	/**
	 * Tests the getFlightDetails method with 4 trips, 1 flight.
	 */
	@Test
	public void testgetFlightDetailsWithFlight()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight plane = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		
		VacationPackageCollection vpc = newVacationPackageCollection();
		FlightOptionalPackage fop = (FlightOptionalPackage) vpc.getItemAt(0);
		fop.addFlightLeg(plane);
		vpc.addVacation(fop);
		
		assertEquals("AA 210 Departs: OMA at 23:59 02-20-2019; Arrives CDG at 11:30 03-02-2019\n", 
				vpc.getFlightDetails(4));
	}

}
