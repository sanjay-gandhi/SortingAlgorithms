/**
 * @author Sanjay Gandhi
 * 
 *         An American flag sort is an efficient, in-place variant of radix sort
 *         that distributes items into hundreds of buckets. Non-comparative
 *         sorting algorithms such as radix sort and American flag sort are
 *         typically used to sort large objects such as strings, for which
 *         comparison is not a unit-time operation.
 * 
 *         In contrast to comparison-based sorting algorithms, such as
 *         quicksort, American flag sort can only sort integers (or objects that
 *         can be interpreted as integers). In-place sorting algorithms,
 *         including American flag sort, run without allocating a significant
 *         amount of memory beyond that used by the original array. This is a
 *         significant advantage, both in memory savings and in time saved
 *         copying the array.
 * 
 *         American flag sort works by successively dividing a list of objects
 *         into buckets based on the first digit of their base-N representation
 * 
 *         Family: Bucket. Space: In-place. Stable: False.
 * 
 *         Average case = O(n*k/d) Worst case = O(n*k/d) Best case = O(n*k/d)
 *         NOTE: n is the number of digits and k is the average bucket size
 *
 */
public class AmericanFlag_Sort {
	
	private static final int number_of_buckets = 10;

	public static void sort(int[] Array) {
		int maxNumberOfDigits = findMaxDigits(Array);		
		int divisor = 1;
		for(int i = 0; i < maxNumberOfDigits-1; i++)
			divisor *= 10;
		
		sort(Array, 0, Array.length, divisor);
		
		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (int i = 0; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
	}
	
	public static void sort(int[] Array, int start, int end, int divisor){
		
		//First Pass : Counting the number of objects belonging to each bucket
		int[] count = new int[number_of_buckets];
		int[] offset = new int[number_of_buckets];
		int digit = 0;
		for(int i = start; i < end; i++){
			digit = getDigit(Array[i], divisor);
			count[digit]++;
		}
		offset[0] = start;
		for(int i = 1; i < number_of_buckets; i++)
			offset[i] = count[i-1] + offset[i-1];
		
		//Second Pass : Swaps each object into place
		for(int i = 0; i < number_of_buckets; i++)
			while( count[i] > 0){
				int origin = offset[i];
				int from = origin;
				int n = Array[from];
				Array[from] = -1;
				do{
					digit = getDigit(n, divisor);
					int to = offset[digit]++;
					count[digit]--;	
					int temp = Array[to];
					Array[to] = n;
					n = temp;
					from = to;
				}while(from != origin);
			}
		
		//Sort each bucket
		if(divisor > 1){
			int from, to;
			for(int i = 0; i < number_of_buckets; i++){
				if(i > 0)
					from = offset[i-1];
				else	
					from = start;
				to = offset[i];
				if(to - from > 1)
					sort(Array, from, to, divisor/10);
			}
		}
	}
	
	public static int findMaxDigits(int[] Array) {
		int max = 0;
		for(int i = 0; i < Array.length; i++){
			if(max < ((int) Math.log10(Array[i])+1))
				max = (int) Math.log10(Array[i])+1;
		}
		return max;
	}
	
	public static int getDigit(int number, int divisor){
		return (number/divisor) % 10;
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
