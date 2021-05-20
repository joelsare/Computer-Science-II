package scraper.tests;


import scraper.base.ImageEntry;
import scraper.base.WebScraper;
import scraper.utils.Document;
import scraper.utils.Elements;
import scraper.utils.ResultSet;

public class Driver
{
	public static void main (String[] args)
	{
		/*
		Document a = new Document();
		a.loadPageFromURL("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html");
		Elements ele = a.getElementsByTag("a");
		int numThings = a.getElementsByTag("a").size();
		for (int i = 0; i < numThings; i++)
		{
			System.out.println(ele.getNextElement().getAttributeValue("href"));
		}*/
		
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html", 1);
		ResultSet set = a.crawlPage();
		ImageEntry[] images = set.getAllResults();
		for (int i = 0; i < images.length; i++)
		{
			System.out.println(images[i]);
		}

	}
}
