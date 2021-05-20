// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW3 Supplemental Material.

package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import scraper.base.WebScraper;
import scraper.utils.PageHistory;
import scraper.utils.ResultSet;

public class WebScraperTest
{
	public WebScraper newWS0()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html");
		return a;
	}
	
	public WebScraper newWS1()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html", 1);
		return a;
	}
	
	@Test
	public void testDefault()
	{
		WebScraper a = newWS0();
	}
	
	@Test
	public void testOverloaded()
	{
		WebScraper a = newWS1();
	}
	
	@Test
	public void testNegative()
	{
		WebScraper a = new WebScraper("h", -1);
		assertEquals(0, a.getDepth());
	}
	
	@Test
	public void testNull()
	{
		WebScraper a = new WebScraper("h", -1);
		a.setURL(null);
		assertEquals("h", a.getURL());
	}
	
	@Test
	public void testEmpty()
	{
		WebScraper a = new WebScraper("h", -1);
		a.setURL("");
		assertEquals("h", a.getURL());
	}
	
	@Test
	public void testGetHistory()
	{
		PageHistory hist = new PageHistory();
		WebScraper a = new WebScraper("h", -1);
		assertEquals(hist.getHistory().length, a.getPageHistory().getHistory().length);
	}
	
	@Test
	public void testGetImages()
	{
		WebScraper a = newWS0();
		WebScraper b = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html");
		assertEquals(a.getImages().getNumEntries(), b.getImages().getNumEntries());
	}
	
	@Test
	public void testcrawlPage()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", 1);
		assertEquals(15, a.crawlPage().getNumEntries());
	}

}
