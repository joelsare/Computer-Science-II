package applications;

import java.util.Random;

import uno.collections.queues.Queue;
import uno.collections.queues.UnboundedQueue;

public class CoffeeSimulator
{
	public static void main(String[] args)
	{
		UnboundedQueue<Integer> customers = new UnboundedQueue<Integer>();
		Random rand = new Random();
		int sumOfWaitTimes = 0;
		int numPeopleServed = 0;
		boolean helpingSomeone = false;
		int serviceCountdown = 0;
		
		for (int i = 1; i <= 30; i++)
		{
			System.out.println("Time: " + i);
			
			//see if someone new arrived
			if (rand.nextInt(5) != 0)//80% chance
			{
				customers.enqueue(i);
				System.out.println("  Customer arrived");
			}
			
			//can I help someone new
			if (!helpingSomeone && !customers.isEmpty())
			{
				
				serviceCountdown = rand.nextInt(5) + 1;
				helpingSomeone = true;
				System.out.println("  Starting to help customer with service time " + serviceCountdown);
			}
			
			//if I am helping someone who just hit zero on their counter, remove them from the line and get
			//ready for the next person
			if (helpingSomeone && serviceCountdown == 0)
			{
				
				int start = customers.dequeue();
				sumOfWaitTimes += i - start;
				helpingSomeone = false;
				numPeopleServed++;
				System.out.println("  Customer done " + numPeopleServed);
			}
			
			//if still helping someone, just decrease their time left
			if (helpingSomeone)
			{
				System.out.println("  Still helping them");
				serviceCountdown--;
			}
			
			
		}
		
		
		
		//Show results?
		System.out.println("----------------------------");
		System.out.println("Customers Served: " + numPeopleServed);
		System.out.println("Average Wait Time: " + (sumOfWaitTimes / (double) numPeopleServed));
		System.out.println("Number in line at the end: " + customers.size());
		
		
		
	}

}
