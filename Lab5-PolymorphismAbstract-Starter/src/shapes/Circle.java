// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 5 slides, Lab 5 JavaDoc

package shapes;

/**
 * Represents a Circle which inherits from the abstract Shape class.
 * @author Joel Sare
 *
 */
public class Circle extends Shape
{
	/**
	 * Number of sides for the circle.
	 */
	private static final int CIR_SIDES = 0;
	
	/**
	 * Radius of the Circle.
	 */
	private double radius;
	
	/**
	 * Circle constructor, accepts radius of the Circle.
	 * @param radiusIn Radius of the Circle.
	 */
	public Circle(double radiusIn)
	{
		radius = radiusIn;
	}
	
	/**
	 * Sets the radius and area of the Circle.
	 * @param radiusIn Radius of the Circle.
	 */
	public void setRadius(double radiusIn)
	{
		radius = radiusIn;
		setArea();
	}
	
	/**
	 * Retrieves the radius of the Circle.
	 * @return Radius of the Circle.
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Retrieves number of sides of a Circle.
	 * @return The number of sides of a Circle.
	 */
	public int getNumSides()
	{
		return CIR_SIDES;
	}
	
	/**
	 * Returns a formatted String representation of the Circle,
	 * formatted to two decimal places.
	 * @return String representation of the Circle.
	 */
	@Override
	public String toString()
	{
		return String.format("This Circle has a radius of %.2f", radius);
	}
	
	/**
	 * Sets the area of the Circle based upon current radius.
	 */
	@Override
	protected void setArea()
	{
		super.area = Math.PI * radius * radius;
	}
}