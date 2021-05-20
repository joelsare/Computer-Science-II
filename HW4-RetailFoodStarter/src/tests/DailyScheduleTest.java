// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import schedules.Date;
import schedules.FileIO;
import schedules.DailySchedule;
import schedules.RetailFoodEntry;

public class DailyScheduleTest
{

	@Test
	public void date() throws FileNotFoundException
	{
		DailySchedule a = new DailySchedule();
		FileIO writer = new FileIO("Rating_List.csv");
		RetailFoodEntry[] ent = writer.readFile();
		
		Date dat = new Date("01/01/2017");
		a.processData(ent, dat);
		a.writeSchedule("my_schedule.csv");
		a.sortBy("Date");
	}
	
	@Test
	public void name() throws FileNotFoundException
	{
		DailySchedule a = new DailySchedule();
		FileIO writer = new FileIO("Rating_List.csv");
		RetailFoodEntry[] ent = writer.readFile();
		
		Date dat = new Date("01/01/2017");
		a.processData(ent, dat);
		a.writeSchedule("my_schedule.csv");
		a.sortBy("Name");
	}
	
	@Test
	public void rating() throws FileNotFoundException
	{
		DailySchedule a = new DailySchedule();
		FileIO writer = new FileIO("Rating_List.csv");
		RetailFoodEntry[] ent = writer.readFile();
		
		Date dat = new Date("01/01/2017");
		a.processData(ent, dat);
		a.writeSchedule("my_schedule.csv");
		a.sortBy("Rating");
	}
	
	@Test
	public void risk() throws FileNotFoundException
	{
		DailySchedule a = new DailySchedule();
		FileIO writer = new FileIO("Rating_List.csv");
		RetailFoodEntry[] ent = writer.readFile();
		
		Date dat = new Date("01/01/2017");
		a.processData(ent, dat);
		a.writeSchedule("my_schedule.csv");
		a.sortBy("Risk");
	}

}
