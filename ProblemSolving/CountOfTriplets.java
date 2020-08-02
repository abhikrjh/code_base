package problemsolving;

import java.util.ArrayList;
import java.util.List;

// Given an array of distinct integers.
// The task is to count all the triplets such that sum of two elements equals the third element.

public class CountOfTriplets {

	public static int countTriplet(String str) {
	
		List<Integer> list = new ArrayList<Integer>();
		String[] strArray = str.split(" ");
		for(int i=0; i<strArray.length; i++) {
			list.add(Integer.parseInt(strArray[i]));
		}
		
		int count = 0; int sum = 0;
		for(int j=0; j< list.size(); j++) {
			int num1 = list.get(j);
			for(int k=j+1; k<list.size(); k++) {
				int num2 = list.get(k);
				if(list.contains(num1+num2)) {
					count = count+1;
				}
			}
			
			
		}
		if(count == 0) {
			count = -1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str ="1 5 3 2";
		//String str = "3 2 7";
        System.out.println(countTriplet(str));
	}
	
}
