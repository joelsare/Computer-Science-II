// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import triptypes.CabinType;
import triptypes.Cruise;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;

/**
 * A class testing the Cruise class.
 * @author joelsare
 *
 */
public class CruiseTest
{
	/**
	 * Creates a new Cruise object.
	 * @return A cruise object.
	 */
	public Cruise newCruise()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 1, 20, 23, 59);
		
		Calendar returns = Calendar.getInstance();
		returns.set(2019, 2, 2, 11, 30);
		
		Cruise a = new Cruise("Scandinavia Cruise", 17, "Scandinavian Princess",
				"Reykjavik", departs, returns, 1500);
		return a;
	}
	
	/**
	 * Tests the addExcursion method with valid inputs.
	 */
	@Test
	public void testaddExcursionValid()
	{
		Cruise a = newCruise();
		a.addExcursion("Bowling night", 50.0);
		a.addExcursion("Movie", 12.50);
		assertTrue(62.5 == a.getExcursionCosts());
	}
	
	/**
	 * Tests the addExcursion method with invalid inputs.
	 */
	@Test
	public void testaddExcursionNegativeValue()
	{
		Cruise a = newCruise();
		a.addExcursion("Bowling night", -50.0);
		a.addExcursion("Movie", 12.50);
		assertTrue(12.50 == a.getExcursionCosts());
	}
	
	/**
	 * Tests the addExcursion method with invalid inputs.
	 */
	@Test
	public void testaddExcursionNullString()
	{
		Cruise a = newCruise();
		a.addExcursion(null, 50.0);
		a.addExcursion("Movie", 12.50);
		assertTrue(12.50 == a.getExcursionCosts());
	}
	
	/**
	 * Tests the addExcursion method with invalid inputs.
	 */
	@Test
	public void testaddExcursionEmpty()
	{
		Cruise a = newCruise();
		a.addExcursion("", 50.0);
		a.addExcursion("Movie", 12.50);
		assertTrue(12.5 == a.getExcursionCosts());
	}
	
	/**
	 * Tests the addExcursion method with more than 10 inputs.
	 */
	@Test
	public void testaddExcursionFull()
	{
		Cruise a = newCruise();
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		assertTrue(100 == a.getExcursionCosts());
	}
	
	/**
	 * Tests the addExcursion method with more than 10 inputs.
	 */
	@Test
	public void testgetExcursions()
	{
		Cruise a = newCruise();
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		
		String[] ex = a.getExcursions();
		String result = "";
		for (int i = 0; i < ex.length; i++)
		{
			result += ex[i];
		}
		assertEquals("MovieMovieMovieMovieMovieMovieMovieMovieMovieMovie", result);
	}
	
	/**
	 * Tests the set and getCabinType methods with valid inputs.
	 */
	@Test
	public void testsetgetCabinType()
	{
		Cruise a = newCruise();
		a.setCabinType(CabinType.INTERIOR);
		assertEquals(CabinType.INTERIOR, a.getCabinType());
	}
	
	/**
	 * Tests the getHomePort method with valid inputs.
	 */
	@Test
	public void testgetHomePort()
	{
		Cruise a = newCruise();
		assertEquals("Reykjavik", a.getHomePort());
	}
	
	/**
	 * Tests the getDepartureDate method with valid inputs.
	 */
	@Test
	public void testgetDepartureDate()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);

		Cruise a = newCruise();
		assertEquals(dep, a.getDepartureDate());
	}
	
	/**
	 * Tests the getReturnDate method with valid inputs.
	 */
	@Test
	public void testgetReturnDate()
	{
		Calendar ret = Calendar.getInstance();
		ret.set(2019, 2, 2, 11, 30);

		Cruise a = newCruise();
		assertEquals(ret, a.getReturnDate());
	}
	
	/**
	 * Tests the getVesselName method with valid inputs.
	 */
	@Test
	public void testgetVesselName()
	{
		Cruise a = newCruise();
		assertEquals("Scandinavian Princess", a.getVesselName());
	}
	
	/**
	 * Tests the getNumExcursions method with no excursions.
	 */
	@Test
	public void testgetNumExcursions()
	{
		Cruise a = newCruise();
		assertEquals(0, a.getNumExcursions());
	}
	
	/**
	 * Tests the getNumExcursions method with one excursions.
	 */
	@Test
	public void testgetNumExcursionsOne()
	{
		Cruise a = newCruise();
		a.addExcursion("MOVIE", 12.50);
		assertEquals(1, a.getNumExcursions());
	}
	
	/**
	 * Tests the getNumExcursions method with more than 10 excursions.
	 */
	@Test
	public void testgetNumExcursionsMAX()
	{
		Cruise a = newCruise();
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);
		a.addExcursion("MOVIE", 12.50);

		assertEquals(10, a.getNumExcursions());
	}
	
	/**
	 * Tests the getPrice method with no flights.
	 */
	@Test
	public void testgetPriceNoFlight()
	{
		Cruise a = newCruise();
		assertTrue(1500 == a.getPrice());
	}
	
	/**
	 * Tests the getPrice method with one flight.
	 */
	@Test
	public void testgetPriceOneFlight()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight plane = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		Cruise a = newCruise();
		a.addFlightLeg(plane);
		
		assertTrue(3600.2 == a.getPrice());
	}
	
	/**
	 * Tests the getPrice method while changing the CabinType.
	 */
	@Test
	public void testgetPriceChangeCabin()
	{
		Cruise a = newCruise();
		assertTrue(1500 == a.getPrice());
		
		a.setCabinType(CabinType.OCEAN_VIEW);
		assertTrue(2250.0 == a.getPrice());
		
		a.setCabinType(CabinType.BALCONY);
		assertTrue(4500.0 == a.getPrice());
		
		a.setCabinType(CabinType.SUITE);
		assertTrue(7500 == a.getPrice());
	}
	
	/**
	 * Tests the getDeposit method with no flights.
	 */
	@Test
	public void testgetDepositNoFlight()
	{
		Cruise a = newCruise();
		assertTrue(750 == a.getDepositAmount());
	}
	
	/**
	 * Tests the getDeposit method with one flight.
	 */
	@Test
	public void testgetDepositOneFlight()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight plane = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		Cruise a = newCruise();
		a.addFlightLeg(plane);
		
		assertTrue(2850.2 == a.getDepositAmount());
	}
	
	/**
	 * Tests the toString method with flight, no excursions.
	 */
	@Test
	public void testtoStringWithFlight()
	{
		Cruise a = newCruise();
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight plane = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		a.addFlightLeg(plane);
		assertEquals("$ 3600.20  Scandinavia Cruise (Flight Included)\n" + 
				"           Cruising from Reykjavik on the Scandinavian Princess", a.toString());
	}
	
	/**
	 * Tests the toString method with no flights, two excursions.
	 */
	@Test
	public void testtoString()
	{
		Cruise a = newCruise();
		a.addExcursion("Movie", 10.00);
		a.addExcursion("Movie", 10.00);
		assertEquals("$ 1520.00  Scandinavia Cruise (Flight Not Included)\n" 
				+  "           Cruising from Reykjavik on the Scandinavian Princess "
				+ "(includes 2 excursions)", a.toString());
	}

}
