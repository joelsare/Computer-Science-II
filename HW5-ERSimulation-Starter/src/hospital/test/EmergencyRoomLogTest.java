package hospital.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hospital.exceptions.EmptyLogException;
import hospital.exceptions.InvalidPriorityException;
import hospital.model.EmergencyRoomLog;
import hospital.model.Patient;

public class EmergencyRoomLogTest
{
	public Patient a()
	{
		return new Patient("Joel", "Reason", 20, 2);
	}
	
	public Patient b()
	{
		return new Patient("Joel", "Reason", 10, 1);
	}
	
	public Patient c()
	{
		return new Patient("Joel", "Reason", 30, 3);
	}
	
	public Patient d()
	{
		return new Patient("Joel", "Reason", 50, 5);
	}
	
	public Patient e()
	{
		return new Patient("Joel", "Reason", 40, 4);
	}
	
	@Test
	public void testgetERClock()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		assertEquals(0, erl.getERClock());
	}
	
	@Test
	public void testgetERClockIncremented()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.incrementERClock();
		assertEquals(1, erl.getERClock());
	}
	
	@Test
	public void testTreat1Patient()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "Davey");
		assertEquals(1, erl.numPatientsSeenBy("Davey"));
	}
	
	@Test
	public void testTreat5Patients()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "Davey");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(c(), "Locker");
		erl.treatPatient(d(), "Apple");
		erl.treatPatient(e(), "Seer");
		assertEquals(1, erl.numPatientsSeenBy("Davey"));
		assertEquals(1, erl.numPatientsSeenBy("Jones"));
		assertEquals(1, erl.numPatientsSeenBy("Locker"));
		assertEquals(1, erl.numPatientsSeenBy("Apple"));
		assertEquals(1, erl.numPatientsSeenBy("Seer"));
		assertEquals(0, erl.numPatientsSeenBy("Joel"));
	}
	
	@Test
	public void testPriority()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "Davey");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(c(), "Locker");
		erl.treatPatient(d(), "Apple");
		erl.treatPatient(e(), "Seer");
		assertEquals(2, erl.numPatientsSeen(1));
		assertEquals(1, erl.numPatientsSeen(2));
		assertEquals(1, erl.numPatientsSeen(3));
		assertEquals(1, erl.numPatientsSeen(4));
		assertEquals(1, erl.numPatientsSeen(5));
		assertEquals(6, erl.numPatientsSeen(0));

	}
	
	@Test
	public void testAverage()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "Davey");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(c(), "Locker");
		erl.treatPatient(d(), "Apple");
		erl.treatPatient(e(), "Seer");
		erl.incrementERClock();
		
		double average = erl.getAverageWaitTime(1);
		assertTrue(Math.abs(10 + average) < .001);
	}
	
	@Test
	public void testnumPatientsOver()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "Davey");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(c(), "Locker");
		erl.treatPatient(d(), "Apple");
		erl.treatPatient(e(), "Seer");
		
		assertEquals(0, erl.numPatientsOverThreshold(1));
		assertEquals(0, erl.numPatientsOverThreshold(2));
		assertEquals(6, erl.numPatientsSeenBy(null));

	}
	
	@Test
	public void testaverage0()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "Davey");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(b(), "Jones");
		erl.treatPatient(c(), "Locker");
		erl.treatPatient(d(), "Apple");
		erl.treatPatient(e(), "Seer");
		erl.incrementERClock();
		
		assertTrue(Math.abs(26.66666666668 + erl.getAverageWaitTime(0)) < .001);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEmpty()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		thrown.expect(EmptyLogException.class);
		erl.numPatientsSeen(1);
	}
	
	@Test
	public void testOutOfBounds()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		thrown.expect(InvalidPriorityException.class);
		erl.numPatientsSeen(-1);
		erl.numPatientsSeen(6);
	}
	
	@Test
	public void testOutOfBoundsTooHigh()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		thrown.expect(InvalidPriorityException.class);
		erl.numPatientsSeen(6);
	}
	
	@Test
	public void emptyAverage()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		thrown.expect(EmptyLogException.class);
		erl.getAverageWaitTime(3);
	}
	
	@Test
	public void tooHighAverage()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		thrown.expect(InvalidPriorityException.class);
		erl.getAverageWaitTime(-1);
	}
	
	@Test
	public void tooLowAverage()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		thrown.expect(InvalidPriorityException.class);
		erl.getAverageWaitTime(6);
	}
	
	@Test
	public void zeroAverage()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		assertTrue(Math.abs(0.0 - erl.getAverageWaitTime(5)) < .1);
	}
	
	@Test
	public void emptyThreshold()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		thrown.expect(EmptyLogException.class);
		erl.numPatientsOverThreshold(3);
	}
	
	@Test
	public void tooHighThreshold()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		thrown.expect(InvalidPriorityException.class);
		erl.numPatientsOverThreshold(-1);
	}
	
	@Test
	public void tooThreshold()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		erl.treatPatient(a(), "M");
		thrown.expect(InvalidPriorityException.class);
		erl.numPatientsOverThreshold(6);
	}
	
	@Test
	public void threshold()
	{
		EmergencyRoomLog erl = new EmergencyRoomLog();
		for (int i = 0; i < 100; i++)
		{
			erl.incrementERClock();
		}
		erl.treatPatient(new Patient("Joel", "Reason", 10, 1), "M");
		assertEquals(1, erl.numPatientsOverThreshold(1));
	}

}
