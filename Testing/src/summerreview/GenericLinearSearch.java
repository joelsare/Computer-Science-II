package summerreview;

public class GenericLinearSearch
{
	public static <E> int ls(E[] data, E val)
	{
		int value = -1;
		
		for (int i = 0; i < data.length; i++)
		{
			if (val.equals(data[i]))
			{
				value = i;
				break;
			}
		} 
		return value;
	}
	
	public static void main (String[] args)
	{
		Integer[] d = {1,2,5,6,7,9};
		
		System.out.println(GenericLinearSearch.ls(d, 6));
	}
}
