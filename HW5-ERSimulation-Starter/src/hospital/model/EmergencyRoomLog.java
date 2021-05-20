// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW5 Supplemental Material.

package hospital.model;

import java.io.Serializable;
import java.util.ArrayList;

import hospital.exceptions.EmptyLogException;
import hospital.exceptions.InvalidPriorityException;

/**
 * This class stores log information about Patients served by the ER doctors. The log maintains
 * state information about the current time in the hospital and records timestamped patient activity.
 * This class also provides methods to compute performance data about the ER's wait times and overall
 * compliance with hospital-policy thresholds.
 * @author joelsare
 *
 */
public class EmergencyRoomLog implements Serializable
{
	/**
	 * ER clock.
	 */
	private int clock;
	
	/**
	 * ArrayList that holds patient objects.
	 */
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	
	/**
	 * ArrayList that holds String objects representing physician names.
	 */
	private ArrayList<String> doctors = new ArrayList<String>();
	
	/**
	 * ArrayList that holds Integer objects that represent current times patients were treated.
	 */
	private ArrayList<Integer> time = new ArrayList<Integer>();
	
	/**
	 * Creates and empty ER Log. The log will initialize the ER clock to 0.
	 */
	public EmergencyRoomLog()
	{
		clock = 0;
	}
	
	/**
	 * Retrieves the current ER clock time, in minutes.
	 * @return The current time in the ER.
	 */
	public int getERClock()
	{
		return clock;
	}
	
	/**
	 * Increments the ER clock by one minute.
	 */
	public void incrementERClock()
	{
		clock++;
	}
	
	/**
	 * Enters a Patient into the EmergencyRoomLog when they have left the WaitingRoom. This
	 * method records the patient seen, the doctor that saw them, and internally records the
	 * time when this patient was seen based on the current ER clock time.
	 * @param thePatient The Patient being seen by the physician.
	 * @param seenBy The name of the physician treating the Patient in "Last, First" format.
	 */
	public void treatPatient(Patient thePatient, String seenBy)
	{
		patients.add(thePatient);
		doctors.add(seenBy);
		time.add(getERClock());
	}
	
	/**
	 * Retrieves the number of patients seen by a given physician since this EmergencyRoomLog was created.
	 * @param treatingPhysician The name of the doctor of interest in "Last, First" format.
	 * @return The total number of patients seen so far by the treatingPhysician in the log. Physicians are
	 * identified in a case sensitive manner.
	 * When null is specified as the treatingPhysician, the total number of patients seen by all doctors will
	 * be returned.
	 */
	public int numPatientsSeenBy(String treatingPhysician)
	{
		int sum = 0;
		if (treatingPhysician == null)
		{
			sum = patients.size();
		}
		else
		{
			for (int i = 0; i < doctors.size(); i++)
			{
				if (doctors.get(i).equals(treatingPhysician))
				{
					sum++;
				}
			}
		}
		return sum;
	}
	
	/**
	 * Retrieves the number of patients seen at a given priority level.
	 * @param priority The priority on which to filter results. If 0, the total will be for all patients seen.
	 * Priorities of 1-5 will retrieve the total for only patients with conditions mating the specified priority.
	 * @return The number of patients seen at the specified priority.
	 * @throws EmptyLogException When no data is present in the ER log.
	 * @throws InvalidPriorityException When the specified priority is outside the range 0-5, inclusive.
	 */
	public int numPatientsSeen(int priority) throws EmptyLogException, InvalidPriorityException
	{
		if (patients.isEmpty())
		{
			throw new EmptyLogException();
		}
		
		if (priority < 0 || priority > 5)
		{
			throw new InvalidPriorityException();
		}
		
		int sum = 0;
		if (priority == 0)
		{
			sum = patients.size();
		}
		else
		{
			for (int i = 0; i < patients.size(); i++)
			{
				if (patients.get(i).getPriority() == priority)
				{
					sum++;
				}
			}
		}
		return sum;
	}
	
	/**
	 * Retrieves the average wait time patients seen thus far since opening the EmergencyRoomLog. The data may be
	 * optionally filtered based on the triage priority level.
	 * @param priority The priority on which to filter results. If 0, the average will be for all patients seen.
	 * Priorities of 1-5 will retrieve the average for only patients with conditions matching the specified
	 * priority.
	 * @return The average wait time for the data specified.
	 * @throws EmptyLogException When no data is present in the ER log.
	 * @throws InvalidPriorityException When the specified priority is outside the range 0-5, inclusive.
	 */
	public double getAverageWaitTime(int priority) throws EmptyLogException, InvalidPriorityException
	{
		if (patients.isEmpty())
		{
			throw new EmptyLogException();
		}
		
		if (priority < 0 || priority > 5)
		{
			throw new InvalidPriorityException();
		}
		
		int total = 0;
		double totalWait = 0;
		
		if (priority == 0)
		{
			for (int i = 0; i < patients.size(); i++)
			{
				total++;
				totalWait += (double) time.get(i) - patients.get(i).getTimeArrived();
			}
		}
		else
		{
			for (int i = 0; i < patients.size(); i++)
			{
				if (patients.get(i).getPriority() == priority)
				{
					total++;
					totalWait += (double) time.get(i) - patients.get(i).getTimeArrived();
				}
			}
		}
		
		double average = 0.0;
		if (total != 0)
		{
			average = (double) (totalWait / total);
		}
		
		return average;
	}
	
	/**
	 * Computes the number of patients in the EmergencyRoomLog whose total wait time prior to being seen exceeds the
	 * hospital specified thresholds for their priority level.
	 * @param priority The priority level of interest (1-5, inclusive).
	 * @return The total number of patients who waiting more than the number of minutes specified by the hospital's
	 * response threshold.
	 * @throws EmptyLogException When no data is present in the ER log.
	 * @throws InvalidPriorityException When the specified priority is outside the range 1-5, inclusive.
	 */
	public int numPatientsOverThreshold(int priority) throws EmptyLogException, InvalidPriorityException
	{
		if (patients.isEmpty())
		{
			throw new EmptyLogException();
		}
		
		if (priority < 1 || priority > 5)
		{
			throw new InvalidPriorityException();
		}
		
		int total = 0;
		
		for (int i = 0; i < patients.size(); i++)
		{
			if (patients.get(i).getPriority() == priority)
			{
				int patientPriority = patients.get(i).getPriority();
				int patientWaitTime = time.get(i) - patients.get(i).getTimeArrived();
				
				if (patientWaitTime > EmergencyConditions.timeThreshold(patientPriority))
				{
					total++;
				}
			}
		}
		return total;
	}
}
