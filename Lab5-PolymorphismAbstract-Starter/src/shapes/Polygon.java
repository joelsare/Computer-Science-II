// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 5 slides

package shapes;
/**
 * A more specific type of Shape. Polygons have multiple dimensions
 * that can differ in number and meaning depending on the specific polygon.
 * @author Joel Sare
 *
 */
public abstract class Polygon extends Shape
{
	/**
	 * Collection of the Polygon's dimensions.
	 */
	protected double[] dimensions;
	
	/**
	 * Constructor of Polygon, creates dimension array based upon number
	 * of dimensions of the Polygon and sets the dimensions of the Polygon.
	 * @param dimensionsIn The requested dimensions of the Polygon.
	 * @param numDimensionsIn Number of dimensions the Polygon has.
	 */
	public Polygon(double[] dimensionsIn, int numDimensionsIn)
	{
		dimensions = new double[numDimensionsIn];
		dimensions = dimensionsIn;
	}
	
	/**
	 * Sets the dimensions of the Polygon.
	 * @param dimensionsIn The requested dimensions of the Polygon.
	 */
	public abstract void setDimensions(double[] dimensionsIn);
}
