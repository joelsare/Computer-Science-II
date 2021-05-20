public class HourlyEmployee extends Employee
{
	private double payRate;
	private double hoursScheduled; 
	
	public HourlyEmployee(String fNameIn, String lNameIn,
			Address addressIn, double rateIn, double hoursIn)
	{
		super(fNameIn, lNameIn, addressIn); 
		
		payRate = rateIn;
		hoursScheduled = hoursIn;
	}
	
	public void updateHours(double hoursIn)
	{
		hoursScheduled = hoursIn;
	}
	
	public void updateRate(double rateIn)
	{
		payRate = rateIn;
	}
	
	@Override
	public double computePaycheck()
	{
		return payRate * hoursScheduled * 2;
	}
	
	@Override
	public String getName()
	{
		String name = super.getName();
		return "HOURLY: " + name;
	}
}
