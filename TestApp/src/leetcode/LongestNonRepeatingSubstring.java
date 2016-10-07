package leetcode;

import java.util.HashSet;

public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println(findLengthOfLongest("stackoverflow"));
	    System.out.println(findLengthOfLongest("dvdf"));

	}
	public static int findLengthOfLongest(String s){
		HashSet<Character> set = new HashSet<Character>();
		int count=0, i=0 ,j=0;
		int n = s.length();
		while(i<n && j<n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				count = Math.max(count, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return count;
	}
}
