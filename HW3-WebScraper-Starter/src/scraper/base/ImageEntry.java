// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW3 Supplemental Material.

package scraper.base;

/**
 * This class stores information about each image found while crawling pages. Image URLs
 * are saved along with the URL for the page on which the image appears.
 * @author joelsare
 *
 */
public class ImageEntry
{
	/**
	 * String that holds the page address.
	 */
	private String pageAddress;
	/**
	 * String that holds the image address.
	 */
	private String imgAddress;
	/**
	 * Creates a new ImageEntry storing an image URL alongside the source page URL.
	 * @param pageAddressIn The URL for the page where the image was found.
	 * @param imgAddressIn The full URL of the image itself.
	 */
	public ImageEntry(String pageAddressIn, String imgAddressIn)
	{
		pageAddress = pageAddressIn;
		imgAddress = imgAddressIn;
	}
	
	/**
	 * Retrieves the source page URL.
	 * @return The web page where the image of this ImageEntry can be found.
	 */
	public String getPageLocation()
	{
		return pageAddress;
	}
	
	/**
	 * Retrieves the direct image URL.
	 * @return The full URL of image file itself.
	 */
	public String getImgLocation()
	{
		return imgAddress;
	}
	
	/**
	 * Compares this ImageEntry to another object for equality based on the URL of the image file.
	 * Two ImageEntries with the same image URL but different page URLs will be considered equivalent.
	 * @param other Object to be tested for equality.
	 * @return true if this ImageEntry and other refer to the same image as file on the web; false otherwise.
	 */
	public boolean equals(Object other)
	{
		boolean result = false;
		if (other instanceof ImageEntry)
		{
			if (this.getImgLocation().equals(((ImageEntry) other).getImgLocation()))
			{
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Retrieves a String version of this ImageEntry. The returned string should only contain the URL for the
	 * image file.
	 * @return The image file URL from this ImageEntry.
	 */
	public String toString()
	{
		return imgAddress;
	}
}
