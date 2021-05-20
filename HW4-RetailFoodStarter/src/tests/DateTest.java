package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import schedules.Date;
import schedules.InvalidDateException;

public class DateTest {

	@Test
	public void testtoString()
	{
		Date a = new Date("1/5/2019");
		assertEquals("01/05/2019", a.toString());
	}
	
	@Test
	public void testgetDay()
	{
		Date a = new Date("1/5/2019");
		assertEquals(5, a.getDay());
	}
	
	@Test
	public void testgetMonth()
	{
		Date a = new Date("1/5/2019");
		assertEquals(1, a.getMonth());
	}
	
	@Test
	public void testgetYear()
	{
		Date a = new Date("1/5/2019");
		assertEquals(2019, a.getYear());
	}
	
	@Test
	public void testCompareToEqual()
	{
		Date a = new Date("1/5/2019");
		Date b = new Date("1/5/2019");
		assertTrue(a.compareTo(b) == 0);
	}
	
	@Test
	public void testCompareToLess()
	{
		Date a = new Date("1/4/2019");
		Date b = new Date("1/5/2019");
		assertTrue(a.compareTo(b) < 0);
	}
	
	@Test
	public void testCompareToGreaterThan()
	{
		Date a = new Date("1/6/2019");
		Date b = new Date("1/5/2019");
		assertTrue(a.compareTo(b) > 0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testConstructorNull() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		Date a = new Date(null);
	}
	
	@Test
	public void testConstructorEmpty() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		Date a = new Date("");
	}
	
	@Test
	public void testConstructorMoreThanThree() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		Date a = new Date("43/23/54/123");
	}
	
	@Test
	public void testConstructorNotInts() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		Date a = new Date("4.33/2.4/1992");
	}
	
	@Test
	public void testMissingOne() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		Date a = new Date("1/22");
	}
}
