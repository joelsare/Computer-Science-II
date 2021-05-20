// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW3 Supplemental Material.

package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import scraper.base.ImageEntry;

public class ImageEntryTest
{
	public ImageEntry newIE()
	{
		ImageEntry a = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html",
			"http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/brodieBolt.jpg");
		return a;
	}
	
	@Test
	public void testgetPageLocation()
	{
		ImageEntry a = newIE();
		assertEquals("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html",a.getPageLocation());
	}
	
	@Test
	public void testgetImgLocation()
	{
		ImageEntry a = newIE();
		assertEquals("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/brodieBolt.jpg",a.getImgLocation());
	}
	
	@Test
	public void testEqualsEQUAL()
	{
		ImageEntry a = newIE();
		ImageEntry b = newIE();
		assertTrue(a.equals(b));
	}
	
	@Test
	public void testEqualsDiffImgAddress()
	{
		ImageEntry a = newIE();
		ImageEntry b = new ImageEntry("Hello", "there");
		assertFalse(a.equals(b));
	}
	
	@Test
	public void testEqualsNULL()
	{
		ImageEntry a = newIE();
		ImageEntry b = null;
		assertFalse(a.equals(b));
	}
	
	@Test
	public void testEqualsDiffObj()
	{
		ImageEntry a = newIE();
		String b = "Hello";
		assertFalse(a.equals(b));
	}
	
	@Test
	public void testtoString()
	{
		ImageEntry a = newIE();
		assertEquals("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/brodieBolt.jpg", a.toString());
	}
}
