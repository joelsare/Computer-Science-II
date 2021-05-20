// COURSE: CSCI1620
// TERM: Spring 2018
// 
// NAME: Dr. Dorn
// RESOURCES: I referred to the UML design in the Lecture 6 slides while 
//            implementing this code file.

import java.util.Date;

/**
 * This class provides functionality for Employees in a basic
 * small business records system.  Basic information about 
 * name, address, and date of hire are maintained here.
 * 
 * @author Dr. Dorn and Mr. Cavanaugh
 *
 */
public abstract class Employee
{
	/**
	 * The employee's last name, may contain non-alphabetic chars.
	 */
	private String lastName;
	/**
	 * The employee's first name, may contain non-alphabetic chars.
	 */
	private String firstName;
	/**
	 * The date of hire for this employee in the system.
	 */
	private Date hireDate;
	/**
	 * The employee's home mailing address for paychecks.
	 */
	private Address homeAddress;
	
	/**
	 * Creates an Employee using the details provided as parameters.
	 * Date of hire will correspond to the moment of instantiation.
	 * 
	 * @param fNameIn The new employee's first name.
	 * @param lNameIn The new employee's last name.
	 * @param addressIn The employee's home mailing address.
	 */
	public Employee(String fNameIn, String lNameIn, Address addressIn)
	{
		firstName = fNameIn;
		lastName = lNameIn;
		homeAddress = addressIn;
		
		//Hire date will correspond to the date when this Employee object
		//is created in the system.  See details about java.util.Date.
		hireDate = new Date();		
	}
	
	/**
	 * Retrieves this employee's full name with a single space between 
	 * first and last name.
	 * 
	 * @return The full name.
	 */
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	/**
	 * Retrieves this employee's street address formatted as a US postal
	 * address suitable for use in mail merge operations.
	 * 
	 * @return An address formatted per US postal service rules.
	 */
	public String getCheckAddress()
	{
		return homeAddress.toString();
	}
	
	/**
	 * Retrieves this employee's bi-weekly pay amount.
	 * 
	 * @return The amount to pay the employee every two weeks based on 
	 *         job duties.
	 */
	public abstract double computePaycheck();

}
