
public class EmployeeDriver
{
	public static void main(String[] args)
	{
		HourlyEmployee bob = new HourlyEmployee("Bob", "Omaha",
			new Address("6001 Dodge St", null, "Omaha", "NE", "68182"),
			15.0,
			20.0);
				
		Employee katrina = new Employee("Katrina", "Turing",
			new Address("85 5th St NW", null, "Atlanta", "GA", "30332"));
		
		System.out.println(bob.getName());
		System.out.println(bob.getCheckAddress());
		bob.updateRate(20.0);
		System.out.println(bob.computePaycheck());
		
		System.out.println("--------");
		System.out.println(bob.toString());
		System.out.println(bob);
		
		//System.out.println(katrina.getName());
		//System.out.println(katrina.getCheckAddress());
		//System.out.println(katrina.computePaycheck());
		//katrina.updateRate(20.0);

		
	}
}
