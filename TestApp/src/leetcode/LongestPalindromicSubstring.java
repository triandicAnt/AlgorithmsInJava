package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "banana"; // output is anana
		String s1 = "abcdcb"; // output is bcdcb
		System.out.println(LongestPalindrome(s));
		System.out.println(LongestPalindrome(s1));
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
