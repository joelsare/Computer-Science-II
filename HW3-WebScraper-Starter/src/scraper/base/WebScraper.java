// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package scraper.base;

import scraper.utils.ResultSet;
import scraper.utils.Document;
import scraper.utils.Elements;
import scraper.utils.PageHistory;

/**
 * This class provides a simple mechanism to crawl a series of webpages recursively and
 * extract all of the images that are found on the pages visited.
 * @author joelsare
 *
 */
public class WebScraper
{
	/**
	 * PageHistory used to track history.
	 */
	private PageHistory history = new PageHistory();
	/**
	 * String representing the base url.
	 */
	private String url;
	/**
	 * Depth, used to determine how deep crawlPage() will go.
	 */
	private int depth;
	/**
	 * Builds a new WebScraper that should start at the provided URL and will by default explore
	 * that page at a depth of 0. This allows extracting just the detail from this page and nothing else.
	 * @param urlIn The URL to explore for images.
	 */
	public WebScraper(String urlIn)
	{
		setURL(urlIn);
		depth = 0;
	}
	
	/**
	 * Builds a new WebScraper that should start at the provided URL and will explore recursively to a
	 * specified depth.
	 * @param urlIn The URL to begin exploring for images.
	 * @param depthIn The recursive depth to explore, must be >= 0. Negative values will be treated as
	 * equivalent to 0.
	 */
	public WebScraper(String urlIn, int depthIn)
	{
		setURL(urlIn);
		setDepth(depthIn);
	}
	
	/**
	 * Updates this WebScraper to explore to a new depth.
	 * @param depthIn The recursive depth to explore, must be >= 0. Negative values will be treated as
	 * equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		if (depthIn < 0)
		{
			depth = 0;
		}
		else
		{
			depth = depthIn;
		}
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * @param urlIn The new URL to explore. The WebScraper url is only changed if the url value is valid
	 * (not null or empty).
	 */
	public void setURL(String urlIn)
	{
		if (urlIn != null && !urlIn.equals(""))
		{
			url = urlIn;
		}
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * @return The base url.
	 */
	public String getURL()
	{
		return url;
	}
	
	/**
	 * Retrieves the set of images found directly at the initial base URL for this WebScraper. This method will
	 * not explore any links found at the base page. Image information should be stored in the order in which their
	 * corresponding <img> tags appear in the source HTML code. If an image appears more than once in a page, only
	 * one entry should appear in the ResultSet.
	 * @return A collection of ImageEntry objects for the images found at the base url location.
	 */
	public scraper.utils.ResultSet getImages()
	{
		return getImagesHelper(url);
	}
	
	/**
	 * Finds the images from a specific URL.
	 * @param theURL The specific URL to find images on.
	 * @return A ResultSet with all images from this URL.
	 */
	public scraper.utils.ResultSet getImagesHelper(String theURL)
	{
		history.markVisited(theURL);

		ResultSet set = new ResultSet();
		
		Document a = new Document();
		a.loadPageFromURL(theURL);
		
		int numImgs = a.getElementsByTag("img").size();
		Elements pics = a.getElementsByTag("img");
		
		for (int i = 0; i < numImgs; i++)
		{
			String imgURL = pics.getNextElement().getAttributeValue("src");
			if (!set.contains(imgURL))
			{
				ImageEntry img = new ImageEntry(url, imgURL);
				set.addResult(img);
			}
		}
		return set;
	}
	
	/**
	 * This method will recursively explore pages starting at the base url defined for this WebScraper to the depth
	 * for which the scraper is configured.
	 * The ResultSet will contain all images discovered along the way, with images from a page being explored stored
	 * in the ResultSet prior to any images found on linked pages. ImageEntries will always appear in the ResultSet
	 * in the order in which the corresponding <img> tags are given in the HTML files. Only the first occurrence of
	 * a particular image (by absolute URL) is stored in the ResultSet.
	 * Links on a page will be explored in the sequential order in which their corresponding < a > tags appear in 
	 * the HTML file. The same URL should never be crawled more then once, even if it is linked from itself or 
	 * another later page.
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	public scraper.utils.ResultSet crawlPage()
	{
		Document doc = new Document();
		doc.loadPageFromURL(url);
		Elements urls = doc.getElementsByTag("a");
		ResultSet set = getImages();
		
		return crawlPageHelper(depth, urls, doc, set);
	}
	
	/**
	 * Helper method for crawlPage.
	 * @param webdepth Current depth to explore webpages.
	 * @param urls Elements objects that holds urls.
	 * @param doc Document that is used to modify urls.
	 * @param set Set of images to be returned.
	 * @return Set of images.
	 */
	public scraper.utils.ResultSet crawlPageHelper(int webdepth, Elements urls, Document doc, ResultSet set)
	{
		ResultSet combined = set;
		if (webdepth > 0)
		{
			boolean found = false;
			int numURLs = urls.size();
			for (int i = 0; i < numURLs; i++)
			{
				String nextURL = urls.getNextElement().getAttributeValue("href");
				if (!history.visited(nextURL))
				{
					ResultSet newSet = getImagesHelper(nextURL);
					combined = combined.merge(newSet);
					if (!found)
					{
						doc.loadPageFromHTML(nextURL);
						found = true;
					}
				}
			}
			Elements newurls = doc.getElementsByTag("a");
			return crawlPageHelper(webdepth - 1, newurls, doc, combined);
		}
		else
		{
			return set;
		}
	}
	
	/**
	 * Retrieves the historical trail of pages visited during the last top-level call to crawlPage.
	 * @return The most recent collection of pages visited. If the crawPage method has not been previously called,
	 * the PageHistory object will be empty.
	 */
	public scraper.utils.PageHistory getPageHistory()
	{
		return history;
	}
}
