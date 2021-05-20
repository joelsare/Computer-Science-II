package linkedlist;

public class Tester {

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		
		list.add(1);
		list.add(6);
		list.add(1,2);
		list.add(0,0);
		list.remove(3);
		list.remove(2);
		list.add(3);



		System.out.println(list.size());
		
	}

}
