package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s = {"a","a","b"};
		String [] s1 = {"aaa","aa","aaa"};
		String [] s2 = {"abab","aba","abc"};
		System.out.println(longestCommonPrefix(s2));

	}
	 public static String longestCommonPrefix(String[] strs) {
	        String max  = "";
	        if(strs.length == 1)
	            return strs[0];
	       // Arrays.sort(strs);
	        for(int i=1; i<strs.length; i++){
	            String temp = largestCommonPrefix(strs[i-1],strs[i]);
	            System.out.println("--"+temp);
	            if(i==1)
	            	max = temp;
	            if(temp.length()<max.length())
	                max = temp;
//	            if(temp.equals(""))
//	                max = "";
	        }
	        return max;
	        
	    }
	    // find largest common prefix in a string pair
		public static String largestCommonPrefix(String a, String b){
			int n = Math.min(a.length(), b.length());
			for(int i=0; i<n; i++){
				if(a.charAt(i) != b.charAt(i))
					return a.substring(0, i);
			}
			return a.substring(0,n);
		}
}
