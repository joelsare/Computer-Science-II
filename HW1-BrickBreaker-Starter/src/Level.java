// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: <a disclosure of the resources used>

/**
 * This class models a basic game level in the brick breaker game. It allows
 * for the creation of new levels, simulation of game steps, and retrieval of
 * current state information. All levels contain a grid of 5 rows and 7 columns
 * of Bricks (some of which may have been broken), a single ball, and a single paddle.
 * @author Joel Sare
 *
 */
public class Level
{
	/**
	 * Value of width in pixels.
	 */
	private int width;
	/**
	 * Value of height in pixels.
	 */
	private int height;
	/**
	 * Array of brick objects.
	 */
	private Brick[][] bricks = new Brick[5][7];
	/**
	 * Ball object to be used in the game.
	 */
	private Ball ball;
	/**
	 * Paddle object to be used in the game.
	 */
	private Paddle paddle;
	/**
	 * Position of paddle on the y-axis.
	 */
	private final int paddleYPos = 20;
	/**
	 * Value used to shift the top coordinate 40 pixels.
	 */
	private final int shiftTop = 40;
	/**
	 * The amount of space in the y-axis between each brick.
	 */
	private final int heightPlus5 = 25;
	/**
	 * The amount of space in the x-axis between each brick.
	 */
	private final int widthPlus5 = 55;
	/**
	 * Current GameState of the game.
	 */
	private GameState gs = GameState.PLAYING;
	
	/**
	 * Creates a default level with a given dimension. The default brick configuration
	 * is a 5 row and 7 column grid of brick objects, each which requires 3 hits to break.
	 * Bricks are arranged starting 40 pixels from the top edge of the screen and 10 pixels
	 * from the left edge of the screen. Bricks should be spaced with 5 pixels between each
	 * brick in both dimensions. The ball will start in the center of the screen, and the
	 * paddle's top-left edge should be positioned at the left edge and 20 pixels up from
	 * the bottom of the screen.
	 * @param widthIn The logical width of the new level in pixels.
	 * @param heightIn The logical height of the new level in pixels.
	 */
	public Level(int widthIn, int heightIn)
	{
		width = widthIn;
		height = heightIn;
		for (int row = 0; row < bricks.length; row++)
		{
			for (int col = 0; col < bricks[row].length; col++)
			{
				int topCoordinate = shiftTop + (heightPlus5 * row);
				int leftCoordinate = 10 + (widthPlus5 * col);
				bricks[row][col] = new Brick(topCoordinate, leftCoordinate);
			}
		}
		ball = new Ball(width / 2, height / 2);
		paddle = new Paddle(0, height - paddleYPos);
	}
	
	/**
	 * Creates a level with a given dimension and specified brick configuration. The brick
	 * configuration is specified through and array of String values where each character
	 * corresponds to a single brick. This array of Strings is guaranteed to contain 5 valid
	 * Strings, each of which will have 7 characters. Characters in the string will correspond
	 * to one value in {'*', '0', '1', '2', '3'} where:
	 * '*' signifies a brick that cannot be broken
	 * '0' signifies a "ghost brick" that is already broken
	 * '1' signifies a brick that requires one hit to break
	 * '2' signifies a brick that requires two hits to break
	 * '3' signifies a brick that requires three hits to break
	 * Input strings are assumed valid and no error checking is provided.
	 * Bricks are arranged starting 40 pixels from the top edge of the screen and 10 pixels from
	 * the left edge of the screen. Bricks should be spaced with 5 pixels between each brick in
	 * both dimensions.
	 * The ball will start in the center of the screen, and the paddle's top-left edge should be
	 * positioned at the left edge and 20 pixels up from the bottom of the screen.
	 * @param widthIn The logical width of the new level in pixels.
	 * @param heightIn The logical height of the new level in pixels.
	 * @param brickConfig The configuration array specifying the grid of bricks to use in this new level.
	 */
	public Level(int widthIn, int heightIn, String[] brickConfig)
	{
		width = widthIn;
		height = heightIn;
		for (int row = 0; row < bricks.length; row++)
		{
			for (int col = 0; col < bricks[row].length; col++)
			{
				int topCoordinate = shiftTop + (heightPlus5 * row);
				int leftCoordinate = 10 + (widthPlus5 * col);
				switch (brickConfig[row].charAt(col))
				{
					case '*':
						bricks[row][col] = new Brick(topCoordinate, leftCoordinate, -1);
						break;
					case '0':
						bricks[row][col] = new Brick(topCoordinate, leftCoordinate, 0);
						break;
					case '1':
						bricks[row][col] = new Brick(topCoordinate, leftCoordinate, 1);
						break;
					case '2':
						bricks[row][col] = new Brick(topCoordinate, leftCoordinate, 2);
						break;
					case '3':
						bricks[row][col] = new Brick(topCoordinate, leftCoordinate, 3);
						break;
					default:
				}
			}
		}
		ball = new Ball(width / 2, height / 2);
		paddle = new Paddle(0, height - paddleYPos);
	}
	
