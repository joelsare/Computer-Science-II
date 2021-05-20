// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW2 Supplemental Material

package triptypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class represents a single flight within the travel agency system.
 * @author joelsare
 *
 */
public class Flight
{
	/**
	 * Two letter code representing an airline.
	 */
	private String airline;
	/**
	 * Number for the flight.
	 */
	private int flightNum;
	/**
	 * Three letter code representing where the plane leaves from.
	 */
	private String from;
	/**
	 * Three letter code representing where the plane is going to.
	 */
	private String to;
	/**
	 * When the plane leaves.
	 */
	private Calendar leavesAt;
	/**
	 * When the plane arrives.
	 */
	private Calendar arrives;
	/**
	 * Price of plane ride.
	 */
	private double price;
	
	/**
	 * Creates a new flight leg in the system.
	 * @param airlineIn The two letter airline code.
	 * @param flightNumIn The flight number on a given day.
	 * @param fromIn The three letter airport code for the departure airport.
	 * @param toIn The three letter airport code for the arrival airport.
	 * @param leavesAtIn The departure time.
	 * @param arrivesIn The arrival time.
	 * @param priceIn Price for flight in US Dollars.
	 */
	public Flight(String airlineIn, int flightNumIn, String fromIn, String toIn, 
		Calendar leavesAtIn, Calendar arrivesIn, double priceIn)
	{
		airline = airlineIn;
		flightNum = flightNumIn;
		from = fromIn;
		to = toIn;
		leavesAt = leavesAtIn;
		arrives = arrivesIn;
		price = priceIn;
	}
	
	/**
	 * Retrieves the price of this flight.
	 * @return The price in US Dollars.
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * Retrieves a formatted String summarizing this Flight.
	 * @return A formatted String.
	 */
	public String toString()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		return String.format("%s%4d Departs: %s at %s; Arrives %s at %s", airline, flightNum,
				from, pretty.format(leavesAt.getTime()), to, pretty.format(arrives.getTime()));
	}
}
