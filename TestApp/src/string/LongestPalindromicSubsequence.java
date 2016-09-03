package string;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		String s = "acbdebfa"; // abdba
		System.out.println(lpss(s));
		String s1 = "acbefbda";
		System.out.println(lpss(s1));
		String s2 = "agbba";
		System.out.println(lpss(s2));
	}
	
	static int lpss(String s){
		int n = s.length();
		int [][] a = new int [n][n];
		
		for(int i = 0; i<n;i++){
			a[i][i] = 1;
		}
		
		for(int len =2; len<=n; len++){
			for (int i = 0; i < n-len+1; i++) {
				int j = i+len-1;
				if(s.charAt(i) == s.charAt(j)){
					a[i][j] = 2 + a[i+1][j-1];
				}else{
					a[i][j] = Math.max(a[i][j-1], a[i+1][j]);
				}
				
			}
		}
		return a[0][n-1];
	}
}
