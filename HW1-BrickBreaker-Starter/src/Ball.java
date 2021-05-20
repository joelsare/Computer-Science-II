// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: <a disclosure of the resources used>

/**
 * The Ball class encapsulates the basic data and behaviors to model the ball within the brick breaker game.
 * All Ball objects have a fixed radius of 10 pixels.
 * @author Joel Sare
 *
 */
public class Ball
{
	/**
	 * x position of the ball.
	 */
	private int x;
	/**
	 * y position of the ball.
	 */
	private int y;
	/**
	 * trajectory of ball in x direction.
	 */
	private int dx;
	/**
	 * trajectory of ball in y direction.
	 */
	private int dy;
	/**
	 * Radius of ball object, always 10 pixels.
	 */
	private final int radius = 10;
	
	/**
	 * Creates a default Ball object with an initial location of
	 * (100, 100) and an initial trajectory of 3 pixels in both x 
	 * and y dimensions.
	 */
	public Ball() 
	{
		x = 100;
		y = 100;
		dx = 3;
		dy = 3;
	}
	
	/**
	 * Creates a Ball object with a custom initial location
	 * and a default trajectory of 3 pixels in both the x and
	 * y dimensions.
	 * @param xIn The initial x position of this ball.
	 * @param yIn The initial y position of this ball.
	 */
	public Ball(int xIn, int yIn)
	{
		x = xIn;
		y = yIn;
		dx = 3;
		dy = 3;
	}
	
	/**
	 * Retrieves the current x position of this Ball's center.
	 * @return The x coordinate of the ball's center.
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Retrieves the current x position of this ball's center.
	 * @return The y coordinate of the ball's center.
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Retrieves the radius of this ball.
	 * @return The radius of this ball.
	 */
	public int getRadius()
	{
		return radius;
	}
	
	/**
	 * Causes this ball's current horizontal trajectory to reverse
	 * direction by 180 degrees. The ball's current position is unchanged.
	 */
	public void bounceHorizontal()
	{
		dx *= -1;
	}
	
	/**
	 * Causes this ball's current vertical trajectory to reverse
	 * direction by 180 degrees. The ball's current position is unchanged.
	 */
	public void bounceVertical()
	{
		dy *= -1;
	}
	
	/**
	 * This mutator method will move the position of this ball through
	 * one timestep in the game by applying the x and y trajectory
	 * offsets to compute the new center position of this ball.
	 */
	public void moveOnce()
	{
		x += dx;
		y += dy;
	}
	
	/**
	 * Retrieves a string representation of this ball.
	 * @return The formatted String containing state information about this ball.
	 */
	public String toString()
	{
		return String.format("Ball at (%d, %d) moving (%d, %d)", x, y, dx, dy);
	}
}
