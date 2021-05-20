package linkedlist;

public class ListNode
{
	private Object data;
	private ListNode next;
	
	public ListNode(Object dataIn, ListNode nextIn)
	{
		setData(dataIn);
		setNext(nextIn);
	}
	
	public void setData(Object dataIn)
	{
		data = dataIn;
	}
	
	public Object getData()
	{
		return data;
	}
	
	public void setNext(ListNode nextIn)
	{
		next = nextIn;
	}
	
	public ListNode getNext()
	{
		return next;
	}
}
