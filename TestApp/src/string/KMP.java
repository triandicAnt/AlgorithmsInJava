package string;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdabca";
		String s1 = "acacabacacabacacac";
		System.out.println(Arrays.toString(prefixArray(s.toCharArray())));
		System.out.println(Arrays.toString(prefixArray(s1.toCharArray())));
		
		 String str = "abcxabcdabcdabcy";
		 String pattern = "abcdabcya";
		 System.out.println(KMPString(str.toCharArray(), pattern.toCharArray()));
		 String str1 = "acacabacacabacacac";
		 String pattern1 = "bacacab";
		 System.out.println(KMPString(str1.toCharArray(), pattern1.toCharArray()));

	}
	
	// build prefix array
	
	static int [] prefixArray(char [] pattern){
		int n = pattern.length;
		int[] lps = new int[n];
		int j = 0;
		for(int i = 1; i<n;){
			if(pattern[i] == pattern[j]){
				lps[i] = j+1;
				i++;
				j++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	static boolean KMPString(char[] str, char [] pattern){
		int []lps = prefixArray(pattern);
		int j = 0;
		int i = 0;
		while(i<str.length && j<pattern.length){
			if(str[i] == pattern[j]){
				i++;
				j++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}
				else{
					i++;
				}
			}
		}
		return(j == pattern.length);
	}

}
