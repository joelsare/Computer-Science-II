// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 5 slides, Lab 5 JavaDoc

package shapes;

/**
 * Represents a Rectangle which inherits from the abstract Polygon class.
 * Stores a rectangle shape in terms of two dimensions, length and width.
 * @author Joel Sare
 *
 */
public class Rectangle extends Polygon
{
	/**
	 * Index location of Rectangle length in dimensions array;
	 * length is to be stored in index 0.
	 */
	private static final int  LENGTH_INDEX = 0;
	
	/**
	 * Constant value for the number of sides of a rectangle.
	 */
	private static final int RECT_SIDES = 4;
	/**
	 * Index location of Rectangle width in dimensions array;
	 * width is to be stored in index 1.
	 */
	private static final int WIDTH_INDEX = 1;
	
	/**
	 * Constructor of Rectangle, accepts array containing length and width of the Rectangle.
	 * @param dimensionsIn Input dimensions of the Rectangle.
	 */
	public Rectangle(double[] dimensionsIn)
	{
		super(dimensionsIn, 2);
	}
	
	/**
	 * Sets Rectangle's Length.
	 * @param lengthIn Length of the Rectangle.
	 */
	private void setLength(double lengthIn)
	{
		dimensions[LENGTH_INDEX] = lengthIn;
		setArea();
	}
	
	/**
	 * Sets Rectangle's Width.
	 * @param widthIn Width of the Rectangle.
	 */
	private void setWidth(double widthIn)
	{
		dimensions[WIDTH_INDEX] = widthIn;
		setArea();
	}
	
	/**
	 * Sets length and width of the Rectangle, then sets the area of the Rectangle.
	 * @param dimensionsIn Input dimensions of the Rectangle.
	 */
	@Override
	public void setDimensions(double[] dimensionsIn)
	{
		setLength(dimensionsIn[LENGTH_INDEX]);
		setWidth(dimensionsIn[WIDTH_INDEX]);
		setArea();
	}
	
	/**
	 * Retrieves the length of the Rectangle.
	 * @return Length of the Rectangle.
	 */
	public double getLength()
	{
		return super.dimensions[LENGTH_INDEX];
	}
	
	/**
	 * Retrieves the width of the Rectangle.
	 * @return Width of the Rectangle.
	 */
	public double getWidth()
	{
		return super.dimensions[WIDTH_INDEX];
	}
	
	/**
	 * Retrieves number of sides of a Rectangle.
	 * @return The number of sides of a Rectangle.
	 */
	@Override
	public int getNumSides()
	{
		return RECT_SIDES;
	}
	
	/**
	 * Returns a formatted String representation of the Rectangle,
	 * length by width formatted to two decimal places.
	 * @return String representation of the Rectangle.
	 */
	public String toString()
	{
		return String.format("This Rectangle is %.2f x %.2f", getLength(), getWidth());
	}
	
	/**
	 * Sets the area of the Rectangle based upon current dimensions.
	 */
	@Override
	protected void setArea()
	{
		super.area = dimensions[LENGTH_INDEX] * dimensions[WIDTH_INDEX];
	}
}
