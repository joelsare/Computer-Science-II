// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 5 slides, Lab 5 JavaDoc

package shapes;

/**
 * Abstract class for the minimal requirements of a Shape.
 * @author Joel Sare
 */
public abstract class Shape
{
	/**
	 * Area of a two-dimensional shape.
	 */
	protected double area;
	
	/**
	 * Retrieves the area of the Shape.
	 * @return Area of the Shape.
	 */
	public double getArea()
	{
		setArea();
		return area;
	}
	
	/**
	 * Retrieves the number of sides of the shape.
	 * @return Sides of the shape.
	 */
	public abstract int getNumSides();
	
	/**
	 * Calculates and sets the area of the Shape.
	 */
	protected abstract void setArea();
}
