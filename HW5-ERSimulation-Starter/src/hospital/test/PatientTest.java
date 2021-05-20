// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package hospital.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hospital.model.Patient;

public class PatientTest
{
	
	public Patient patA()
	{
		return new Patient("Sare, Joel", "Sprained ankle", 50, 2);
	}
	
	@Test
	public void testTimeArrived()
	{
		Patient a = patA();
		assertEquals(50, a.getTimeArrived());
	}
	
	@Test
	public void testgetName()
	{
		Patient a = patA();
		System.out.println(a);
		assertEquals("Sare, Joel", a.getName());
	}
	
	@Test
	public void testgetCondition()
	{
		Patient a = patA();
		assertEquals("Sprained ankle", a.getCondition());
	}
	
	@Test
	public void testgetPriority()
	{
		Patient a = patA();
		assertEquals(2, a.getPriority());
	}
	
	@Test
	public void testtoString()
	{
		Patient a = patA();
		assertEquals("Patient: Sare, Joel                Condition: Sprained ankle            Priority: 2   Waiting Since: 50", 
				a.toString());
	}
	
	@Test
	public void testcompareToDifferentTime()
	{
		Patient a = patA();
		Patient b = new Patient("Bob", "Cardiac arrest", 3, 5);
		assertTrue(0 > a.compareTo(b));
	}
	
	@Test
	public void testcompareToSameTime()
	{
		Patient a = patA();
		Patient b = new Patient("Bob", "Cardiac arrest", 50, 2);
		assertEquals(0, a.compareTo(b));
	}

}
