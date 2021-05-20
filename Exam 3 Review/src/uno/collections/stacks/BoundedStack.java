package uno.collections.stacks;

import uno.collections.lists.ArrayList;

public class BoundedStack<E> implements Stack<E>
{
	private ArrayList<E> data;
	private int maxSize;
	
	public BoundedStack(int capacity)
	{
		if (capacity < 1)
			throw new IllegalArgumentException("Capacity must be > 0");
		data = new ArrayList<>();
		maxSize = capacity;
	}

	@Override
	public boolean isEmpty()
	{
		return data.size() == 0;
	}

	@Override
	public int size()
	{
		return data.size();
	}

	@Override
	public E peek()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot peek at empty stack");
		}
		return data.get(data.size() - 1);
	}

	@Override
	public E pop()
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot peek at empty stack");
		}
		return data.remove(data.size() - 1);
	}

	@Override
	public E push(E item)
	{
		if (!isFull())
		{
			data.add(item);
			return item;
		}
		else
		{
			throw new IllegalStateException("Cannot push on full stack");
		}
	}

	@Override
	public int search(Object o)
	{
		return data.indexOf((E) o);
	}
	
	public boolean isFull()
	{
		return size() == maxSize;
	}
}
