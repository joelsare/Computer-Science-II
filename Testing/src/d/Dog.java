package d;

public abstract class Dog
{
	protected String name;
	
	public Dog(String nameIn)
	{
		name = nameIn;
	}
	
	public void getName()
	{
		System.out.println("Dog");
	}
	
	public void speak()
	{
		System.out.println("?");
	}
	
	public abstract void spin();
	
	public void rawr()
	{
		System.out.println("ROAR");
	}
}
