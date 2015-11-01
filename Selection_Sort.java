/**
 * @author Sanjay
 * 
 *         Selection sort is a sorting algorithm, specifically an in-place
 *         comparison sort. It has O(n2) time complexity, making it inefficient
 *         on large lists, and generally performs worse than the similar
 *         insertion sort. Selection sort is noted for its simplicity, and it
 *         has performance advantages over more complicated algorithms in
 *         certain situations, particularly where auxiliary memory is limited.
 * 
 *         Family: Exchanging. Space: In-place. Stable: True.
 * 
 *         Average case = O(n^2) Worst case = O(n^2) Best case = O(n)
 * 
 */

public class Selection_Sort {
	public static <T extends Comparable<T>> void sort(T[] Array) {

		for (int i = 0; i < Array.length; i++) {
			int min = i;
			for (int j = i + 1; j < Array.length; j++) {
				if (Array[min].compareTo(Array[j]) > 0) {
					min = j;
				}
			}
			swap(i, min, Array);
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
		String[] unsortedStrings = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);

		System.out.print("Sorted Strings : ");
		sort(unsortedStrings);

	}

}
