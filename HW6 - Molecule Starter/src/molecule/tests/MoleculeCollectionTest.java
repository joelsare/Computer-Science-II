package molecule.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import molecule.Molecule;
import molecule.MoleculeCollection;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

public class MoleculeCollectionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test()
	{
		MoleculeCollection nothing = new MoleculeCollection(null);
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(-1, new Molecule("C"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("H"));
		a.addMolecule(-1, new Molecule("C"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("H"));
		a.sort();
		LinkedList<Molecule> b = a.getMoleculeList();
		System.out.println("A before:  " + a.moleculeWeights());
		a.addMolecule(-1, new Molecule("H"));
		b.add(new Molecule("C"));
		MoleculeCollection bb = new MoleculeCollection(b);
		bb.addMolecule(3, new Molecule("O"));
		thrown.expect(InvalidAtomException.class);
		bb.changeSequence(3, "R");
		
		thrown.expect(InvalidSequenceException.class);
		bb.changeSequence(3, "(H");

	}
	
	@Test
	public void testthrowInvalidAtom()
	{
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(-1, new Molecule("C"));
		thrown.expect(InvalidAtomException.class);
		a.changeSequence(0, "R");
	}
	
	@Test
	public void testSecond()
	{
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(-1, new Molecule("C"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("H"));
		a.addMolecule(-1, new Molecule("C"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("H"));
		a.addMolecule(8, new Molecule("H"));
		a.addMolecule(-1, null);
		
		thrown.expect(InvalidSequenceException.class);
		a.changeSequence(3, "(H");
	}
	
	@Test
	public void testValidEverything()
	{
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(-1, new Molecule("C"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("H"));
		a.addMolecule(-1, new Molecule("C"));
		a.addMolecule(-1, new Molecule("O"));
		a.addMolecule(-1, new Molecule("H"));
		a.addMolecule(8, new Molecule("H"));
		a.addMolecule(-1, null);
		
		a.changeSequence(3, "H");
	}
	

}
