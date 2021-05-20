// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import triptypes.AllInclusiveResort;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;

/**
 * Tests the AllInclusiveResort class.
 * @author joelsare
 *
 */
public class AllInclusiveResortTest
{
	/**
	 * Tests the getAmountDue method.
	 */
	@Test
	public void testgetAmountDue()
	{
		String[] amenities = {"This", "Is", "A", "Test"};
		FlightOptionalPackage a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		assertTrue(750 == a.getAmountDue());
	}
	
	/**
	 * Tests the getAmenities method.
	 */
	@Test
	public void testgetAmenities()
	{
		String[] amenities = {"This", "Is", "A", "Test"};
		AllInclusiveResort a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		assertTrue("This, Is, A, Test".equals(a.getAmenities()));
	}
	
	/**
	 * Tests the getGuestsPerRoom method.
	 */
	@Test
	public void testgetGuestsPerRoom()
	{
		String[] amenities = {"This", "Is", "A", "Test"};
		AllInclusiveResort a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		assertEquals(2, a.getGuestsPerRoom());
	}
	
	/**
	 * Tests the getPrice method with no flights.
	 */
	@Test
	public void testgetPriceNoFlights()
	{
		String[] amenities = {"This", "Is", "A", "Test"};
		AllInclusiveResort a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		assertTrue(1500 == a.getPrice());
	}
	
	/**
	 * Tests the getPrice method with a flight.
	 */
	@Test
	public void testgetPriceWithFlights()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight plane = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		String[] amenities = {"This", "Is", "A", "Test"};
		FlightOptionalPackage a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		a.addFlightLeg(plane);
		assertTrue(3600.2 == a.getPrice());
	}
	
	/**
	 * Tests the getDepositAmount method with no flights.
	 */
	@Test
	public void testgetDepositAmountNoFlights()
	{
		String[] amenities = {"This", "Is", "A", "Test"};
		AllInclusiveResort a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		assertTrue(750 == a.getDepositAmount());
	}
	
	/**
	 * Tests the getDepositAmount method with a flight.
	 */
	@Test
	public void testgetDepositAmountWithFlight()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight plane = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		String[] amenities = {"This", "Is", "A", "Test"};
		FlightOptionalPackage a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		a.addFlightLeg(plane);
		assertTrue(2850.2 == a.getDepositAmount());
	}
	
	/**
	 * Tests the toString method.
	 */
	@Test
	public void testtoString()
	{
		String[] amenities = {"This", "Is", "A", "Test"};
		AllInclusiveResort a = new AllInclusiveResort("Vacation to Bahamas", 7, "Bahama Resort",
				2, 250.00, amenities);
		assertEquals("$ 1500.00  Vacation to Bahamas (Flight Not Included)\n" + 
				"           An all-inclusive stay at Bahama Resort for 2 people!", a.toString());
	}
	

}
