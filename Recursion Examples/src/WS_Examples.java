

public class WS_Examples
{
	public static void main (String[] args)
	{
		String word = "Abracadabra";
		System.out.println(charCount(word, 'a'));
	}
	
	public static int charCount(String word, char value)
	{
		int sum = 0;
		if (word == null || word.equals(""))
		{
			return sum;
		}
		else if (Character.toLowerCase(word.charAt(0)) == value)
		{
			sum++;
			return sum + charCount(word.substring(1), value);
		}
		else
		{
			return sum + charCount(word.substring(1), value);
		}
	}
	
	public static int subarraySum(int [] arr, int left, int right)
	{
		int sum = 0;
		if (left > right)
		{
			return sum;
		}
		else
		{
			return sum += arr[left] + subarraySum(arr, left + 1, right);
		}
	}
	
	public static int maxElement(int[] arr)
	{
		return elementHelper(arr, 0);
	}
	
	private static int elementHelper(int[] arr, int counter)
	{
		if (counter == arr.length - 1)
		{
			return arr[counter];
		}
		else
		{
			return Math.max(arr[counter], elementHelper(arr, counter + 1));
		}
	}
}
