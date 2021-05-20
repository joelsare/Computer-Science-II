package d;

public class DogDriver {

	public static void main(String[] args)
	{
		Beagle d = new Beagle("Scott");
		((Beagle)d).speak();
		d.spin();
		d.getName();
		d.rawr();
		d.hello();
	}

}
