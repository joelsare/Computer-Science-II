package d;

public class Purebred extends Dog
{
	public Purebred(String nameIn)
	{
		super(nameIn);
	}
	
	public void speak()
	{
		System.out.println("WOOF");
	}
	
	public void getName()
	{
		System.out.println(name);
	}
	
	public void spin()
	{
		System.out.println("Purebred spin");
	}
}
