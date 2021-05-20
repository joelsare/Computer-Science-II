
public class Sort {
	
	public int linSearch(int[] data, int searchValue)
	{
		int position = -1;
		for (int n = 0; n < data.length; n++)
		{
			if (data[n] == searchValue)
			{
				position = n;
				break;
			}
		}
		return position;
	}
	
	public void bubbleSort(int[] data)
	{
		for (int pass = 0; pass < data.length - 1; pass++)
		{
			for (int comp = 0; comp < data.length; comp++)
			{
				if (data[comp] > data[comp + 1])
				{
					int temp = data[comp];
					data[comp] = data[comp + 1];
					data[comp + 1] = temp;
				}
			}
		}
	}
	
	public void bubbleSortEarlyExit(int[] data)
	{
		boolean sorted;
		for (int pass = 0; pass < data.length - 1; pass++)
		{
			sorted = true;
			for (int comp = 0; comp < data.length; comp++)
			{
				if (data[comp] > data[comp + 1])
				{
					sorted = false;
					int temp = data[comp];
					data[comp] = data[comp + 1];
					data[comp + 1] = temp;
				}
			}
			if (sorted)
			{
				break;
			}
		}
	}
	
	public void selectionSort(int[] data)
	{
		int smallest;
	      for ( int pos = 0; pos < data.length - 1; pos ++ ) 
	      {
	         smallest = pos;
	         for ( int a = pos + 1; a < data.length; a++ ) 
	         {
	            if ( data[a] < data[smallest] ) 
	            {
	               smallest = a;
	            }
	         }
	         int temp = data[pos];
	         data[pos] = data[smallest];
	         data[smallest] = temp;
		}
	}
	
	public void insertionSort(int[] data)
	{
		int insert; //temporary variable to hold element to insert
		for (int next = 1; next < data.length; next++)
		{
			insert = data[next]; //store value in current element
			int moveItem = next; //initialize location to place element
			//shift items in "sorted" to make room for next element
			//similar to "bubbling" in bubble sort
			while (moveItem > 0 && data[moveItem - 1] > insert)
			{
				data[moveItem] = data[moveItem - 1]; // shift element right one slot
				moveItem--;
			}
			data[moveItem] = insert;
		}
	}
}
