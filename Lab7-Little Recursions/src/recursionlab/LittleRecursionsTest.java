package recursionlab;

import static org.junit.Assert.*;

import org.junit.Test;

public class LittleRecursionsTest {

	@Test
	public void testtrue()
	{
		assertTrue(LittleRecursions.isPalindrome(""));
	}
	
	@Test
	public void testone()
	{
		assertTrue(LittleRecursions.isPalindrome("e"));
	}
	
	@Test
	public void testfalse()
	{
		assertFalse(LittleRecursions.isPalindrome(" guroeqjl"));
	}
	
	@Test
	public void testreverse()
	{
		assertEquals("leoJ", LittleRecursions.reverseSome("Joe38l"));
	}
	
	@Test
	public void testgcd()
	{
		assertEquals(2, LittleRecursions.gcd(318, 8));
	}
	
	@Test
	public void testsumPos()
	{
		int[] arr = {1,5,5,-6};
		assertEquals(11, LittleRecursions.sumPositive(arr));
	}

}
