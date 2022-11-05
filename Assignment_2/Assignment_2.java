import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Assignment_2 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 17, 3, 19, 6, 5, 9 };

		System.out.println(Arrays.toString(arr));

//		bubbleSort(arr);
//		System.out.println("Bubble sort: " + Arrays.toString(arr));

//		selectionSort(arr);
//		System.out.println("Selection sort: " + Arrays.toString(arr));

//		insertionSort(arr);
//		System.out.println("Insertion sort: " + Arrays.toString(arr));

//		mergeSort(arr, 0, arr.length - 1);
//		System.out.println("Merge sort: " + Arrays.toString(arr));

//		quickSort(arr, 0, arr.length - 1);
//		System.out.println("Quick sort: " + Arrays.toString(arr));

		// For duplicates
//		findDuplicates(arr);

		// For Subset
		int[] arr1 = { 2, 3, 6 };
		System.out.println(isSubset(arr, arr1, arr.length, arr1.length));
	}

	public static void findDuplicates(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i : arr) {

			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}

		boolean flag = false;
		TreeSet<Integer> ts = new TreeSet<>(map.keySet());
		for (int i : ts) {

			if (map.get(i) > 1) {
				flag = true;
				System.out.println(i);
			}
		}
		if (!flag)
			System.out.println("No duplicates");
		return;
	}

	public static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, (j + 1), arr);
					flag = true;
				}
			}
			if (!flag)
				break;
		}
	}

	public static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[minIndex] > arr[j])
					minIndex = j;
			swap(i, minIndex, arr);
		}
	}

	public static void insertionSort(int[] arr) {

		for (int i = 0; i < (arr.length - 1); i++) {

			for (int j = i + 1; j > 0; j--) {

				if (arr[j] < arr[j - 1])
					swap(j, j - 1, arr);
				else // to decrease it's complexity by O(N) if sorted.
					break;
			}
		}
	}

	public static void mergeSort(int[] arr, int start, int end) {

		if (start >= end)
			return;

		int mid = start + (end - start) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, end, mid);
	}

	public static void merge(int[] arr, int left, int right, int mid) {

		// finding size
		int size1 = mid - left + 1;
		int size2 = right - mid;

		// declare array
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];

		// adding values
		int i = 0;
		int j = left;
		while (j <= mid)
			arr1[i++] = arr[j++];

		// adding values
		i = 0;
		j = mid + 1;
		while (j <= right)
			arr2[i++] = arr[j++];

		// adding sorted values to the original array
		i = 0;
		j = 0;
		int k = left;
		while (i < size1 && j < size2) {
			if (arr1[i] <= arr2[j])
				arr[k++] = arr1[i++];
			else
				arr[k++] = arr2[j++];
		}

		while (i < size1)
			arr[k++] = arr1[i++];

		while (j < size2)
			arr[k++] = arr2[j++];
	}

	public static void quickSort(int[] arr, int start, int end) {

		if (start < end) {
			int pivotPartition = partition(arr, start, end);
			quickSort(arr, start, pivotPartition - 1);
			quickSort(arr, pivotPartition + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {

		int pivotIndex = start;
		int pivot = arr[pivotIndex];

		int s = start;
		int e = end;
		while (start < end) {

			while (start <= e && arr[start] <= pivot)
				start++;

			while (end >= s && arr[end] > pivot)
				end--;

			if (start < end)
				swap(start, end, arr);
		}
		swap(pivotIndex, end, arr);
		return end;
	}

	public static String isSubset(int a1[], int a2[], int n, int m) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : a1) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}

		for (int i : a2) {
			if (map.containsKey(i)) {
				int x = map.get(i);
				if (x == 1)
					map.remove(i);
				else
					map.put(i, --x);
			} else
				return "No";
		}
		return "Yes";
	}

	public static void swap(int i, int j, int[] arr) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
