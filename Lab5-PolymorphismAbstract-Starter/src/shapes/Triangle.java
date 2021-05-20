// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 5 slides, Lab 5 JavaDoc

package shapes;

/**
 * Represents a Triangle which inherits from the abstract Polygon class. Stores a triangle shape in terms of
 * two dimensions, base base length and height.
 * @author Joel Sare
 */
public class Triangle extends Polygon
{
	/**
	 * Constant value for the number of sides of a rectangle.
	 */
	private static final int TRI_SIDES = 3;

	/**
	 * Index location of Triangle base size in dimensions array; base size is to be stored in index 0.
	 */
	private static final int BASE_INDEX = 0;
	
	/**
	 * Index location of Triangle height in dimensions array; height is to be stored in index 1.
	 */
	private static final int HEIGHT_INDEX = 1;
	
	/**
	 * Constructor of Triangle, accepts array containing base size and height of the Triangle.
	 * @param dimensionsIn Input dimensions of the Triangle.
	 */
	public Triangle(double[] dimensionsIn)
	{
		super(dimensionsIn, 2);
	}
	
	/**
	 * Retrieves number of sides of a Triangle.
	 * @return Returns the number of sides of a Triangle.
	 */
	@Override
	public int getNumSides()
	{
		return TRI_SIDES;
	}

	/**
	 * Sets Triangle's Base.
	 * @param baseIn Base of the Triangle.
	 */
	private void setBase(double baseIn)
	{
		dimensions[BASE_INDEX] = baseIn;
		setArea();
	}
	
	/**
	 * Sets Triangle's Height.
	 * @param heightIn Height of the Triangle.
	 */
	private void setHeight(double heightIn)
	{
		dimensions[HEIGHT_INDEX] = heightIn;
		setArea();
	}
	
	/**
	 * Retrieves the base size of the Triangle.
	 * @return Base size of the Triangle.
	 */
	public double getBase()
	{
		return dimensions[BASE_INDEX];
	}
	
	/**
	 * Retrieves the height of the Triangle.
	 * @return Height of the Triangle.
	 */
	public double getHeight()
	{
		return dimensions[HEIGHT_INDEX];
	}
	
	/**
	 * Returns a formatted String representation of the Triangle, base size 
	 * by height formatted to two decimal places;
	 * see example output for format.
	 * @return String representation of the Triangle.
	 */
	@Override
	public String toString()
	{
		return String.format("This Triangle is %.2f x %.2f", getBase(), getHeight());
	}
	
	/**
	 * Sets base size and height of the Triangle, then sets the area of the Triangle.
	 * @param dimensionsIn Input dimensions of the Triangle.
	 */
	@Override
	public void setDimensions(double[] dimensionsIn)
	{
		setBase(dimensionsIn[BASE_INDEX]);
		setHeight(dimensionsIn[HEIGHT_INDEX]);
		setArea();
		
	}

	/**
	 * Sets the area of the Triangle based upon current dimensions.
	 */
	@Override
	protected void setArea()
	{
		super.area = (dimensions[BASE_INDEX] * dimensions[HEIGHT_INDEX]) / 2;
	}

}
