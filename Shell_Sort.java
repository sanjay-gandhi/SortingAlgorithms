import java.util.ArrayList;

/**
 * @author Sanjay
 * 
 *         Shellsort, also known as Shell sort or Shell's method, is an in-place
 *         comparison sort. It generalizes an exchanging sort, such as insertion
 *         or bubble sort, by starting the comparison and exchange of elements
 *         with elements that are far apart before finishing with neighboring
 *         elements. Starting with far apart elements can move some out-of-place
 *         elements into position faster than a simple nearest neighbor
 *         exchange. Family: Exchanging. Space: In-place. Stable: False.
 * 
 *         Average case = depends on the gap Worst case = O(n * log^2 n) Best
 *         case = O(n)
 *
 */
public class Shell_Sort {

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] Array) {

		int gap = 5;
		ArrayList<T>[] shells = new ArrayList[gap];

		// Initialize each shell
		for (int i = 0; i < gap; i++)
			shells[i] = new ArrayList<T>();

		// Populate each shell
		for (int i = 0; i < Array.length; i++)
			shells[i % gap].add(Array[i]);

		// Sort each shell
		for (int i = 0; i < gap; i++)
			insertionSortList(shells[i]);

		// Replace the array with the sorted shell
		for (int i = 0; i < gap; i++) {
			int size = shells[i].size();
			int j = 0;
			while (size > 0) {
				Array[j * 5 + i] = shells[i].get(j);
				j++;
				size--;
			}
		}

		// Insertion Sort the Array
		insertionSortArray(Array);

		if (isSorted(Array))
			System.out.println("Sorted !!! ");
		else
			System.out.println(" Not Sorted !! ");

		// Display the sorted list
		for (int i = 0; i < Array.length; i++)
			System.out.print(" " + Array[i]);
		System.out.println();
	}

	public static <T extends Comparable<T>> void insertionSortList(
			ArrayList<T> list) {
		int size = list.size();
		for (int i = 1; i < size; i++) {
			T temp1 = list.get(i);
			int j;
			for (j = i - 1; j >= 0; j--) {
				T temp2 = list.get(j);
				if (temp1.compareTo(temp2) < 0)
					list.set(j + 1, temp2);
				else
					break;
			}
			list.set(j + 1, temp1);
		}
	}

	public static <T extends Comparable<T>> void insertionSortArray(T[] Array) {
		for (int i = 1; i < Array.length; i++) {
			T temp = Array[i];

			// Insert Array[i] in the increasing order of the Array 0...i
			int j;
			for (j = i - 1; j >= 0 && (temp.compareTo(Array[j]) < 0); j--)
				Array[j + 1] = Array[j];
			Array[j + 1] = temp;
		}
	}

	public static <T extends Comparable<T>> boolean isSorted(T[] Array) {
		for (int i = 1; i < Array.length; i++)
			if (Array[i - 1].compareTo(Array[i]) > 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] unsortedIntegers = { 2, 6, 4, 1, 8, 9, 3, 5, 0, 7, 10, 5, 4,
				11 };
		String[] unsortedStrings = { "Sanjay", "Gandhi", "Abhisek", "Vandana",
				"Pratiksha", "Monica", "Kishan", "Nirmala", "Babulal" };

		System.out.print("Sorted Integers : ");
		sort(unsortedIntegers);

		System.out.print("Sorted Strings : ");
		sort(unsortedStrings);

	}

}
