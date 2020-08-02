package problemsolving;

public class ReverseWordsOfString {
	/*
	 * Given a String of length S, reverse the whole string without reversing the
	 * individual words in it. Words are separated by dots.
	 */
	public static String reverseWord(String str) {
		
		String[] strArray = str.split("\\.");
		String reverseWord = "";
		for(int i=strArray.length-1; i>=0; i--) {
			reverseWord = reverseWord+strArray[i];
			if(i!=0) {
				reverseWord =reverseWord+".";
			}
		}
		return reverseWord;
	}
	
	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		System.out.println(reverseWord(str));
	}

}
