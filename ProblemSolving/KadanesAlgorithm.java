package problemsolving;

//Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
/*
   input = 1 2 3 -2 5 
   o/p =  9
   input = -1 -2 -3 -4
   o/p = -1
*/
public class KadanesAlgorithm {

	public static int maximumSum(int[] arr) {
		int sum = 0;
		int maxSum = 0;
		if (arr[0] < 0) {
			sum = arr[0];
			maxSum = arr[0];
		}

		for (int i : arr) {
			sum = sum + i;

			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {

		 //int[] arr = new int[] {-1 ,-2 ,-3 ,-4};
		 int[] arr = new int[] { 1, 2, 3, -2, 5 };

		int maxSum = maximumSum(arr);

		System.out.println(maxSum);
	}

}
