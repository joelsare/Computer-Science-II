// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package hospital.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hospital.exceptions.InvalidConditionException;
import hospital.exceptions.InvalidPriorityException;
import hospital.model.EmergencyConditions;

public class EmergencyConditionsTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testLookupGoodInput() throws FileNotFoundException
	{
		EmergencyConditions cnd = new EmergencyConditions("config.txt");
		assertEquals(4, cnd.lookup("fenwofn"));
		assertEquals(1, cnd.lookup("ewfsdc"));
	}
	
	@Test
	public void testLookupBadInput() throws FileNotFoundException
	{
		thrown.expect(InvalidConditionException.class);
		EmergencyConditions cnd = new EmergencyConditions("config.txt");
		cnd.lookup("Hello");
	}
	
	@Test
	public void testtimeThresholdGoodInput()
	{
		assertEquals(0, EmergencyConditions.timeThreshold(1));
		assertEquals(10, EmergencyConditions.timeThreshold(2));
		assertEquals(60, EmergencyConditions.timeThreshold(3));
		assertEquals(120, EmergencyConditions.timeThreshold(4));
		assertEquals(240, EmergencyConditions.timeThreshold(5));
	}
	
	@Test
	public void testtimeThresholdBadInput()
	{
		thrown.expect(InvalidPriorityException.class);
		EmergencyConditions.timeThreshold(0);
	}

	


}
