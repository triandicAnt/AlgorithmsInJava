package string;

import java.util.HashSet;

public class WordBreakDP {
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<>();
		dict.add("i");
		dict.add("a");
		dict.add("am");
		dict.add("ace");
		dict.add("Hello");
		dict.add("How");
		dict.add("are");
		dict.add("you");
		
		String str = "iamace";
		String str1 = "Helloyouama";
		System.out.println(checkWordBreak(str, dict));
		System.out.println(checkWordBreak(str1, dict));
	}
	
	/**
	 * Given a string check whether it can be divided into valid dictionary words
	 * @param s
	 * @param dict
	 * @return
	 */
	static boolean checkWordBreak(String s, HashSet<String> dict){
		int len = s.length();
		boolean temp[][] = new boolean[len][len];
		// check for every char in the dict
		for(int i=0; i<len;i++){
			if(dict.contains(String.valueOf(s.charAt(i)))){
				temp[i][i] = true;
			}
		}
		
		// check for 2 to n character length
		int j = 0;
		for(int l =2; l<=len; l++){
			for(int i = 0; i< len-l+1; i++){
				 j = i+l-1;
				 String sub = s.substring(i, j+1);
				 if(dict.contains(sub)){
					 temp[i][j] = true;
					 break;
				 }
				 // check for each word in sub, if any of the combination is true, make temp[i][j] as true
				 for(int k=1;k<sub.length();k++){
					 if(temp[i][i+k-1] == true && temp[i+k][j] == true){
						 temp[i][j] = true;
						 break;
					 }
				 }
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int k = 0; k < temp[0].length; k++) {
				System.out.print(boolToInt(temp[i][k]) + " ");
			}
			System.out.println();
		}
		return temp[0][len-1];
	}
	
	public static int boolToInt(boolean b) {
	    return b ? 1 : 0;
	}
	
}
