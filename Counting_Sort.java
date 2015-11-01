/**
 * @author Sanjay Gandhi
 * 
 *         Counting sort is an algorithm for sorting a collection of objects
 *         according to keys that are small integers; that is, it is an integer
 *         sorting algorithm. It operates by counting the number of objects that
 *         have each distinct key value, and using arithmetic on those counts to
 *         determine the positions of each key value in the output sequence.
 * 
 *         Family: Counting. Space: An Array of length n. Stable: True.
 * 
 *         Average case = O(n+r) Worst case = O(n+r) Best case = O(n+r)
 * 
 *         Variables : r - range of numbers (0 to r). Assume r = 10
 * 
 * 
 *
 */
public class Counting_Sort {

	public static void sort(int[] Array) {
		int maxValue = findMax(Array);
		int[] buckets = new int[maxValue + 1];
		int[] temp = new int[Array.length];
		int exp = 1;
		
		//Calculate each Bucket size
		for (int i = 0; i < Array.length; i++)
			buckets[(Array[i]/exp) % buckets.length]++;
		
		//Update each bucket value
		for(int i = 1; i < buckets.length; i++)
			buckets[i] += buckets[i-1];
		
		//Generate Sorted Array
		for (int i = Array.length - 1; i >= 0; i--) {
			int index = (Array[i]/exp) % buckets.length ;
			buckets[index]--;
			temp[buckets[index]] = Array[i];
		}
		
		for (int i = 0; i < Array.length; i++)
			Array[i] = temp[i];

		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (int i = 0; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
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

		int[] unsortedIntegers = { 6, 4, 8, 2, 5, 9, 3, 17, 1, 0, 8 };
		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);
	}
}
