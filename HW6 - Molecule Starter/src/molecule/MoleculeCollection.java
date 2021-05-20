// COURSE: CSCI1620
// TERM: Spring 2018
//  	
// NAME: Joel Sare	
// RESOURCES: HW4 Supplemental Material.

package molecule;

import java.util.LinkedList;

import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * A collection of Molecules maintained in a LinkedList. Allows for adding, sorting,
 * and updating Molecules in the collection. A List of the Molecules can also be retrieved;
 * the returned list is a deep copy of the list held in the MoleculeCollection.
 * @author joelsare
 *
 */
public class MoleculeCollection
{
	/**
	 * Holds Molecules.
	 */
	private LinkedList<Molecule> list;
	
	/**
	 * Creates a new MoleculeCollection containing no Molecules yet.
	 */
	public MoleculeCollection()
	{
		list = new LinkedList<Molecule>();
	}
	
	/**
	 * Creates a new MoleculeCollection based upon an existing list of Molecules. The newly created
	 * MoleculeCollection will store a deep copy of the encapsulation. If the passed reference is null,
	 * the created MoleculeCollection will be empty.
	 * @param moleculeListIn LinkedList of Molecules used to created a new MoleculeCollection.
	 */
	public MoleculeCollection(LinkedList<Molecule> moleculeListIn)
	{
		if (moleculeListIn == null)
		{
			list = new LinkedList<Molecule>();
		}
		else
		{
			list = new LinkedList<Molecule>();
			for (int i = 0; i < moleculeListIn.size(); i++)
			{
				Molecule a = moleculeListIn.get(i);
				list.add(a);
			}
		}
	}
	
	/**
	 * Adds a copy of a given Molecule to this MoleculeCollection at a given index. Future external changes
	 * to the original Molecule will not impact values in the collection. If add is null, this MoleculeCollection
	 * is unchanged. If the given index is out of range, the Molecule will be added to the end of the Collection.
	 * @param index The index in which to add the Molecule.
	 * @param mol Molecule to be added to the Collection.
	 */
	public void addMolecule(int index, Molecule mol)
	{
		if (mol != null)
		{
			Molecule clone = new Molecule(mol.getSequence());
			if (index < 0 || index >= list.size())
			{
				list.add(clone);
			}
			else
			{
				list.add(index, clone);
			}
		}
	}
	
	/**
	 * Reorders the MoleculeCollection based on atomic weight. Molecules with the same weights should appear
	 * in their original order of insertion relative to one another. (ie sort() is a stable sorting algorithm).
	 */
	public void sort()
	{
		for (int pass = 0; pass < list.size() - 1; pass++)  // count passes
		{
			for (int comp = 0; comp < list.size() - 1; comp++)
			{
				if (list.get(comp).compareTo(list.get(comp + 1)) > 0)
				{
					Molecule temp = list.get(comp);
					list.set(comp, list.get(comp + 1));
					list.set(comp + 1, temp);
				}				
			}
		}
	}
	
	/**
	 * Sums the weights of all Molecules in the MoleculeCollection.
	 * @return The sum of all weights in the collection.
	 */
	public int moleculeWeights()
	{
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
		{
			sum += list.get(i).getWeight();
		}
		return sum;
	}
	
	/**
	 * Generates and returns a deep copy of a list containing all of the Molecules in this MoleculeCollection.
	 * Modifying the returned list will not impact the contents of this MoleculeCollection in any way.
	 * @return Deep copy of the Molecules.
	 */
	public LinkedList<Molecule> getMoleculeList()
	{
		LinkedList<Molecule> clone = new LinkedList<Molecule>();
		for (int i = 0; i < list.size(); i++)
		{
			Molecule a = new Molecule(list.get(i).getSequence());
			clone.add(a);
		}
		return clone;
	}
	
	/**
	 * Changes the sequence of a Molecule in the collection at the specified index. This does not create
	 * a new Molecule, rather modifies an existing Molecule.
	 * If the provided sequence is not valid due to either an invalid sequence or invalid atom, the original
	 * state of the Molecule at the specified index should be unaffected and the resulting exception will be
	 * thrown to the caller. 
	 * @param index Location of the Molecule to update.
	 * @param newSequence New sequence of the specified Molecule.
	 * @throws InvalidAtomException Thrown if new sequence is invalid due to unknown atom.
	 * @throws InvalidSequenceException Thrown if the new sequence is invalid due to format.
	 */
	public void changeSequence(int index, String newSequence) throws InvalidAtomException, InvalidSequenceException
	{
//		try
//		{
		Molecule a = list.get(index);
		a.setSequence(newSequence);
//		}
//		catch (InvalidAtomException iae)
//		{
//			throw iae;
//		}
//		catch (InvalidSequenceException ise)
//		{
//			throw ise;
//		}
	}
}
