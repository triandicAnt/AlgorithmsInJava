package string;

import java.util.Arrays;

public class LexicographicRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "GEEKSQUIZ";
		String s2 = "GFG";
		String s3 = "GEEKSFORGEEKS";
		
		System.out.println(findLexicographicMinimum(s2));
		System.out.println(findLexicographicMinimum(s1));
		System.out.println(findLexicographicMinimum(s3));


	}
	/**
	 * Input:  GEEKSQUIZ
	   Output: EEKSQUIZG

	   Input:  GFG
	   Output: FGG

	   Input:  GEEKSFORGEEKS
	   Output: EEKSFORGEEKSG
	 */
	
	static String findLexicographicMinimum(String str){
		String strTemp = str + str;
		int n = str.length();
		String [] strArr = new String [n+1];
		// GFGGFG
		for(int i=0; i<=strTemp.length()-n; i++){
//			System.out.println(i + " " + (i+n) + " "+ strTemp.substring(i, i+n));
			strArr[i] = strTemp.substring(i, i+n);
		}
		Arrays.sort(strArr);
		return strArr[0];
	}
}
