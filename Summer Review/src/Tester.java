
public class Tester {

	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println(list.get(0));
	//	list.add('c');
		System.out.println(huh(list));
	}

	public static <E> boolean huh(List<E> o)
	{
		return o.isEmpty();
	}
}



































