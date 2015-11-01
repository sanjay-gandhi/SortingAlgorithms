/**
 * @author Sanjay Gandhi
 * 
 *         Heapsort is a comparison-based sorting algorithm to create a sorted
 *         array (or list), and is part of the selection sort family. Although
 *         somewhat slower in practice on most machines than a well-implemented
 *         quicksort, it has the advantage of a more favorable worst-case O(n
 *         log n) runtime.
 * 
 *         Family: Selection. Space: In-place. Stable: False.
 * 
 *         Average case = O(n*log n) Worst case = O(n*log n) Best case = O(n*log
 *         n)
 *
 */
public class Heap_Sort {

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] unsorted) {
		T[] Array = (T[]) new Comparable[unsorted.length+1];
		for(int i = 1; i < Array.length; i++)
			Array[i] = unsorted[i-1];
		buildMaxHeap(Array);
		for (int i = Array.length - 1; i >= 2; i--) {
			swap(i, 1, Array);
			maxHeapify(Array, 1, i - 1);
		}

		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (int i = 1; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
	}

	public static <T extends Comparable<T>> void buildMaxHeap(T[] Array) {
		int size = Array.length - 1;
		for (int i = size / 2; i >= 1; i--)
			maxHeapify(Array, i, size);
	}

	public static <T extends Comparable<T>> void maxHeapify(T[] Array, int i,
			int size) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest;

		if ((left <= size) && Array[left].compareTo(Array[i]) > 0)
			largest = left;
		else
			largest = i;
		if ((right <= size) && Array[right].compareTo(Array[largest]) > 0)
			largest = right;

		// Checks if parent is the largest node
		if (largest != i) {
			swap(largest, i, Array);
			maxHeapify(Array, largest, size);
		}
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

		Integer[] unsortedIntegers = { 6, 4, 8, 2, 5, 9, 3, 7, 1, 0, 8 };
		String[] unsortedStrings = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);

		System.out.print("Sorted Strings : ");
		sort(unsortedStrings);

	}

}
