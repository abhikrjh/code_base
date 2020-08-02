package problemsolving;

/*
Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. 
The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
*/
public class MergeTwoArrayWithNoExtraSpace {

	public static int[] mergedSortedArray(int[] arr1, int[] arr2) {

		int len1 = arr1.length;
		int len2 = arr2.length;

		int[] arr3 = new int[len1 + len2];

		int i = 0; // this pointer will be used for first array
		int j = 0; // this pointer will be used for second array
		int k = 0; // this pointer will be used for merged array

		while (i < len1 && j < len2) {

			if (arr1[i] < arr2[j]) {
				arr3[k++] = arr1[i++];
			} else {
				arr3[k++] = arr2[j++];
			}

		}

		while (i < len1) {
			arr3[k++] = arr1[i++];
		}

		while (j < len2) {
			arr3[k++] = arr2[j++];
		}

		return arr3;
	}

	public static void main(String[] args) {

		int[] arr1 = new int[] { 1, 3, 5, 7 };
		int[] arr2 = new int[] { 0, 2, 6, 8, 9 };

		int[] mergedArray = mergedSortedArray(arr1, arr2);

		for (int i : mergedArray) {
			System.out.print(i + " ");
		}

	}

}
