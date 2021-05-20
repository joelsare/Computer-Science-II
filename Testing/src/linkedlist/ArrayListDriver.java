package linkedlist;

public class ArrayListDriver
{
	private static final int SIZE = 10;
	public static void main(String[] args)
	{
		//Create the structure - array *************************************
		Integer[] arr = new Integer[SIZE];
		int numElements = 0;
		
		LinkedList linkList = new LinkedList();
		//******************************************************************
		
		//Populate the structure, half of SIZE - array *********************
		for (int i = 0; i < SIZE / 2; i++)
		{
			arr[i] = i;
			numElements++;
		}
		//Print the array
		System.out.print("After Populate array: ");
		printArray(arr, numElements);
		
		for (int i = 0; i < SIZE / 2; i++)
		{
			linkList.add(i);
		}
		System.out.print("After Populate LinkedList: ");
		printLinkedList(linkList);
		//******************************************************************
		
		//Insert an item in the middle - array *****************************
		//Shift items to make room in the array
		for (int i = numElements - 1; i >= 2; i--)
		{
			arr[i+1] = arr[i];
		}
		//Add item in open spot
		arr[2] = 5;
		numElements++;
		//Print the array
		System.out.print("After Insert array: ");
		printArray(arr, numElements);
		
		linkList.add(2, 5);
		System.out.print("After Insert LinkedList: ");
		printLinkedList(linkList);
		//******************************************************************
		
		//Set the value of an existing element - array *********************
		arr[1] = 6;
		//Print the array
		System.out.print("After Set array: ");
		printArray(arr, numElements);
		
		linkList.set(1, 6);
		System.out.print("After Set LinkedList: ");
		printLinkedList(linkList);
		//******************************************************************
		
		//Get an item - array *******************************************
		System.out.printf("Value in array at index 2 is %s\n", arr[2]);
		System.out.printf("Value in LinkedListat index 2 is %s\n", linkList.get(2));
		//******************************************************************
		
		//Find index of an item - array ************************************
		System.out.printf("Location of value 3 in array is %d\n", linearSearch(arr, numElements, 3));
		System.out.printf("Location of value 10 in array is %d\n", linearSearch(arr, numElements, 10));
		
		System.out.printf("Location of value 3 in LinkedList is %d\n", linkList.indexOf(3));
		System.out.printf("Location of value 10 in LinkedList is %d\n", linkList.indexOf(10));
		//******************************************************************
		
		//Remove an item - array *******************************************
		//Shift elements over the removed item
		for (int i = 1; i < numElements - 1; i++)
		{
			arr[i] = arr[i + 1];
		}
		numElements--;
		//Print the array
		System.out.print("After Remove array: ");
		printArray(arr, numElements);
		
		linkList.remove(1);
		System.out.print("After Remove LinkedList: ");
		printLinkedList(linkList);
		//******************************************************************
		
		//Check if the collection is empty - array *************************
		if (numElements == 0)
		{
			System.out.println("Array is empty");
		}
		else
		{
			System.out.println("Array is not empty");
		}
		
		if (linkList.isEmpty())
		{
			System.out.println("LinkedList is empty");
		}
		else
		{
			System.out.println("LinkedList is not empty");
		}
		//******************************************************************
		
		//Add item to full collection - array
		//Fully populate the array for example
		for (int i = 0; i < SIZE; i++)
		{
			arr[i] = 0;
		}
		numElements = SIZE;
		//Create new array of larger size
		Integer[] temp = new Integer[SIZE * 2];
		//Copy original contents
		for (int i = 0; i < SIZE; i++)
		{
			temp[i] = arr[i];
		}
		//Re-assign the reference
		arr = temp;
		//Add new item
		arr[numElements] = 1;
		numElements++;
		//Print the array
		System.out.print("After Adding to fully populated array: ");
		printArray(arr, numElements);
		
		linkList.clear();
		for (int i = 0; i < SIZE; i++)
		{
			linkList.add(0);
		}
		
		linkList.add(1);
		System.out.print("After Adding to fully populated LinkedList: ");
		printLinkedList(linkList);
		
		//******************************************************************
		
		//Clear all data - array
		numElements = 0;
		linkList.clear();
		//******************************************************************
		
		//Check if the collection is empty - array *************************
		if (numElements == 0)
		{
			System.out.println("Array is empty");
		}
		else
		{
			System.out.println("Array is not empty");
		}
		
		if (linkList.isEmpty())
		{
			System.out.println("Array is empty");
		}
		else
		{
			System.out.println("Array is not empty");
		}
		//******************************************************************
	}
	
	public static <E> void printArray(E[] arr, int numElements)
	{
		System.out.print("Array - ");
		for (int i = 0; i < numElements; i++)
		{
			System.out.printf("%s ", arr[i]);
		}
		System.out.println();
	}
	
	public static <E> int linearSearch(E[] arr, int numElements, E search)
	{
		int location = -1;
		for (int i = 0; i < numElements; i++)
		{
			if (arr[i].equals(search))
			{
				location = i;
				break;
			}
		}
		return location;
	}
	
	public static void printLinkedList(LinkedList linkList)
	{
		System.out.print("LinkedList - ");
		for (int i = 0; i < linkList.size(); i++)
		{
			System.out.printf("%s ", linkList.get(i));
		}
		System.out.println();
	}
}
