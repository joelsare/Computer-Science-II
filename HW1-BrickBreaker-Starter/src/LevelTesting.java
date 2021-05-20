

public class LevelTesting
{
	public static void main (String[] args)
	{
		String [] a = {"00*0000", "000*000", "000*000", "0000*00", "00*0000"};
		Level lev = new Level(200, 400, a);
		
		System.out.println(lev.getGameStatus());
	}
}