package d;

public class Beagle extends Purebred
{
	public Beagle(String nameIn)
	{
		super(nameIn);
	}
	public void speak()
	{
		System.out.println("BOW WOW");
	}
	
	public void spin()
	{
		System.out.println("I SPIN");
	}
	
	public void getName()
	{
		System.out.println(name);
	}
	
	void hello()
	{
		System.out.println("Hello");
	}
}
