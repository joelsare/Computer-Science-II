// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package hospital.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hospital.exceptions.EmptyWaitingRoomException;
import hospital.model.Patient;
import hospital.model.WaitingRoom;

public class WaitingRoomTest
{
	@Test
	public void testadd1Patient()
	{
		WaitingRoom wr = new WaitingRoom();
		Patient a = new Patient("Joel", "Broken elbow", 45, 3);
		wr.addPatient(a);
		Patient returned = wr.getNextPatient();
		assertEquals(a.getName(), returned.getName());
	}
	
	@Test
	public void testadd3Patients()
	{
		WaitingRoom wr = new WaitingRoom();
		Patient a = new Patient("A", "Broken elbow", 45, 5);
		Patient b = new Patient("B", "Broken elbow", 45, 3);
		Patient c = new Patient("C", "Broken elbow", 45, 4);
		wr.addPatient(a);
		wr.addPatient(b);
		wr.addPatient(c);
		wr.toString();
		Patient b2 = wr.getNextPatient();
		Patient c2 = wr.getNextPatient();
		Patient a2 = wr.getNextPatient();
		assertEquals(a.getName(), a2.getName());
		assertEquals(b.getName(), b2.getName());
		assertEquals(c.getName(), c2.getName());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testemptyStuff()
	{
		WaitingRoom wr = new WaitingRoom();
		assertEquals("Waiting Room Status: EMPTY!", wr.toString());
		thrown.expect(EmptyWaitingRoomException.class);
		wr.getNextPatient();
	}
	
	@Test
	public void testgetNumWaiting()
	{
		WaitingRoom wr = new WaitingRoom();
		Patient a = new Patient("Joel", "Broken elbow", 45, 3);
		wr.addPatient(a);
		assertEquals(1, wr.getNumWaiting());
		wr.getNextPatient();
		assertEquals(0, wr.getNumWaiting());
	}
	
	@Test
	public void testOutput()
	{
		WaitingRoom wr = new WaitingRoom();
		Patient a = new Patient("A", "Broken elbow", 45, 5);
		Patient b = new Patient("B", "Broken elbow", 45, 3);
		Patient c = new Patient("C", "Broken elbow", 45, 4);
		wr.addPatient(a);
		wr.addPatient(b);
		wr.addPatient(c);
		wr.addPatient(a);
		wr.addPatient(b);
		wr.addPatient(b);
		wr.addPatient(b);
		wr.addPatient(a);
		wr.addPatient(a);
		wr.addPatient(c);
		wr.addPatient(a);
		wr.addPatient(c);
		wr.addPatient(c);
	//	System.out.println(wr.toString());
	}
	
	@Test
	public void testThis()
	{
		WaitingRoom wr = new WaitingRoom();
		wr.addPatient(new Patient("Figueroa, Francesco", "High Fever", 8, 3));
		wr.addPatient(new Patient("Noles, Oliver", "Low-grade Fever", 4, 4));
		wr.addPatient(new Patient("Levy, Thomasine", "Asthma", 5, 3));
		wr.addPatient(new Patient("Rakes, Raye", "Minor Allergic Reaction", 9, 3));
		String myString = wr.toString();
	//	System.out.println(myString);
		assertEquals(myString, "Waiting Room Status:\n" + 
				"    1) Patient: Levy, Thomasine           Condition: Asthma                    Priority: 3   Waiting Since: 5\n" + 
				"    2) Patient: Figueroa, Francesco       Condition: High Fever                Priority: 3   Waiting Since: 8\n" + 
				"    3) Patient: Rakes, Raye               Condition: Minor Allergic Reaction   Priority: 3   Waiting Since: 9\n" + 
				"    4) Patient: Noles, Oliver             Condition: Low-grade Fever           Priority: 4   Waiting Since: 4");
		wr.getNextPatient();
		wr.getNextPatient();
		wr.getNextPatient();
	//	System.out.println(wr);
		wr.getNextPatient();
	//	System.out.println(wr);
	}
	
	@Test
	public void testSupplemental()
	{
		WaitingRoom wr = new WaitingRoom();
		wr.addPatient(new Patient("Rodrigo", "Broken elbow", 45, 3));
		wr.addPatient(new Patient("Jane", "Broken elbow", 45, 1));
		wr.addPatient(new Patient("Sarah", "Broken elbow", 45, 5));
		wr.addPatient(new Patient("Javier", "Broken elbow", 45, 3));
		wr.addPatient(new Patient("Shakira", "Broken elbow", 45, 1));
		wr.addPatient(new Patient("Taylor", "Broken elbow", 45, 2));
		System.out.println(wr);
	}
	
	@Test
	public void idkanymore()
	{
		WaitingRoom wr = new WaitingRoom();
		wr.addPatient(new Patient("", "Broken elbow", 45, 3));
		System.out.println(wr);
	}
	
	
	
	
	

}
