// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Joel Sare
// RESOURCES: Lab 11 slides.

package uno.collections.lists;

/**
 * Sorts linked lists.
 * @author joelsare
 * @param <E>
 *
 */
public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E>
{
	/**
	 * Creates a new SortedLinkedList.
	 */
	public SortedLinkedList()
	{
		//empty constructor
	}
	
	/**
	 * Adds an item to the list while preserving the global sorted order of the list.
	 * @param item The new item to be inserted.
	 * @return true when this item was successfully added
	 */
	public boolean add(E item)
	{
		super.add(item);
		/*
		if (super.isEmpty())
		{
			super.add(item);
		}
		else
		{
			for (int i = 0; i < super.size(); i++)
			{
				if (item.compareTo(super.get(i)) <= 0)
				{
					super.add(i, item);
					break;
				}
				else if (i == super.size() - 1)
				{
					super.add(item);
					break;
				}
			}
		}
		*/
		return true;
	}
	
	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception
	 * @param index The index where an item is to be added in the list.
	 * @param item The item to be added to the list.
	 * @throws UnsupportedOperationException every time.
	 */
	public void add(int index, E item) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception
	 * @param index The index where an item is to be added in the list.
	 * @param item The item to be added to the list.
	 * @return The element previously stored at the specified index.
	 * @throws UnsupportedOperationException every time.
	 */
	public E set(int index, E item) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
}
