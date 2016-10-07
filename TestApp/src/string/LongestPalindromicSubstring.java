package string;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "banana"; // output is anana
		System.out.println(lps(s));
		String s1 = "abcdcb"; // output is bcdcb
		System.out.println(lps(s1));
		System.out.println(LongestPalindrome(s));
		System.out.println(LongestPalindrome(s1));

	}
	
	static String lps(String s){
		int n = s.length();
		int startingIndex = Integer.MIN_VALUE;
		int maxLength = 0;
		boolean[][] b = new boolean[n][n];
		for(int i = 0; i<n ; i++){
			b[i][i] = true;
			maxLength = 1;
			startingIndex = i;
		}
		for(int i = 1; i<n; i++){
			if(s.charAt(i-1) == s.charAt(i)){
				b[i-1][i] = true;
				maxLength = 2;
				startingIndex = i-1;
			}
		}
		for(int curr_len = 3; curr_len<=n; curr_len++){
			for(int i = 0; i<n-curr_len+1; i++){
				int j = i+curr_len-1;
				if(s.charAt(i) == s.charAt(j) && b[i+1][j-1]){
					b[i][j] = true;
					maxLength = curr_len;
					startingIndex = i;
				}
			}
		}
		return s.substring(startingIndex, startingIndex+maxLength);
		
	}
/**
 * leet code
 */
	

	 public static String LongestPalindrome(final String input) {

	     PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
	    	 @Override
	    	  public int compare(String i, String j){
	   		  if(i.length()>j.length())
	   			  return -1;
	   		  if(i.length()<j.length())
	   			  return 1;
	   		  else 
	   			  return 0;
	   	  }
	     });
	     for (int i = 0; i < input.length(); i++) {
	         // expanding even length palindromes:
	         expandPalindromes(pq,input,i,i+1);
	         // expanding odd length palindromes:
	         expandPalindromes(pq,input,i,i);
	     } 
	     return pq.poll();
	  }

	  public static void expandPalindromes(final PriorityQueue<String> result, final String s, int i, int j) {
	      while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
	            result.offer(s.substring(i,j+1));
	            i--; j++;
	      }
	  }
}
