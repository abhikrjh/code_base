package problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Given an unsorted array A of size N of non-negative integers, 
find a continuous sub-array which adds to a given number S.
*/
public class SubArrayWithGivenSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();

		while (sc.hasNextLine()) {
			list.add(sc.nextLine());
		}

		int noOFTestCases = 0;
		int counter = 1;
		int size = 0;
		int sum = 0;
		String sizeAndSum = "";
		String array = "";

		for (String ele : list) {

			String x = ele;
			if (x.length() != 1) {

				if (counter % 2 == 1) {
					sizeAndSum = x;

				} else if (counter % 2 == 0) {
					array = x;

					String[] sizeSumArray = sizeAndSum.split(" ");

					size = Integer.parseInt(sizeSumArray[0]);
					sum = Integer.parseInt(sizeSumArray[1]);

					String[] mainStringArray = array.split(" ");
					int[] mainIntArray = Arrays.stream(mainStringArray).mapToInt(Integer::parseInt).toArray();

					// logic
					int j = 0;
					int requiredSum = 0;
					label: for (int i = j; i < mainStringArray.length; i++) {
						if (i < mainStringArray.length) {
							requiredSum = requiredSum + Integer.parseInt(mainStringArray[i]);

							if (requiredSum == sum) {
								System.out.println("");
								System.out.println(j + 1 + " " + (i + 1));
								break;
							}
						}
						if (i == mainStringArray.length - 1) {
							i = j;
							j = j + 1;
							requiredSum = 0;
							continue label;
						}

					}

				}
				counter++;
			}
		}

	}

}
