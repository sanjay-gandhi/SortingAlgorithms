/**
 * @author Sanjay Gandhi
 * 
 *         Insertion sort is a simple sorting algorithm: a comparison sort in
 *         which the sorted array (or list) is built one entry at a time. It is
 *         much less efficient on large lists than more advanced algorithms such
 *         as quicksort, heapsort, or merge sort.
 * 
 *         Family: Insertion. Space: In-place. Stable: True.
 * 
 *         Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 *
 */

public class Insertion_Sort {

	public static <T extends Comparable<T>> void sort(T[] Array) {
		for (int i = 1; i < Array.length; i++) {
			T temp = Array[i];

			// Insert Array[i] in the increasing order of the Array 0...i
			int j;
			for (j = i - 1; j >= 0 && (temp.compareTo(Array[j]) < 0); j--)
				Array[j + 1] = Array[j];
			Array[j + 1] = temp;
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
