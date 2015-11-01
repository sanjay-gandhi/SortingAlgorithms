/**
 * @author Sanjay
 *
 *         Merge sort is an O(n log n) comparison-based sorting algorithm. Most
 *         implementations produce a stable sort, which means that the
 *         implementation preserves the input order of equal elements in the
 *         sorted output.
 * 
 *         Family: Merging. Space: In-place. Stable: True.
 * 
 *         Average case = O(n*log n) Worst case = O(n*log n) Best case = O(n*log
 *         n)
 */
public class Merge_Sort {

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] Array) {
		T[] temp = (T[]) new Comparable[Array.length];
		mergeSort(Array, temp, 0, Array.length - 1);
		
		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (int i = 0; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
	}

	public static <T extends Comparable<T>> void mergeSort(T[] Array, T[] temp, int left,
			int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(Array, temp, left, center);
			mergeSort(Array, temp, center + 1, right);
			merge(Array, temp, left, center, right);
		}
	}

	public static <T extends Comparable<T>> void merge(T[] Array, T[] temp, int left,
			int center, int right) {

		for (int i = left; i <= right; i++)
			temp[i] = Array[i];
		
		int i = left;
		int j = center + 1;

		for (int k = left; k <= right; k++) {
			if( (j > right) || ( (i <= center) && (temp[i].compareTo(temp[j]) <= 0) ) )
				Array[k] = temp[i++];
			else
				Array[k] = temp[j++];
		}
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] Array){
		for(int i = 1; i < Array.length; i++)
			if( Array[i-1].compareTo(Array[i]) > 0)
				return false;
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] unsortedIntegers = { 2, 6, 4, 1, 8, 9, 3, 5, 0, 7, 10, 5 };
		String[] unsortedStrings = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);

		System.out.print("Sorted Strings : ");
		sort(unsortedStrings);

	}

}
