package com.corejava;

//Write a function to find out longest palindrome in a given string?

public class LongestPalindrome {

    public String longestPalindrome(String str) {
        String longest = "";
        char[] charArray = str.toCharArray();
        longest = longest(str, charArray);
        return longest;
    }

    public String longest(String str, char[] charArray) {
        String longest="";
        int currentFirstIndex = 0;
        int currentLastIndex = 0;
        boolean matchStarts = false;
        for (int i = 0; i < charArray.length - 1; i++) {
            if(longest.isEmpty()){
                longest = str.substring(currentFirstIndex, currentLastIndex+1);
            }else{
                String current = str.substring(currentFirstIndex, currentLastIndex+1);
                if(longest.length()<current.length()){
                    longest = current;
                }
            }
            int tempI = i;
            for (int j = charArray.length - 1; j > i; j--) {
                if (charArray[tempI] == charArray[j]) {
                    if(!matchStarts){
                        currentFirstIndex = tempI;
                        currentLastIndex = j;
                    }
                    tempI++;
                    matchStarts = true;
                } else {
                    currentFirstIndex = 0;
                    currentLastIndex = 0;
                    matchStarts = false;
                }

            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String str = lp.longestPalindrome("abcmalayalamdc");
        System.out.println(str + " is the longest palindrome ");
    }

}
