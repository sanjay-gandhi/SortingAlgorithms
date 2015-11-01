/**
 * @author Sanjay Gandhi
 *
 *         Bubble sort is a simple sorting algorithm that works by repeatedly
 *         stepping through the list to be sorted, comparing each pair of
 *         adjacent items and swapping them if they are in the wrong order. The
 *         pass through the list is repeated until no swaps are needed, which
 *         indicates that the list is sorted.
 * 
 *         Family: Exchanging. Space: In-place. Stable: True.
 * 
 *         Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 * 
 */

public class Bubble_Sort {

	public static <T extends Comparable<T>> void sort(T[] Array) {

		boolean swapped = true;
		int length = Array.length;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < length; i++) {
				if (Array[i - 1].compareTo(Array[i]) > 0) {
					swap(i - 1, i, Array);
					swapped = true;
				}
			}
			length--;
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

	public static <T extends Comparable<T>> void swap(int index1, int index2,
			T[] Array) {
		T temp = Array[index1];
		Array[index1] = Array[index2];
		Array[index2] = temp;
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
		String[] unsortedStrings = { "Sanjay", "S", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);

		System.out.print("Sorted Strings : ");
		sort(unsortedStrings);

	}

}
