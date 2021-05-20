// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: <a disclosure of the resources used>
/**
 * This class encapsulates data and behaviors for a paddle within the brick breaker
 * game. Once created, a paddle can move in the x dimension, but retains a fixed y
 * coordinate. Further, all paddle objects have a fixed height of 10 pixels and a
 * fixed width of 80 pixels.
 * @author Joel Sare
 *
 */
public class Paddle
{
	/**
	 * The x position of the top-left corner of the  paddle.
	 */
	private int left;
	/**
	 * The y position of the top-left corner of the  paddle.
	 */
	private int top;
	/**
	 * Height of the paddle, which is always 10 pixels.
	 */
	private int height = 10;
	/**
	 * Width of the paddle, which is always 80 pixels.
	 */
	private final int width = 80;
	
	/**
	 * Creates a new paddle object at a specified coordinate location in the model.
	 * @param leftIn The x position of the top-left corner for the new paddle.
	 * @param topIn The y position of the top-left corner for the new paddle.
	 */
	public Paddle(int leftIn, int topIn)
	{
		left = leftIn;
		top = topIn;
	}
	
	/**
	 * Retrieves the x coordinate of the current left side of this paddle.
	 * @return The x coordinate.
	 */
	public int getLeft()
	{
		return left;
	}
	
	/**
	 * Retrieves the y coordinate of the fixed top of this paddle.
	 * @return The y coordinate.
	 */
	public int getTop()
	{
		return top;
	}
	
	/**
	 * Retrieves the fixed width of this paddle object.
	 * @return The width of this paddle in pixels.
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Retrieves the fixed height of this paddle object.
	 * @return The height of the paddle in pixels.
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Updates the state of this paddle object to correspond to a new x-position for
	 * its left side. This method has no impact on the y positioning of the paddle.
	 * @param newLeft The new x coordinate for the paddle's left side.
	 */
	public void moveTo(int newLeft)
	{
		if (newLeft < 0)
		{
			left = 0;
		}
		else
		{
			left = newLeft;
		}
	}
	
	/**
	 * This method implements a collision detection algorithm to identify whether this
	 * paddle is currently being hit by a given ball object. It will produce a return value
	 * to signal which side, if any, is currently being hit.
	 * @param theBall The ball to examine for collision with this paddle.
	 * @return A valid TouchPosition state representing where theBall is intersecting this paddle.
	 */
	public TouchPosition isTouching(Ball theBall)
	{
		TouchPosition result = TouchPosition.NONE;
		if (isTouchingTop(theBall))
		{
			result = TouchPosition.TOP;
		}
		else if (isTouchingLeft(theBall))
		{
			result = TouchPosition.LEFT;
		}
		else if (isTouchingRight(theBall))
		{
			result = TouchPosition.RIGHT;
		}
		return result;
	}
	
	/**
	 * Checks to see if the ball is touching the top of the paddle.
	 * @param theBall the ball to be checked.
	 * @return true if touching top, false otherwise.
	 */
	private boolean isTouchingTop(Ball theBall)
	{
		int paddleLeft = left;
		int paddleRight = left + width - 1;
		int paddleTop = top;
		
		int ballBottom = theBall.getY() + theBall.getRadius() - 1;
		
		return ballBottom >= paddleTop - 1 && ballBottom <= paddleTop + 5
				&& theBall.getX() >= paddleLeft && theBall.getX() <= paddleRight;
	}
	
	/**
	 * Checks if the ball is touching the left side of the paddle.
	 * @param theBall the ball to be checked.
	 * @return true if touching left side, false otherwise.
	 */
	private boolean isTouchingLeft(Ball theBall)
	{
		int paddleLeft = left;
		int paddleTop = top;
		
		int ballRight = theBall.getX() + theBall.getRadius() - 1;
		int ballBottom = theBall.getY() + theBall.getRadius() - 1;
		
		return ballRight >= paddleLeft - 1 && ballRight <= paddleLeft + 5
				&& ballBottom >= paddleTop;
	}
	
	/**
	 * Checks if the ball is touching the right side of the brick.
	 * @param theBall the ball to be checked.
	 * @return true if touching right side, false otherwise.
	 */
	private boolean isTouchingRight(Ball theBall)
	{
		int paddleRight = left + width - 1;
		int paddleTop = top;
		
		int ballLeft = theBall.getX() - theBall.getRadius() + 1;
		int ballBottom = theBall.getY() + theBall.getRadius() - 1;
		
		return ballLeft <= paddleRight + 1 && ballLeft >= paddleRight - 5
				&& ballBottom >= paddleTop;
	}
}
