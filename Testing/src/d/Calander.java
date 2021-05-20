package d;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calander
{
	
	public static void main (String[] args)
	{
		Calendar a = Calendar.getInstance();
		a.set(2019, 1, 2, 23, 59);
//		a.set(year, month, date, hourOfDay, minute);
		
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		System.out.println(pretty.format(a.getTime()));
		
	}
}
