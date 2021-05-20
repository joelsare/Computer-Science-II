import java.util.Iterator;

import uno.collections.lists.LinkedList;
import uno.collections.queues.UnboundedQueue;

public class ReviewSheetMethods
{
	static LinkedList list = new LinkedList();
	
	public static void add(Integer item)
	{
		if (list.isEmpty())
		{
			list.add(item);
		}
		else if (((Integer) list.get(0)).compareTo(item) > 0)
		{
            list.add(0, item);
        }
		else if (((Integer) list.get(list.size() - 1)).compareTo(item) < 0)
        {
            list.add(list.size(), item);
        }
		else
		{
			for (int i = 0; i < list.size(); i++)
			{
				if (((Integer) list.get(i)).compareTo(item) < 0)
				{
					list.add(i, item);
				}
			}
		}
	}
	
	public static void print()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	public static UnboundedQueue<Integer> merge(UnboundedQueue<Integer> q1, UnboundedQueue<Integer> q2)
	{
		UnboundedQueue<Integer> result = new UnboundedQueue<Integer>();
		
		while (!q1.isEmpty() && !q2.isEmpty())
		{
			if (q1.peek().compareTo(q2.peek()) < 0)
			{
				result.enqueue(q1.dequeue());
			}
			else
			{
				result.enqueue(q2.dequeue());
			}
		}
		
		if (q1.isEmpty())
		{
			while (!q2.isEmpty())
			{
				result.enqueue(q2.dequeue());
			}
		}
		else if (q2.isEmpty())
		{
			while (!q1.isEmpty())
			{
				result.enqueue(q1.dequeue());
			}
		}
		
		return result;
	}
	
	
	
	
	
	
	
	public static void main (String[] args)
	{
		ReviewSheetMethods rsm = new ReviewSheetMethods();
		rsm.add(99);
		rsm.add(15);
		rsm.add(5);
		rsm.add(100);
		rsm.add(-1);
		rsm.print();
		
		/*
		UnboundedQueue<Integer> a = new UnboundedQueue<Integer>();
		UnboundedQueue<Integer> b = new UnboundedQueue<Integer>();
		
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(6);
		a.enqueue(7);
		a.enqueue(8);
		a.enqueue(9);
		a.enqueue(11);
		
		b.enqueue(1);
		b.enqueue(3);
		b.enqueue(5);
		b.enqueue(15);
		b.enqueue(25);
		b.enqueue(66);
		b.enqueue(88);
		b.enqueue(100);
		
		UnboundedQueue<Integer> result = ReviewSheetMethods.merge(a, b);
		while (!result.isEmpty())
		{
			System.out.println(result.dequeue());
		}
		*/
		
		java.util.LinkedList<String> chars = new java.util.LinkedList<String>();
		
		for (int i = 0; i < 10000; i++)
		{
			chars.add("S");
		}
		/*
		for (int k = 0; k < chars.size(); k++)
		{
			System.out.println(chars.get(k).toLowerCase());
		}
		*/
		
		Iterator<String> itr = chars.iterator();
		
		while (itr.hasNext())
		{
			System.out.println(itr.next().toLowerCase());
		}
	}
}
