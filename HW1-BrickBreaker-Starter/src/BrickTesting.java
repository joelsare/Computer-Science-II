

public class BrickTesting
{
	public static void main (String[] args)
	{
	Brick brick = new Brick(100, 10);

	Ball ball = new Ball(34, 128);	
	System.out.println("Should be bottom: " + brick.isTouching(ball));
	
	Ball ball2 = new Ball(25, 91);
	System.out.println("Should be top: " + brick.isTouching(ball2));
	
	Ball ball3 = new Ball(1, 111);
	System.out.println("Should be left: " + brick.isTouching(ball3));
	
	Ball ball4 = new Ball(68, 111);
	System.out.println("Should be right: " + brick.isTouching(ball4));

	Paddle paddle = new Paddle(200, 110);
	Ball ball5 = new Ball(220, 101);
	
	System.out.println("P Should be top: " + paddle.isTouching(ball5));
	
	Ball ball6 = new Ball(190, 110);
	System.out.println("P Should be left: " + paddle.isTouching(ball6));
	
	Ball ball7 = new Ball(288, 115);
	System.out.println("P Should be right: " + paddle.isTouching(ball7));	
	
	Ball ball9 = new Ball(69, 110);
	System.out.println("TRCorner: " + brick.isTouching(ball9));
	
	Ball ball8 = new Ball(69, 129);
	System.out.println("BRCorner: " + brick.isTouching(ball8));

	
		/*
		Brick b = new Brick(100, 100, 3);
		System.out.println(b.getColor());
		b.hit();
		System.out.println(b.getColor());
		b.hit();
		System.out.println(b.getColor());
		b.hit();
		System.out.println(b.getColor());
		b.hit();
		System.out.println(b.getColor());
		*/
	}
}