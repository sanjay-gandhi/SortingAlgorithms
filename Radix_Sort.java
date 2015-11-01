/**
 * @author Sanjay Gandhi
 * 
 *         Radix sort is a non-comparative integer sorting algorithm that sorts
 *         data with integer keys by grouping keys by the individual digits
 *         which share the same significant position and value. A positional
 *         notation is required, but because integers can represent strings of
 *         characters (e.g., names or dates) and specially formatted floating
 *         point numbers, radix sort is not limited to integers.
 * 
 *         Family: Bucket. Space: 10 Buckets with at most n integers per bucket.
 *         Stable: True.
 * 
 *         Average case = O(n*k) Worst case = O(n*k) Best case = O(n*k)
 *         Variables: n - number of digits and k - avg bucket size
 *
 */

public class Radix_Sort {

	public static void sort(int[] Array) {
		int maxValue = findMax(Array);
		int exp = 1;
		while ((maxValue / exp) > 0) {
			Array = countingSort(Array, exp);
			exp *= 10;
		}

		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (int i = 0; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
	}

	// Counting Sort with number of buckets = 10 , contrary to counting sort
	// where buckets length = maxvalue
	public static int[] countingSort(int[] Array, int exp) {

		int[] buckets = new int[10];
		int[] temp = new int[Array.length];

		// Calculate each Bucket size
		for (int i = 0; i < Array.length; i++)
			buckets[(Array[i] / exp) % buckets.length]++;

		// Update each bucket value
		for (int i = 1; i < buckets.length; i++)
			buckets[i] += buckets[i - 1];

		// Generate Sorted Array
		for (int i = Array.length - 1; i >= 0; i--) {
			int index = (Array[i] / exp) % buckets.length;
			buckets[index]--;
			temp[buckets[index]] = Array[i];
		}

		return temp;
	}

	public static int findMax(int[] Array) {
		int max = Array[0];
		for (int i = 1; i < Array.length; i++)
			if (max < Array[i])
				max = Array[i];
		return max;
	}
	
	public static boolean isSorted(int[] Array){
		for(int i = 1; i < Array.length; i++)
			if( Array[i-1] > Array[i])
				return false;
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] unsortedIntegers = { 877, 567, 3456, 876, 467, 26, 934, 9876, 1,
				4567, 38, 25, 92 };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);
	}
}
