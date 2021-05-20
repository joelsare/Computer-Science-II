// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW5 Supplemental Material.

package hospital.model;

import java.io.Serializable;

/**
 * This class encapsulates information for Patients within our hospital management system.
 * It stores data about a patient, their reason for coming to the ER, and the time at which
 * they arrived. Priority and time information is used to enable comparisons between Patients
 * to determine who should be seen next by a doctor per our ER's triage rules.
 * @author joelsare
 *
 */
public class Patient implements Serializable, Comparable<Patient>
{
	/**
	 * String that holds the name of patient.
	 */
	private String name;
	
	/**
	 * Reason for why patient is at ER.
	 */
	private String condition;
	
	/**
	 * Time in minutes.
	 */
	private int currentTime;
	
	/**
	 * Priority, 1-5 inclusive.
	 */
	private int priority;
	/**
	 * Constructs a new Patient object based on the provided parameter information. The constructor
	 * assumes that all provided parameter values (including condition and priority information) are
	 * valid within the system. Thus, the code which creates Patient objects must verify the data provided
	 * conforms to the specified requirements.
	 * @param nameIn The Patient's name provided in "Last, First" format.
	 * @param conditionIn The primary complaint or reason for the ER visit. Valid field values are those contained
	 * in the hospital configuration file.
	 * @param currentTimeIn A numeric timestamp for when this Patient is created within the system. Timestamps are
	 * integer values for the number of minutes since data collection began.
	 * @param priorityIn A numeric triage priority value between 1 and 5, inclusive based on the Patient's
	 * condition. The constructor assumes that range checking and correctness of values is done by the
	 * calling method.
	 */
	public Patient(String nameIn, String conditionIn, int currentTimeIn, int priorityIn)
	{
		name = nameIn;
		condition = conditionIn;
		currentTime = currentTimeIn;
		priority = priorityIn;
	}
	
	/**
	 * Returns the time of when this Patient was created in this system. A timestamp of 0 means the Patient
	 * arrived immediately upon data collection starting.
	 * @return The timestamp corresponding to arrival.
	 */
	public int getTimeArrived()
	{
		return currentTime;
	}
	
	/**
	 * Returns the name in "Last, First" format.
	 * @return The name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the condition for which this Patient came to the ER.
	 * @return The Patient's complaint or condition.
	 */
	public String getCondition()
	{
		return condition;
	}
	
	/**
	 * The numeric priority assigned to this Patient upon arrival at the ER. This value will always be
	 * between 1 and 5 inclusive, with 1 being the highest priority.
	 * @return The priority rating.
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/**
	 * Returns a string representing this Patient's details.
	 * @return The formatted String.
	 */
	public String toString()
	{
		return String.format("Patient: %-25s Condition: %-25s Priority: %-3d Waiting Since: %d",
				getName(), getCondition(), getPriority(), getTimeArrived());
	}
	
	/**
	 * Compares this Patient to another based on a two-tier priority ordering of Patients. A < B when A's
	 * priority is a smaller number than B's. When priority is equal, the one who has been waiting longer
	 * should be seen first.
	 * @param other The Patient to compare to for ordering.
	 * @return -1 if this Patient should be seen before other. 1 if other should be seen first. 0 if there is
	 * no preference (both have same priority & wait time).
	 */
	public int compareTo(Patient other)
	{
		if (Integer.compare(this.getPriority(), other.getPriority()) == 0)
		{
			return Integer.compare(this.getTimeArrived(), other.getTimeArrived());
		}
		else
		{
			return Integer.compare(this.getPriority(), other.getPriority());
		}
	}
}
