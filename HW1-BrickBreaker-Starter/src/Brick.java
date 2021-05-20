// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: <a disclosure of the resources used>
import javafx.scene.paint.Color;

/**
 * This class is used to store state information corresponding to a single
 * brick within the brick breaker game model. It provides basic information
 * about the brick's position as well as information about the current strength
 * of a brick. All bricks in brick breaker have a height of 20 and a width of
 * 50, regardless of other state information.
 * @author Joel Sare
 *
 */
public class Brick
{
	/**
	 * The y position of the top of this brick.
	 */
	private int top;
	/**
	 * The x position of the left side of this brick.
	 */
	private int left;
	/**
	 * The initial strength of this brick. A value greater than zero represents
	 * that this brick will break after that number of hits. A value of 0 represents
	 * a "non-brick" or empty space in the model. A value of -1 represents that this 
	 * brick cannot be broken at all, regardless of the number of hits.
	 */
	private int hits;
	/**
	 * Width of the brick, which is always 50.
	 */
	private final int width = 50;
	/**
	 * Height of the brick, which is always 20.
	 */
	private final int height = 20;
	/**
	 * The color of the brick, depending on hits value.
	 */
	private javafx.scene.paint.Color brickColor;
	
	/**
	 * Creates a basic brick object at a specified position. The new brick will default
	 * with a strength of 3, meaning that it will break after 3 hits by a ball.
	 * @param topIn The y position of the top of this brick.
	 * @param leftIn The x position of the left side of this brick.
	 */
	public Brick(int topIn, int leftIn)
	{
		top = topIn;
		left = leftIn;
		hits = 3;
		brickColor = Color.GREEN;
	}
	
	/**
	 * Creates a custom brick object at a specified position with a specified strength.
	 * @param topIn The y position of the top of this brick.
	 * @param leftIn The x position of the left side of this brick.
	 * @param hitsIn The initial strength of this brick.
	 */
	public Brick(int topIn, int leftIn, int hitsIn)
	{
		top = topIn;
		left = leftIn;
		hits = hitsIn;
		if (hits == -1)
		{
			brickColor = Color.BLACK;
		}
		else if (hits == 0)
		{
			brickColor = Color.WHITE;
		}
		else if (hits == 1)
		{
			brickColor = Color.RED;
		}
		else if (hits == 2)
		{
			brickColor = Color.YELLOW;
		}
		else if (hits == 3)
		{
			brickColor = Color.GREEN;
		}
	}
	
	/**
	 * Retrieves the y coordinate of the top of this brick.
	 * @return The y coordinate of the top edge.
	 */
	public int getTop()
	{
		return top;
	}
	
	/**
	 * Retrieves the x coordinate of the left side of this brick.
	 * @return The x coordinate of the left edge.
	 */
	public int getLeft()
	{
		return left;
	}
	
	/**
	 * Retrieves the width of this brick.
	 * @return The width of the brick.
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Retrieves the height of this brick.
	 * @return The height of the brick.
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * The current color to represent this brick's breakability state.
	 * @return Black if this brick cannot be broken. White if it is broken.
	 * Green if hits is 3, yellow if hits is 2, and red if hits is 1.
	 */
	public javafx.scene.paint.Color getColor()
	{
		return brickColor;
	}
	
	/**
	 * This mutator method will update this brick's state data to account
	 * for being hit by the ball once.
	 * @return true when hit caused this brick to break completely, false otherwise.
	 */
	public boolean hit()
	{
		boolean result = false;
		if (hits == 3 || hits == 2 || hits == 1)
		{
			hits--;
			if (hits == 0)
			{
				brickColor = Color.WHITE;
				result = true;
			}
			else if (hits == 1)
			{
				brickColor = Color.RED;
			}
			else if (hits == 2)
			{
				brickColor = Color.YELLOW;
			}
		}
		return result;
	}
	
