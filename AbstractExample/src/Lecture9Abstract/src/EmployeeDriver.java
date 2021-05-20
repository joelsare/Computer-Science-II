 
public class EmployeeDriver
{
	private static final int NUM_EMPLOYEES = 3;
	
	public static void main(String[] args)
	{
		//Employee e = new Employee("Jeremy", "Denver",
		//		new Address("42 Douglas Ave", null, "Omaha", "NE", "68102"));
		

		Employee[] allEmployees = new Employee[NUM_EMPLOYEES];
		
		allEmployees[0] = new HourlyEmployee("Bob", "Omaha",
			new Address("6001 Dodge St", null, "Omaha", "NE", "68182"),
			15.0,
			20.0);
		
		allEmployees[1] = new HourlyEmployee("Jill", "UNO",
				new Address("100 Pacific St", null, "Omaha", "NE", "68132"),
				10.0,
				0.0);
		
		allEmployees[2] = new HourlyEmployee("Sally", "Maverick",
				new Address("2578 144th St", null, "Omaha", "NE", "68188"),
				10.0,
				40.0);
		
		double totalPayout = 0.0;
		for (int i = 0; i < NUM_EMPLOYEES; i++)
		{
			totalPayout += allEmployees[i].computePaycheck();
		}
		
		System.out.printf("Total payout is %.2f\n", totalPayout);

	}
}
