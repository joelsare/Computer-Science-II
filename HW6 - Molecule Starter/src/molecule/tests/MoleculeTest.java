package molecule.tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import molecule.Molecule;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

public class MoleculeTest {

	@Test
	public void testConstructorValidChars()
	{
		Molecule mol = new Molecule("CHO");
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testConstructorInvalidChars()
	{
		thrown.expect(InvalidAtomException.class);
		Molecule mol = new Molecule("CHnO");
	}
	
	@Test
	public void testConstructorValidParen()
	{
		Molecule mol = new Molecule("(CHO)");
		assertEquals("(CHO)", mol.getSequence());
	}
	
	@Test
	public void testConstructorInvalidParan()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol = new Molecule("CH(O");
		Molecule mol2 = new Molecule("CH)O");
		Molecule mol3 = new Molecule("(CHO");
	}
	
	@Test
	public void testConstructornullandEmpty()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol = new Molecule(null);
		Molecule mol2 = new Molecule("");
	}
	
	@Test
	public void testConstructorOnlyParen()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol = new Molecule("()");
	}
	
	@Test
	public void testWeight()
	{
		Molecule mol = new Molecule("H((OH)2C3H)2");
		assertEquals(143, mol.getWeight());
	}
	
	@Test
	public void testAtomicWeightInvalid()
	{
		Molecule mol = new Molecule("H((OH)2C3H)2");
		thrown.expect(InvalidAtomException.class);
		Molecule.atomWeight('s');
	}
	
	@Test
	public void testCompareTo()
	{
		Molecule mol = new Molecule("H((OH)2C3H)2");
		Molecule mol2 = new Molecule("H((OH)2C3H)3");
		Molecule mol3 = new Molecule("H((OH)2C3H)");

		assertEquals(0, mol.compareTo(mol));
		assertEquals(-1, mol.compareTo(mol2));
		assertEquals(1, mol.compareTo(mol3));
	}
	
	@Test
	public void testtoString()
	{
		Molecule mol = new Molecule("H((OH)2C3H)2");
		System.out.println(mol);
	}
	
	@Test
	public void testClone()
	{
		String str = "H((OH)2C3H)2";
		Molecule mol = new Molecule(str);
		Molecule clone = (Molecule) mol.clone();
		assertFalse(mol.equals(clone));
		mol.setSequence("C");
		System.out.println("Mol weight: " +  mol.getWeight());
		System.out.println("Clone weight: " +  clone.getWeight());
		assertFalse(clone.getSequence().equals(mol.getSequence()));
		assertFalse(clone.getWeight() == (mol.getWeight()));
	}
	
	@Test
	public void testwebCat()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol = new Molecule("2H");

		System.out.println(mol);
	}
	
	@Test
	public void testInvalidEmpty()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol2 = new Molecule("");
	}
	
	@Test
	public void testInvalidParen()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol2 = new Molecule(")");
	}
	
	@Test
	public void testInvalidParen2()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol2 = new Molecule("(");
	}
	
	@Test
	public void testInvalidParen3()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol2 = new Molecule(")(");
	}
	
	@Test
	public void testInvalidParen4()
	{
		thrown.expect(InvalidSequenceException.class);
		Molecule mol2 = new Molecule("(((((((((");
	}
	
	@Test
	public void testwebCat2()
	{
		Molecule mol = new Molecule("(2H)(C)");
		System.out.println(mol);
	}
	
	@Test
	public void testManyNums()
	{
		Molecule mol = new Molecule("H6");
		System.out.println(mol);
	}
	
	@Test
	public void testGetNums()
	{
		System.out.println(Molecule.getNums("56", 0));
	}
	
	@Test
	public void testwebCat3()
	{
		Molecule mol = new Molecule("H23");
		int weight = mol.getWeight();
		System.out.println(weight);
	}
	
	@Test
	public void testUnclonable()
	{
		Molecule mol = new Molecule("(2H)(C)");
		
		System.out.println(mol);
	}

}
