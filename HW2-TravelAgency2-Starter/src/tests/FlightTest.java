// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import triptypes.Flight;

/**
 * Tests the Flight object.
 * @author joelsare
 *
 */
public class FlightTest
{
	/**
	 * Tests toString method.
	 */
	@Test
	public void testtoString()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight flight = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
				
		assertEquals("AA 210 Departs: OMA at 23:59 02-20-2019; Arrives CDG at 11:30 03-02-2019",
				flight.toString());
	}
	
	/**
	 * Tests the getPrice method.
	 */
	@Test
	public void testGetPrice()
	{
		Calendar dep = Calendar.getInstance();
		dep.set(2019, 1, 20, 23, 59);
		
		Calendar arr = Calendar.getInstance();
		arr.set(2019, 2, 2, 11, 30);
		
		Flight flight = new Flight("AA", 210, "OMA", "CDG", dep, arr, 2100.20);
		
		assertTrue(2100.20 == flight.getPrice());
	}

}