	/**
	 * This method implements a collision detection algorithm to identify whether
	 * this brick is currently being hit by a given ball object. It will produce a
	 * return value to signal which side, if any, is currently being hit.
	 * @param theBall The ball to examine for collision with this brick.
	 * @return A valid TouchPosition state representing where theBall is intersecting
	 * this brick. When no collision is detected at all or this brick is already broken,
	 * NONE should be returned. Otherwise, TOP, BOTTOM, LEFT, or RIGHT will be returned
	 * corresponding to which side of this brick is currently being hit by the ball.
	 */
	public TouchPosition isTouching(Ball theBall)
	{
		TouchPosition result = TouchPosition.NONE;
		
		if (isTouchingBottom(theBall))
		{
			result = TouchPosition.BOTTOM;
		}
		else if (isTouchingTop(theBall))
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
	 * Checks if the ball is touching the bottom of the brick.
	 * @param theBall the ball to be checked.
	 * @return true if it is touching bottom, false otherwise.
	 */
	private boolean isTouchingBottom(Ball theBall)
	{
		int brickLeft = left;
		int brickRight = left + width - 1;
		int brickBottom = top + height - 1;
		
		int ballTop = theBall.getY() - theBall.getRadius() + 1;
				
		return (hits != 0) && (ballTop <= brickBottom + 1) && (ballTop >= brickBottom - 5)
				&& (theBall.getX() >= brickLeft) && (theBall.getX() <= brickRight);
	}
	
	/**
	 * Checks to see if the ball is touching the top of the brick.
	 * @param theBall the ball to be checked.
	 * @return true if touching top, false otherwise.
	 */
	private boolean isTouchingTop(Ball theBall)
	{
		int brickLeft = left;
		int brickRight = left + width - 1;
		int brickTop = top;
		
		int ballBottom = theBall.getY() + theBall.getRadius() - 1;
		
		return (hits != 0) && (ballBottom >= brickTop - 1) && (ballBottom <= brickTop + 5)
				&& (theBall.getX() >= brickLeft) && (theBall.getX() <= brickRight);
	}
	
	/**
	 * Checks if the ball is touching the left side of the brick.
	 * @param theBall the ball to be checked.
	 * @return true if touching left side, false otherwise.
	 */
	private boolean isTouchingLeft(Ball theBall)
	{
		int brickLeft = left;
		int brickBottom = top + height - 1;
		
		int ballRight = theBall.getX() + theBall.getRadius() - 1;
		int ballTop = theBall.getY() - theBall.getRadius();
		int ballBottom = theBall.getY() + theBall.getRadius() - 1;
		
		
		return (hits != 0) && (ballRight >= brickLeft - 1) && (ballRight <= brickLeft + 5)
				&& (ballTop <= brickBottom) && (ballBottom >= top);
	}
	
	/**
	 * Checks if the ball is touching the right side of the brick.
	 * @param theBall the ball to be checked.
	 * @return true if touching right side, false otherwise.
	 */
	private boolean isTouchingRight(Ball theBall)
	{
		int brickRight = left + width - 1;
		int brickBottom = top + height - 1;
		
		int ballTop = theBall.getY() - theBall.getRadius();
		int ballLeft = theBall.getX() - theBall.getRadius() + 1;
		int ballBottom = theBall.getY() + theBall.getRadius() - 1;
		
		
		return (hits != 0) && (ballLeft <= brickRight + 1) && (ballLeft >= brickRight - 5)
				&& (ballTop <= brickBottom) && (ballBottom >= top);
	}
	
	/**
	 * Returns the number of hits a brick has.
	 * @return an integer value that shows how many hits a brick has.
	 */
	public int getHits()
	{
		return hits;
	}
	
	/**
	 * Retrieves a String representation of this brick's current object state.
	 * @return The formatted state information about this brick.
	 */
	public String toString()
	{
		return String.format("Brick at (%d, %d, %d, %d)", left, top,
				left + width - 1, top + height - 1);
	}
}