package problemsolving;

/*
   Given a sorted array of positive integers. 
   Your task is to rearrange  the array elements alternatively 
   i.e first element should be max value, second should be min value, 
   third should be second max, fourth should be second min and so on...
*/
public class ReArrangeArrayAlternatively {

	public static int[] alternateMaxMinArray(int[] arr) {

		int[] alternateMaxMinArray = new int[arr.length];
		
		int small = 0; int large = arr.length-1;

		boolean flag = true;

		for (int i = 0; i < arr.length; i++) {

			if (flag) {
				alternateMaxMinArray[i] = arr[large--];
			} else {
				alternateMaxMinArray[i] = arr[small++];
			}

			flag = !flag;

		}
		return alternateMaxMinArray;
	}

	public static void main(String[] args) {
		
		 int[] arr = new int[] { 1 ,2 ,3, 4, 5, 6 };
		 
		 int[] alternateMaxMinArray = alternateMaxMinArray(arr);
		 
		 for(int i : alternateMaxMinArray) {
			 System.out.print(i+" ");
		 }
		 
		
	}
	
}
