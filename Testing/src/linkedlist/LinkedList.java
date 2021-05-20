package linkedlist;

public class LinkedList
{
	private ListNode firstNode;
	private ListNode lastNode;
	private int numElements;
	
	public LinkedList()
	{
		clear();
	}
	
	public int size()
	{
		return numElements;
	}
	
	public boolean isEmpty()
	{
		return numElements == 0;
	}
	
	public void clear()
	{
		firstNode = lastNode = null;
		numElements = 0;
	}
	
	private ListNode getNode(int index)
	{
		ListNode temp = firstNode;
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	public boolean add(Object item)
	{
		ListNode newNode = new ListNode(item, null);
		
		if (firstNode == null)
		{
			firstNode = lastNode = newNode;
		}
		else
		{
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		
		numElements++;
		return true;
			
	}
	
	public void add(int index, Object item)
	{
		if (index == 0 && !isEmpty())
		{
			ListNode newNode = new ListNode(item, firstNode);
			firstNode = newNode;
			numElements++;
		}
		else if (index < numElements && !isEmpty())
		{
			ListNode prev = getNode(index - 1);
			ListNode newNode = new ListNode(item, prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
		else
		{
			add(item);
		}
	}
	
	public Object set(int index, Object item)
	{
		ListNode temp = getNode(index);
		Object data = temp.getData();
		temp.setData(item);
		return data;
	}
	
	public Object remove(int index)
	{
		Object data;
		
		if (size() == 1)
		{
			data = firstNode.getData();
			firstNode = lastNode = null;
		}
		else if (index == 0)
		{
			data = firstNode.getData();
			firstNode = firstNode.getNext();
		}
		else
		{
			ListNode prev = getNode(index - 1);
			data = prev.getNext().getData();
			prev.setNext(prev.getNext().getNext());
			if (index == size() - 1)
			{
				lastNode = prev;
			}
		}
		numElements--;
		return data;
	}
	
	public Object get(int index)
	{
		return getNode(index).getData();
	}
	
	public int indexOf(Object item)
	{
		int location = -1;
		ListNode temp = firstNode;
		for (int i = 0; i < size(); i++)
		{
			if (temp.getData().equals(item))
			{
				location = i;
				break;
			}
			temp = temp.getNext();
		}
		return location;
	}
	
	
	
	
	
}
