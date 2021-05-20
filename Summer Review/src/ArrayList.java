
public class ArrayList<E> implements List<E>
{
	private E[] arr = (E[]) new Object[10];
	private int currentIndex = 0;
	
	public boolean add(E object)
	{
		if (isEmpty())
		{
			arr[currentIndex] = object;
			currentIndex++;
 			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		return currentIndex < 10;
	}
	
	public E get(int i)
	{
		return arr[i];
	}
	
}
