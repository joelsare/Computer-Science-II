package accounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AccountDriver
{
	public static void main(String[] args)
	{
		//For user input of file names
		Scanner in = new Scanner(System.in);
		String recordsFile;
		String transFile = null;

		//Create new Manager
		AccountManager accts = new AccountManager();

		/*Get name of records file, use to read existing records
		and will write to after processing transactions*/
		System.out.print("Enter name of records file: ");
		recordsFile = in.next();

		try
		{
			//Try to read existing records
			accts.readRecords(recordsFile);
			//If found output original records
			System.out.println(accts);
		}
		catch (FileNotFoundException fnfe)
		{
			//No previous existing records
			System.err.println("No existing records");
		}
		catch (ClassNotFoundException cnfe) //What's an AccountRecord? Bail
		{
			System.err.printf("Unknown type in %s file...Exiting\n", recordsFile);
			System.exit(0);
		}
		catch (IOException ioe) //Something amiss while reading, bail
		{
			System.err.printf("Problem reading from %s file...Exiting\n", recordsFile);
			System.exit(0);
		}
		
		//Get name of transaction file
		System.out.print("Enter name of transactions file: ");
		transFile = in.next();
		
		try
		{
			//Update/Create records from transaction file
			accts.updateTransactions(transFile);
		}
		catch (FileNotFoundException fnfe) //No such file, bail
		{
			System.err.printf("%s file not found...Exiting\n", transFile);
			System.exit(0);
		}

		//Print updated records
		System.out.println(accts);

		System.out.println("Writing records to file...");

		try
		{
			//Write updated records
			accts.writeRecords(recordsFile);
		}
		catch (IOException ioe) //Problem writing, report and bail
		{
			System.err.printf("Problem writing to %s file...Exiting\n", recordsFile);
			System.exit(0);
		}
	}
}