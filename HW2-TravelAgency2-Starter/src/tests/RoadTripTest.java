// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import triptypes.RoadTrip;

/**
 * Tests the RoadTrip class.
 * @author joelsare
 *
 */
public class RoadTripTest
{
	/**
	 * Tests getHotelStars with valid input.
	 */
	@Test
	public void testgetHotelStarsValid()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 3);
		assertEquals(3, a.getHotelStars());
	}
	
	/**
	 * Tests getHotelStars with invalid input.
	 */
	@Test
	public void testgetHotelStarsTooSmall()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 0);
		assertEquals(1, a.getHotelStars());
	}
	
	/**
	 * Tests getHotelStars with valid input.
	 */
	@Test
	public void testgetHotelStarsTooBig()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals(5, a.getHotelStars());
	}
	
	/**
	 * Tests getPrice method.
	 */
	@Test
	public void testgetPrice()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(4553 == a.getPrice());
	}
	
	/**
	 * Tests getDepositAmount method.
	 */
	@Test
	public void testgetDepositAmount()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(4178 == a.getDepositAmount());
	}
	
	/**
	 * Tests getAmountDue method.
	 */
	@Test
	public void testgetAmountDUe()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(0.0 == a.getAmountDue());
	}
	
	/**
	 * Tests getLodgingCost method.
	 */
	@Test
	public void testgetLodgingCost()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(3696 == a.getLodgingCost());
	}
	
	/**
	 * Tests getLodgingCost method with even number of people.
	 */
	@Test
	public void testgetLodgingCostEven()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 6, 6);
		assertTrue(3696 == a.getLodgingCost());
	}
	
	/**
	 * Tests getLodgingCost method with zero days.
	 */
	@Test
	public void testgetLodgingOneDay()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 0, stops, 3.50, 
				3000, 5, 6);
		assertTrue(0 == a.getLodgingCost());
	}
	
	/**
	 * Tests getCarCost method with two and one people.
	 */
	@Test
	public void testgetCarCostOneTwoPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 1, 6);
		assertTrue(294 == a.getCarCost());
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 2, 6);
		assertTrue(294 == b.getCarCost());
	}
	
	/**
	 * Tests getCarCost method with three and four people.
	 */
	@Test
	public void testgetCarCostThreeFourPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 3, 6);
		assertTrue(401.04 == a.getCarCost());
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 4, 6);
		assertTrue(401.04 == b.getCarCost());
	}
	
	/**
	 * Tests getCarCost method with five and six people.
	 */
	@Test
	public void testgetCarCostFiveSixPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(482 == a.getCarCost());
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 6, 6);
		assertTrue(482 == b.getCarCost());
	}
	
	/**
	 * Tests getCarCost method with seven and eight people.
	 */
	@Test
	public void testgetCarCostSevenEightPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 7, 6);
		assertTrue(564 == a.getCarCost());
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 8, 6);
		assertTrue(564 == b.getCarCost());
	}
	
	/**
	 * Tests getCarCost method with nine or more people.
	 */
	@Test
	public void testgetCarCostNinePlusPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 100, 6);
		assertTrue(1200 == a.getCarCost());
	}
	
	/**
	 * Tests getNumStops method.
	 */
	@Test
	public void testgetNumStops()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(3 == a.getNumStops());
	}
	
	/**
	 * Tests getNumStops method with empty stops array.
	 */
	@Test
	public void testgetNumStopsWithZero()
	{
		String[] stops = {};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(0 == a.getNumStops());
	}
	
	/**
	 * Tests setPersons method.
	 */
	@Test
	public void testsetPersons()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals(5, a.getNumPersons());
		a.setPersons(9);
		assertEquals(9, a.getNumPersons());
	}
	
	/**
	 * Tests getNumPersons method.
	 */
	@Test
	public void testgetNumPersons()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals(5, a.getNumPersons());
	}
	
	/**
	 * Tests setFuelPrice method.
	 */
	@Test
	public void testSetFuelPrice()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		a.setFuelPrice(4.59);
		assertTrue(4.59 == a.getFuelPrice());
	}
	
	/**
	 * Tests setFuelPrice method with negative value.
	 */
	@Test
	public void testSetFuelPriceInvalud()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		a.setFuelPrice(-4.59);
		assertTrue(2.50 == a.getFuelPrice());
	}
	
	/**
	 * Tests getFuelPrice method.
	 */
	@Test
	public void testgetFuelPrice()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(3.50 == a.getFuelPrice());
	}
	
	/**
	 * Tests getEstimatedFuelCost method with one and two people.
	 */
	@Test
	public void testgetEstimatedFuelCostOneTwoPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 1, 6);
		assertTrue(Math.abs(233.3333 - a.getEstimatedFuelCost()) < .001);
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 2, 6);
		assertTrue(Math.abs(233.3333 - b.getEstimatedFuelCost()) < .001);
	}
	
	/**
	 * Tests getEstimatedFuelCost method with three and four people.
	 */
	@Test
	public void testgetEstimatedFuelCostThreeFourPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 3, 6);
		assertTrue(Math.abs(328.125 - a.getEstimatedFuelCost()) < .001);
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 4, 6);
		assertTrue(Math.abs(328.125 - b.getEstimatedFuelCost()) < .001);
	}
	
	/**
	 * Tests getEstimatedFuelCost method with five and six people.
	 */
	@Test
	public void testgetEstimatedFuelCostFiveSixPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertTrue(375 == a.getEstimatedFuelCost());
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 6, 6);
		assertTrue(375 == b.getEstimatedFuelCost());
	}
	
	/**
	 * Tests getEstimatedFuelCost method with seven and eight people.
	 */
	@Test
	public void testgetEstimatedFuelCostSevenEightPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 7, 6);
		assertTrue(Math.abs(477.2727 - a.getEstimatedFuelCost()) < .001);
		RoadTrip b = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 8, 6);
		assertTrue(Math.abs(477.2727 - b.getEstimatedFuelCost()) < .001);
	}
	
	/**
	 * Tests getEstimatedFuelCost method with nine plus people.
	 */
	@Test
	public void testgetEstimatedFuelCostNinePlusPeople()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 100, 6);
		assertTrue(Math.abs(700 - a.getEstimatedFuelCost()) < .001);
	}
	
	/**
	 * Tests getStops method.
	 */
	@Test
	public void testgetStops()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals("Hollywood, LA, Ocean", a.getStops());
	}
	
	/**
	 * Tests toString method.
	 */
	@Test
	public void testtoString()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals("$ 4553.00  Calabasas Road Trip\n" 
				+ "           A road trip with stops at Hollywood, LA, Ocean", a.toString());
	}
	
	/**
	 * Tests getName method with valid input.
	 */
	@Test
	public void testgetNameValid()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("Calabasas Road Trip", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals("Calabasas Road Trip", a.getName());
	}
	
	/**
	 * Tests getName method with null value.
	 */
	@Test
	public void testgetNameInvalidNull()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip(null, 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals("PACKAGE NAME TBD", a.getName());
	}
	
	/**
	 * Tests getStops method with empty String value.
	 */
	@Test
	public void testgetNameInvalidEmpty()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("", 8, stops, 3.50, 
				3000, 5, 6);
		assertEquals("PACKAGE NAME TBD", a.getName());
	}
	
	/**
	 * Tests equals method, should return true.
	 */
	@Test
	public void testEqualstrue()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("California RT", 8, stops, 3.50, 
				3000, 5, 6);
		RoadTrip b = new RoadTrip("California RT", 8, stops, 2.50, 
				3032, 1, 6);
		assertTrue(a.equals(b));
	}
	
	/**
	 * Tests equals method, should return false.
	 */
	@Test
	public void testEqualsfalse()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("California RT", 8, stops, 3.50, 
				3000, 5, 6);
		RoadTrip b = new RoadTrip("Oregon RT", 8, stops, 2.50, 
				3032, 1, 6);
		assertFalse(a.equals(b));
	}
	
	/**
	 * Tests equals method, should return false.
	 */
	@Test
	public void testEqualsnull()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("California RT", 8, stops, 3.50, 
				3000, 5, 6);
		RoadTrip b = null;
		assertFalse(a.equals(b));
	}
	
	/**
	 * Tests equals method, should return false because they are different instances of objects.
	 */
	@Test
	public void testEqualsDifferentInstance()
	{
		String[] stops = {"Hollywood", "LA", "Ocean"};
		RoadTrip a = new RoadTrip("California RT", 8, stops, 3.50, 
				3000, 5, 6);
		String b = "hello";
		assertFalse(a.equals(b));
	}

}
