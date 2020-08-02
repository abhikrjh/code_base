package problemsolving;

/*
Given a string s, recursively remove adjacent duplicate characters from the string s. 
The output string should not have any adjacent duplicates.

input - geeksforgeek
  o/p - gksforgk
input - acaaabbbacdddd
  o/p - acac

*/
public class RecursivelyRemoveAllAdjacentDuplicates {

	public static String removeAdjacentDuplicate1(String input) {

		String output = "";

		for (int i = 0; i < input.length(); i++) {

			if (i == input.length() - 1) {
				output = output + input.charAt(i);
				return output;
			}

			if (input.charAt(i) == input.charAt(i + 1)) {
				while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
					i++;
				}
			} else {
				output = output + input.charAt(i);
			}
		}
		return output;
	}

	public static String removeAdjacentDuplicate(String input) {

		String output = "";
		char[] charArray = input.toCharArray();
		int i = 0;

		while (i < charArray.length) {

			if (i == charArray.length - 1) {
				return output + charArray[i];
			}

			if (charArray[i] != charArray[i + 1]) {
				output += charArray[i];
				i++;
			} else if (charArray[i] == charArray[i + 1]) {
					while (charArray[i] == charArray[i + 1]) {
						i++;
						if (i == charArray.length - 1) {
						   	return output;
						}
					}
				i++;
			}
		}

		return output;
	}

	public static void main(String[] args) {

		    String input = "geeksforgeeek";
		 // String input = "acaaabbbacdddd";
		System.out.println(removeAdjacentDuplicate(input));

	}

}
