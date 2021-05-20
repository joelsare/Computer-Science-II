// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package hospital.model;

import java.io.Serializable;
import java.util.ArrayList;

import hospital.exceptions.EmptyWaitingRoomException;

/**
 * This class abstracts details of an ER waiting room consisting of a lost of Patients. WaitingRoom
 * objects provide an urgency-ordered view of the Patients consistent with medical triage principles.
 * More utgent patients will be placed in the list ahead of less urgent patients.
 * @author joelsare
 *
 */
public class WaitingRoom implements Serializable
{
	/**
	 * ArrayList to hold Patient objects.
	 */
	private ArrayList<Patient> list = new ArrayList<Patient>();
	
	/**
	 * Builds a new empty waiting room with no Patients.
	 */
	public WaitingRoom()
	{
		//empty constructor
	}
	
	/**
	 * Adds a specified Patient to the waiting room while preserving the urgency-ordering of Patients
	 * based on the triage rules described by Patient.compareTo.
	 * @param sickPerson The newly arrived Patient to place in this WaitingRoom.
	 */
	public void addPatient(Patient sickPerson)
	{
		/*
		if (list.isEmpty()) 	
		{	
			list.add(sickPerson);	  	
		}	
		else	
		{
        	 	for (int i = 0; i < list.size(); i++)
        	 	{
        	 		if (sickPerson.compareTo(list.get(i)) <= 0)
        	 		{
        	 			list.add(i, sickPerson);	
        	 			break;	
        	 		} 	
        	 		else if (i == list.size() - 1)	
        	 		{	
        	 			list.add(sickPerson);	
        	 			break;
        	 		}	
        	 	}
		}
		*/
		list.add(sickPerson);
		sort(list);
	}
	
	/**
	 * Sorts the patients.
	 * @param list the ArrayList to be sorted.
	 * @param <E> Generic data type.
	 */
	public static <E extends Comparable<E>> void sort(ArrayList<E> list)
	{
		for (int pass = 0; pass < list.size() - 1; pass++)  // count passes
		{
			for (int comp = 0; comp < list.size() - 1; comp++)
			{
				if (list.get(comp).compareTo(list.get(comp + 1)) > 0)
				{
					E temp = list.get(comp);
					list.set(comp, list.get(comp + 1));
					list.set(comp + 1, temp);
				}				
			}
		}
	}
	
	/**
	 * Retrieves the next most-urgent person from the WaitingRoom. This method also removes the Patient
	 * from the WaitingRoom as they are now being seen by a physician.
	 * @return The most-urgent Patient object that was in the WaitingRoom.
	 * @throws EmptyWaitingRoomException when there are no patients waiting to be seen.
	 */
	public Patient getNextPatient() throws EmptyWaitingRoomException
	{
		if (list.isEmpty())
		{
			throw new EmptyWaitingRoomException();
		}
		else
		{
			Patient pat = list.get(0);
			list.remove(0);
			return pat;
		}
	}
	
	/**
	 * Retrieves the current total number of patients waiting in the WaitingRoom.
	 * @return The number of patients waiting.
	 */
	public int getNumWaiting()
	{
		return list.size();
	}
	
	/**
	 * Produces a String with details about the current status of this WaitingRoom.
	 * @return a formatted string depending on number of patients.
	 */
	public String toString()
	{
		String result = "Waiting Room Status:";
		if (list.isEmpty())
		{
			result += " EMPTY!";
		}
		else
		{
			result += "\n";
			for (int i = 0; i < list.size(); i++)
			{
				if (i == list.size() - 1)
				{
					result += String.format("%5d) %s", i + 1, list.get(i).toString());

				}
				else
				{
					result += String.format("%5d) %s\n", i + 1, list.get(i).toString());
				}
			}
		}
		return result;
	}
}
