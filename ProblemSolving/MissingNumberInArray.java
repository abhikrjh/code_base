package problemsolving;

// Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, 
// the missing number is to be found.

public class MissingNumberInArray {

	public static int missingNumber(int[] nMinusOneSizeArray, int n) {

		int sum1 = (n * (n + 1)) / 2;
		int sum2 = sumOfArray(nMinusOneSizeArray);

		return sum1 - sum2;

	}

	public static int sumOfArray(int[] nMinusOneSizeArray) {
		int sum = 0;
		for (int ele : nMinusOneSizeArray) {
			sum = sum + ele;
		}
		return sum;
	}

	public static void main(String[] args) {
        int n = 10;
		int[] nMinusOneSizeArray = new int[] {1, 2, 3, 4, 5, 6 ,7, 8, 10};
		
		int missingNumber = missingNumber(nMinusOneSizeArray, n);
		
		System.out.println(missingNumber);
		
	}

}
