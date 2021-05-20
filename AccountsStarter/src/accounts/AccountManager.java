package accounts;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AccountManager
{
	/*Accounts stored here*/
	private ArrayList<AccountRecord> accounts;
	
	public AccountManager()
	{
		accounts = new ArrayList<AccountRecord>();
	}
	
	/*Read in any existing records from provided serialized file into accounts ArrayList*/
	public void readRecords(String recordFile) throws FileNotFoundException, IOException, ClassNotFoundException
	{

		
	}
	
	/*Write all accounts to given file*/
	public void writeRecords(String recordFile) throws FileNotFoundException, IOException
	{

	}
	
	/*Update an existing record or create new account if it does not exist*/
	private void updateRecord(int account, double amount)
	{


	}
	
	/*Read in transactions from text file in format of ACCNTNUMBER TRANSAMOUNT and update records*/
	public void updateTransactions(String transFile) throws FileNotFoundException
	{

		
	}
	
	/*String it up*/
	public String toString()
	{
		String ret = String.format("%-10s%10s\n", "Account", "Balance");
		
		Collections.sort(accounts);
		
		for (int i = 0; i < accounts.size(); i++)
		{
			ret += accounts.get(i);
		}
		
		return ret;
	}
}