	/**
	 * This method updates this level's model data based on simulating one timestep in the game.
	 * Specifically the following will occur:
	 * (1) The ball will be moved based on its last known trajectory.
	 * (2) The ball will bounce off the side walls of the screen horizontally if hitting the left or right
	 * sides, and vertically if hitting the top.
	 * (3) The ball will bounce in the appropriate direction off the paddle if they are touching.
	 * (4) The ball will bounce in the appropriate direction off any brick it is currently touching and the
	 * brick will react as required when hit by a ball.
	 * (5) The end game state (won or lost) will be updated if all possible bricks are broken or the ball hits
	 * the bottom of the screen, respectively.
	 */
	public void updateOneStep()
	{
		int ballRight = ball.getX() + ball.getRadius() - 1;
		int ballTop = ball.getY() - ball.getRadius() + 1;
		int ballLeft = ball.getX() - ball.getRadius() + 1;

		isPaddleTouching();
		if (ballRight >= width)
		{
			ball.bounceHorizontal();
		}
		else if (ballLeft <= 0)
		{
			ball.bounceHorizontal();
		}
		else if (ballTop <= 0)
		{
			ball.bounceVertical();
		}
		
		for (int r = 0; r < bricks.length; r++)
		{
			for (int c = 0; c < bricks[r].length; c++)
			{
				switch (bricks[r][c].isTouching(ball))
				{
					case TOP:
						System.out.println("top");
						ball.bounceVertical();
						bricks[r][c].hit();
						break;
					case BOTTOM:
						System.out.println("bottom");
						ball.bounceVertical();
						bricks[r][c].hit();
						break;
					case LEFT:
						System.out.println("left");
						ball.bounceHorizontal();
						bricks[r][c].hit();
						break;
					case RIGHT:
						System.out.println("right");
						ball.bounceHorizontal();
						bricks[r][c].hit();
						break;
					default:
				}
			}
		}
		updateGS();
		ball.moveOnce();
	}
	
	/**
	 * Updates the GameStatus.
	 */
	public void updateGS()
	{
		gs = GameState.PLAYING;
		boolean allBroken = true;
		
		for (int r = 0; r < bricks.length; r++)
		{
			for (int c = 0; c < bricks[r].length; c++)
			{
				if (bricks[r][c].getHits() > 0)
				{
					allBroken = false;
					break;
				}
			}
		}
		if (ball.getY() + ball.getRadius() - 1 >= height)
		{
			gs = GameState.LOST;
		}
		if (allBroken)
		{
			gs = GameState.WON;
		}
	}
	
	/**
	 * Checks to see if paddle is touching ball.
	 */
	public void isPaddleTouching()
	{
		switch (paddle.isTouching(ball))
		{
			case TOP:
				ball.bounceVertical();
				break;
			case LEFT:
				ball.bounceHorizontal();
				break;
			case RIGHT:
				ball.bounceHorizontal();
				break;
			default:
		}
	}
	
	/**
	 * Retrieves the ball object in this level.
	 * @return The ball used in the model.
	 */
	public Ball getBall()
	{
		return ball;
	}
	
	/**
	 * Retrieves the paddle object in this level.
	 * @return The paddle used in the model.
	 */
	public Paddle getPaddle()
	{
		return paddle;
	}
	
	/**
	 * Retrieves a 5 by 7 array of brick objects corresponding to the current grid of bricks in the model.
	 * @return Data for the bricks in the game level.
	 */
	public Brick[][] getBricks()
	{
		return bricks;
	}
	
	/**
	 * Retrieves state information about the game's current progress based on the last simulated step.
	 * @return The appropriate state if the user has WON or LOST the game. If neither, PLAYING will be reported.
	 */
	public GameState getGameStatus()
	{
		return gs;
	}
}