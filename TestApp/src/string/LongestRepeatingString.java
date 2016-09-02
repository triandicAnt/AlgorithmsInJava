package string;

import java.util.Arrays;

public class LongestRepeatingString {
	
	/**
	 *  Longest Repeated Substring in GEEKSFORGEEKS is: GEEKS
		Longest Repeated Substring in AAAAAAAAAA is: AAAAAAAAA
		Longest Repeated Substring in ABCDEFG is: No repeated substring
		Longest Repeated Substring in ABABABA is: ABABA
		Longest Repeated Substring in ATCGATCGA is: ATCGA
		Longest Repeated Substring in banana is: ana
		Longest Repeated Substring in abcpqrabpqpq is: ab (pq is another LRS here)
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "GEEKSFORGEEKS";
		String s2 = "AAAAAAAAAA";
		String s3 = "ABCDEFG";
		String s4 = "ABABABA";
		String s5 = "ATCGATCGA";
		String s6 = "banana";
		System.out.println(longestRepeatingString(s1));
		System.out.println(longestRepeatingString(s2));
		System.out.println(longestRepeatingString(s3));
		System.out.println(longestRepeatingString(s4));
		System.out.println(longestRepeatingString(s5));
		System.out.println(longestRepeatingString(s6));
	}
	
	static String longestRepeatingString(String str){
		
		int n = str.length();
		
		// generate all suffix substrings for each character of that string
		String [] suffixArray = new String[n];
		for(int i = 0; i<n ; i++){
			suffixArray[i] = str.substring(i,n);
		}
		
		// sort the suffix array
		Arrays.sort(suffixArray);
		
		// for each consecutive pair of strings in suffixArray find the largest common prefix
		String lrs = "";
		for(int i = 0; i<suffixArray.length-1; i++){
			String temp = largestCommonPrefix(suffixArray[i], suffixArray[i+1]);
			if(temp.length()>lrs.length()){
				lrs = temp;
			}
		}
		return lrs;
	}
	
	// find largest common prefix in a string pair
	static String largestCommonPrefix(String a, String b){
		int n = Math.min(a.length(), b.length());
		for(int i=0; i<n; i++){
			if(a.charAt(i) != b.charAt(i))
				return a.substring(0, i);
		}
		return a.substring(0,n);
	}

}
