/**
 * Class TestHeapSort
 *
 * Take any unsorted int array and sorts it decending order using heapsort
 * 
 * @author Ahmad Chaudhry
 * @version 2018.04.05
 */
public class TestHeapSort {

	// global variable for n  
	static int n;
 
	/**
	 * Main heapsort method to sort through array
	 * 
	 * @param array
	 *            the array being sorted
	 */
	public static int[] heapSort(int[] array) {
		// build the heap (rearrange the array)
		for (int i = n / 2; i >= 0; i--) {
			// call maxheap to heap-rebuild subtree
			maxheap(array, i);
		}
		for (int i = n; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			n--;
			maxheap(array, 0);
		}
		return array;
	}

	/**
	 * Heap-Rebuild subtree rooted to node i
	 * 
	 * @param array
	 *            the array being sorted
	 * @param i
	 *            subtree rooted with node i
	 */
	public static void maxheap(int[] array, int i) {
		// left side
		int left = 2 * i;
		// right side
		int right = (2 * i) + 1;
		// largest is root
		int max = i;

		// left child is larger than root
		if (left <= n && array[left] > array[max])
			// max is left child
			max = left;
		// right child is larger than largest
		if (right <= n && array[right] > array[max])
			// max is right child
			max = right;
		// largest is not the root
		if (max != i) {
			// swap both
			int temp = array[i];
			array[i] = array[max];
			array[max] = temp;
			// recursively call maxheap
			maxheap(array, max);
		}
	}
	/**
	 * Main method used to call other methods for testing
	 * 
	 * @param args
	 *            contains the command-line arguments passed to the Java program
	 *            upon invocation
	 */
	public static void main(String[] args) {
		int[] array = { 10, 9, 6, 3, 2, 5 };
		n = array.length - 1;
		System.out.println("The Unsorted array: ");
		for (int num : array)
			System.out.print(num + " ");
		int[] heap = heapSort(array);
		System.out.println("\nThe Sorted array: ");
		for (int num : heap)
			System.out.print(num + " ");
	}
}
