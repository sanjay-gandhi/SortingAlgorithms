/**
 * @author Sanjay Gandhi
 * 
 *         Quicksort is a sorting algorithm which, on average, makes O(n*log n)
 *         comparisons to sort n items. In the worst case, it makes O(n^2)
 *         comparisons, though this behavior is rare. Quicksort is often faster
 *         in practice than other algorithms.
 * 
 *         Family: Divide and conquer. Space: In-place. Stable: False.
 * 
 *         Average case = O(n) Worst case = O(n^2) Best case = O(n*log n)
 *
 */
public class Quick_Sort {

	public static <T extends Comparable<T>> void sort(T[] Array) {
		quickSort(Array, 0, Array.length-1);
		
		if(isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");
		
		//Display the sorted list
		for (int i = 0; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
	}

	public static <T extends Comparable<T>> void quickSort(T[] Array, int left,
			int right) {
		if (left < right) {
			// Random random = new Random();
			// int pivot = left + random.nextInt(right-left);
			// swap(left, pivot, Array);
			int split = partition(Array, left, right);
			quickSort(Array, left, split - 1);
			quickSort(Array, split + 1, right);
		}
	}

	public static <T extends Comparable<T>> int partition(T[] Array, int left,
			int right) {

		T pivot = Array[left];
		int l = left + 1;
		int r = right;
		boolean condition = true;
		
		while (condition) {
			while ((l <= r) && (Array[l].compareTo(pivot) <= 0))
				l++;
			while ((l <= r) && (Array[r].compareTo(pivot) > 0))
				r--;
			if (l < r)
				swap( l, r, Array);
			else
				condition = false;
		}
		swap(left, r, Array);
		return r;
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
