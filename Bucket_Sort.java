import java.util.ArrayList;
/**
 * @author Sanjay
 * 
 *         Bucket sort, or bin sort, is a sorting algorithm that works by
 *         partitioning an array into a number of buckets. Each bucket is then
 *         sorted individually, either using a different sorting algorithm, or
 *         by recursively applying the bucket sorting algorithm. It is a
 *         distribution sort, and is a cousin of radix sort in the most to least
 *         significant digit flavour. Bucket sort is a generalization of
 *         pigeonhole sort. Bucket sort can be implemented with comparisons and
 *         therefore can also be considered a comparison sort algorithm. The
 *         computational complexity estimates involve the number of buckets.
 * 
 *         Bucket sort works as follows:
 * 
 *         Set up an array of initially empty "buckets". Scatter: Go over the
 *         original array, putting each object in its bucket. Sort each
 *         non-empty bucket. Gather: Visit the buckets in order and put all
 *         elements back into the original array.
 * 
 *         Family: Counting. Space: An Array of length r. Stable: True. Worst
 *         case performance O(n^2) Best case performance Omega(n+k) Average case
 *         performance Theta(n+k) Worst case space complexity O(n * k)
 *
 */
public class Bucket_Sort {

	@SuppressWarnings("unchecked")
	public static void sort(Integer[] Array) {
		int maxDigits = findMaxDigits(Array);
		int msb = (int) Math.pow(10, maxDigits - 1);
		ArrayList<Integer>[] buckets = new ArrayList[10];

		// Initialize each bucket
		for (int i = 0; i < 10; i++)
			buckets[i] = new ArrayList<Integer>();

		// Create each bucket using msb bit
		for (int i = 0; i < Array.length; i++)
			buckets[Array[i] / msb].add(Array[i]);

		// Sort each bucket using insertion sort
		for (int i = 0; i < 10; i++) {
			if (buckets[i].size() > 0)
				insertionSort(buckets[i]);
		}
		int index = 0;
		for (int i = 0; i < 10; i++) {
			if (buckets[i].size() > 0)
				for (int j = 0; j < buckets[i].size(); j++)
					Array[index++] = buckets[i].get(j);
		}

		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (Integer i : Array)
			System.out.print(" " + i);
		System.out.println();
	}

	public static int findMaxDigits(Integer[] Array) {
		int max = 0;
		for (int i = 1; i < Array.length; i++)
			if (max < (Math.log10(Array[i]) + 1))
				max = (int) Math.log10(Array[i]) + 1;
		return max;
	}	
	
	
	public static boolean isSorted(Integer[] Array){
		for(int i = 1; i < Array.length; i++)
			if( Array[i-1] > Array[i])
				return false;
		return true;
	}
	
	public static void insertionSort(ArrayList<Integer> list){
		int size = list.size();
		for(int i = 1; i < size; i++){
			Integer temp1 = (Integer)list.get(i);
			int j;
			for(j = i-1; j >= 0; j--){
				Integer temp2 = (Integer)list.get(j);
				if(temp1.compareTo(temp2) < 0)
					list.set(j+1, temp2);
				else break;
			}
			list.set(j+1, temp1);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] unsortedIntegers = { 5841, 9258, 7268, 5863, 5123, 5369,
				4258, 4693, 3214, 1896, 258, 1258, 1478, 1369, 958 };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);
	}

}
