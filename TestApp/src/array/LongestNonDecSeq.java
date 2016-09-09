package array;

import java.util.Arrays;

public class LongestNonDecSeq {
	
	public static void main(String[] args) {
		int a [] = new int [] {2,1,3,5,8,6,7};
		//System.out.println(lonNonDecSeq(a));
		int b [] = new int [] {5, 3, 4, 8, 6, 7};
		//System.out.println(lonNonDecSeq(b));
		
		int [] c = new int []{-1,2,3,-1,1};
		// 0,-1,0,-1,0
		printDuplicates(c);
		String s = "Sudhansu";
		System.out.println(s.substring(7,8));
	}
	
	/**
	 * given an array find the longest non decreasing sequence
	 * e.g. 2,1,3,5,8,6,7
	 * gives 5
	 */
	
	static int lonNonDecSeq(int [] a){
		if(a.length == 0 || a.length == 1)
			return a.length;
		int [] temp = new int [a.length];
		Arrays.fill(temp, 1);
		for(int i = 1; i<a.length;i++){
			if(a[i-1]<a[i]){
				temp[i] = temp[i-1] +1;
			}else{
				temp[i] = temp[i-1];
			}
		}
		return temp[a.length-1];
	}
	/**
	 * arr contains 0 to n-1 elements and has length n
	 * @param arr
	 */
	static void printDuplicates(int [] arr){
		for(int i = 0; i< arr.length; i++){
			if(arr[Math.abs(arr[i])] >0){
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];

			}
			else{
				System.out.println(Math.abs(arr[i]));
			}
		}
		
	}
}
