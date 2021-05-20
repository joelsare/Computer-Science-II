import uno.collections.lists.LinkedList;

public class Sublist implements Cloneable
{
	String myVal;
	public Sublist(String valIn)
	{
		myVal = valIn;
	}
	
	public String toString()
	{
		return myVal;
	}
	
	public static <E extends Cloneable> LinkedList<E> getSubList(LinkedList<E> orig, int start, int end)
	{
		LinkedList<E> clone = new LinkedList<E>();
		
		if (start < 0 || end > orig.size())
		{
			throw new RuntimeException();
		}
		
		for (int i = start; i <= end; i++)
		{
			clone.add(orig.get(i));
		}
		
		return clone;
	}
	
	public static void main (String[] args)
	{
		LinkedList s = new LinkedList();
		s.add(new Sublist("Hello"));
		s.add(new Sublist("Hi"));
		s.add(new Sublist("How"));
		s.add(1);
		
		LinkedList cloneS = Sublist.getSubList(s, 0, 1);
		
		s.add(0, "H");
		
		for (int i = 0; i < cloneS.size(); i++)
		{
			System.out.println(cloneS.get(i));
		}
	}
}
