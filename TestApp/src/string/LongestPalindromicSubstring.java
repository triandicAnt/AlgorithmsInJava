package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "banana"; // output is anana
		System.out.println(lps(s));
		String s1 = "abcdcb"; // output is bcdcb
		System.out.println(lps(s1));

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

}
