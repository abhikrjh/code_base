package problemsolving;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome {

	public static String longestPalindrome(String input) {
		String longestPalindrome = "";
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String str = "";
		int j = 0;
		label: for (int i = j; i < input.length(); i++) {

			char c = input.charAt(i);
			str = str + c + "";
			boolean isPalindrome = isPalindrome(str);
			if (isPalindrome) {
				map.put(str, str.length());
			}
			if (i == input.length() - 1) {
				j = j + 1;
				i = j;
				str = "";
				continue label;
			}
		}

		Map.Entry<String, Integer> entryWithMaxValue = null;
		for (Entry<String, Integer> currentEntry : map.entrySet()) {

			if (null == entryWithMaxValue || currentEntry.getValue().compareTo(entryWithMaxValue.getValue()) > 0) {
				entryWithMaxValue = currentEntry;
			}

		}
		if (null != entryWithMaxValue) {
			longestPalindrome = entryWithMaxValue.getKey();
		}
		return longestPalindrome;
	}

	public static boolean isPalindrome(String str) {
		char[] charArr = str.toCharArray();
		for (int i = 0; i < charArr.length / 2; i++) {
			if (charArr[i] != charArr[charArr.length - (i + 1)]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		//String input = "aaaabbaa";
		
		String input ="rfkqyuqfjkxy";

		System.out.println(longestPalindrome(input));
	}

}
