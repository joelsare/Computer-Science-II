package accounts;
import java.io.Serializable;

/*Store basic account information including account number and balance*/
public class AccountRecord implements Comparable<AccountRecord>
{
	private int account;
	private double balance;

	public AccountRecord(int acct, double bal)
	{
		setAccount(acct);
		setBalance(bal);
	}

	public void setAccount(int acct)
	{
		account = acct;
	}

	public int getAccount()
	{
		return account;
	}

	public void setBalance(double bal)
	{
		balance = bal;
	}

	public double getBalance()
	{
		return balance;
	}

	/*Increase balance by passed amount*/
	public void addBalance(double amount)
	{
		balance += amount;
	}

	public String toString()
	{
		return String.format("%-10d%10.2f\n", account, balance);
	}
		
	public int compareTo(AccountRecord other)
	{
		return account - other.account;
	}
}
