// COURSE: CSCI1620
// TERM: Spring 2018
// 
// NAME: Joel Sare
// RESOURCES: We referred to no outside materials when
//            writing the code in this file.

/**
 * This class provides a simple abstraction for a savings account
 * that can gather monthly interest.
 * 
 * @author bdorn, pcavanaugh
 *
 */
public class SavingsAccount 
{
	/**
	 * Account number of the account holder.
	 */
	private int accountNumber;
	/**
	 * Shared member for the bank wide annual interest rate.
	 */
	private double annualInterestRate;
	/**
	 * Current funds in the account.
	 */
	private double balance;
	/**
	 * First name of the account holder.
	 */
	private String firstName;
	/**
	 * Last name of the account holder.
	 */
	private String lastName;
	
	/**
	 * Constructor used to create a new SavingsAccount for a bank member.
	 * Default interest rate is 0%.
	 * 
	 * @param firstNameIn The account holder's first name.
	 * @param lastNameIn The account holder's last name.
	 * @param accountNumberIn The new account number.
	 * @param balanceIn The initial opening balance for the account.
	 */
	public SavingsAccount(String firstNameIn, String lastNameIn, 
			int accountNumberIn, double balanceIn)
	{
		accountNumber = accountNumberIn;
		setFirstName(firstNameIn);
		setLastName(lastNameIn);
		balance = balanceIn;		
		annualInterestRate = 0;
	}
	
	/**
	 * Updates this account holder's first name with a valid non-empty
	 * String.  The first name is unchanged if an invalid value is given.
	 * 
	 * @param firstNameIn The new first name.
	 */
	public void setFirstName(String firstNameIn)
	{
		if (firstNameIn != null && !firstNameIn.equals(""))
		{
			firstName = firstNameIn;
		}
	}
	
	/**
	 * Retrieves the first name on this account.
	 * @return The first name.
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Updates this account holder's last name with a valid non-empty
	 * String.  The last name is unchanged if an invalid value is given.
	 * 
	 * @param lastNameIn The new last name.
	 */
	public void setLastName(String lastNameIn)
	{
		if (lastNameIn != null && !lastNameIn.equals(""))
		{
			lastName = lastNameIn;
		}
	}
	
	/**
	 * Retrieves the last name on this account.
	 * @return The last name.
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Retrieves the account number for this account.
	 * @return The account number.
	 */
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 * Credits this account a specified amount > 0.  Should either 0 or a negative 
	 * amount be deposited, the transaction will be unsuccessful and the account's balance
	 * will not change. 
	 *  
	 * @param anAmount how much money is being deposited into the account
	 * @return true iff the transaction was successful, false otherwise. 
	 */
	public boolean deposit(double anAmount)
	{
		if (anAmount <= 0)
		{
			return false;
		}
		balance += anAmount;
		return true;
	}
	
	/**
	 * Debits this account a specified amount > 0.  Should either 0 or a negative 
	 * amount be withdrawn, the transaction will be unsuccessful and the account's balance
	 * will not change. 
	 *   
	 *  @param anAmount how much money is being debited from the account
	 * @return true iff the transaction was successful, false otherwise. 
	 */
	public boolean withdraw(double anAmount)
	{
		if (anAmount <= 0)
		{
			return false;
		}
		else
		{
			balance -= anAmount;
			return true;
		}
	}
	
	/**
	 * Retrieves the current balance of this account.
	 * 
	 * @return The current balance.
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Applies monthly interest to the account by increasing balance by interest gained. 
	 */
	public void applyMonthlyInterest()
	{
		final int MONTHS = 12;
		balance += balance * (annualInterestRate / MONTHS);
	}
	
	/**
	 * Updates the annual interest rate on this account. 
	 * 
	 * @param rateIn The new interest rate specified in percentage form.  E.g., 
	 *               2.15 for 2.15% (not .0215).
	 */
	public void setInterestRate(double rateIn)
	{
		final int PERCENT_SCALE_BY = 100;
		annualInterestRate = rateIn / PERCENT_SCALE_BY;
	}
	
	/**
	 * Displays this SavingsAccount's number and current balance formatted like
	 * 
	 * 1234: $32.75
	 * 
	 * Amounts are rounded to the nearest cent. The account number is always
	 * displayed as 4 digits, including leading zeros as needed. 
	 * 
	 * @return The formatted string.
	 */
	public String toString()
	{
		return String.format("%04d: $%.2f", accountNumber, balance);
	}
}
