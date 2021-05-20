// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Joel Sare
// RESOURCES: Lab 4 slides

////////////////////////////////////////////////////////////////
// ATTENTION: WebCAT will not deduct style points for your JUnit 
// test files.  Use of magic numbers is permitted in tests, and 
// javadoc for each method is optional.  However, it's good to 
// add comments that describe the purpose of each test if you 
// have time before the lab is due.
////////////////////////////////////////////////////////////////

import static org.junit.Assert.*;   // A Checkstyle error on this line is okay.

import org.junit.Test;

/**
 * This class provides a series of JUnit test cases corresponding
 * to the SavingsAccount.java functionality.
 * 
 * @author Joel Sare
 */
public class SavingsAccountTest
{
	///////////////////////////////////////////////////////////////
	// ATTENTION: Some sample tests are provided here to help you
	// get started.  Feel free to refer back to them as examples.
	// but we do not recommend editing them.
	///////////////////////////////////////////////////////////////
	
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * This test verifies the behavior of the default constructor when 
	 * provided valid parameter values.  Getters are also exercised to
	 * verify that the object has been set up correctly.
	 */
	@Test
	public void testConstructorBasic()
	{
		//STEP 1: Setup prior state of the object
		//Since we're testing a constructor here, this step is not applicable.
		
		//STEP 2: Call the method being tested
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());
		assertEquals("Maverick", a.getLastName());
		assertEquals(9721, a.getAccountNumber());
		
		// When comparing double or float values, assertEquals takes a 
		// third parameter that specifies how close the two values need to
		// be to be considered equal.
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
		
		//STEP 4: Verify the return value of the method called
		//For constructors, verifying the "post-state" in step 3 and the return 
		//value are synonymous.  There's nothing more to do here.
	}
	
	/**
	 * This test verifies that calling setFirstName with a valid string will
	 * cause the SavingsAccount to take on the new name.
	 */
	@Test
	public void testSetFirstNameValid()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName("Herbie");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Herbie", a.getFirstName());	//first name should have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with null values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValidNull()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName(null);
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with empty values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValidEmpty()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Maverick", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName("");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());	//first name should NOT have changed
		assertEquals("Maverick", a.getLastName());   //last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());	//account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  //balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	////////////////////////////////////////////////////////////////////////////
	// YOUR TESTS GO BELOW!  Try to write additional tests that exercise all of 
	// the code in SavingsAccount.java
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Tests the last name method with valid parameter.
	 */
	@Test
	public void testSetLastNameValid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.setLastName("Smith");
		assertEquals("Smith", a.getLastName());
	}
	
	/**
	 * Tests the set last name method with invalid parameter.
	 */
	@Test
	public void testSetLastNameInvalidNull()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.setLastName(null);
		assertEquals("Sare", a.getLastName()); //last name should NOT have changed
	}
	
	/**
	 * Tests the set last name method with invalid parameter.
	 */
	@Test
	public void testSetLastNameInvalidEmpty()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.setLastName("");
		assertEquals("Sare", a.getLastName()); //last name should NOT have changed
	}
	
	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		assertEquals("1521: $10.04", a.toString());
	}
	
	/**
	 * Tests withdraw method with valid parameter.
	 */
	@Test
	public void testWithdrawValid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.withdraw(2.0);
		assertEquals(8.04, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	
	/**
	 * Tests withdraw method with invalid parameter.
	 */
	@Test
	public void testWidthrawInvalid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.withdraw(-100);
		assertEquals(10.04, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Tests the deposit method with valid parameter.
	 */
	@Test
	public void testDepositValid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.deposit(2.0);
		assertEquals(12.04, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * Tests the deposit method with an invalid parameter.
	 */
	@Test
	public void testDepositInvalid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.deposit(-1000);
		assertEquals(10.04, a.getBalance(), DOUBLE_TOLERANCE); //balance should NOT have changed
	}
	
	/**
	 * Tests the apply monthly interest method with.
	 */
	@Test
	public void testApplyMonthlyInterest()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.applyMonthlyInterest();
		assertEquals(10.04, a.getBalance(), DOUBLE_TOLERANCE); //balance should NOT change
	}
	
	/**
	 * Tests the setInterestRate with valid parameters.
	 */
	@Test
	public void testSetInterestRateValid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.setInterestRate(2.5);
		a.applyMonthlyInterest();
		assertEquals(10.06, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/*
	@Test
	public void testSetInterestRateInvalid()
	{
		SavingsAccount a = new SavingsAccount("Joel", "Sare", 1521, 10.04);
		a.setInterestRate(-5.0);
		a.applyMonthlyInterest();
		assertEquals(10.04, a.getBalance(), DOUBLE_TOLERANCE); //balance should NOT change
	}*/
	
	
	
	
}
