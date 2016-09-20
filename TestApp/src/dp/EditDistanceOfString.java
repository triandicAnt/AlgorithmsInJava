package dp;

import java.util.Arrays;

public class EditDistanceOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println(countEditDistRecu(str1, str2, str1.length(), str2.length()));
        System.out.println(countEditDistDP(str1, str2));

	}
	
	static int countEditDistRecu(String s1, String s2, int m, int n){
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return countEditDistRecu(s1, s2, m-1, n-1);
		
			return 1+ Math.min(Math.min(countEditDistRecu(s1, s2, m-1, n), countEditDistRecu(s1, s2, m, n-1)), countEditDistRecu(s1, s2, m-1, n-1));
	}
	
	/**
	 * DP
	 * create an array[m+1][n+1]
	 */
	
	static int countEditDistDP(String str1 , String str2){
		int m = str1.length();
		int n = str2.length();
		
		if(m==0)
			return n;
		if(n==0)
			return m;
		int [][] temp = new int [m+1][n+1];
		for(int a[] : temp)
			Arrays.fill(a,Integer.MAX_VALUE);
		
		for(int i = 0; i<=m; i++){
			for(int j=0; j<=n; j++){
				// if first string is empty.. insert all chars of other string
				if(i==0)
					temp[i][j] = j;
				// if second string is empty, insert all char of other string
				else if(j==0)
					temp[i][j] = i;
				//if i and j are same
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					temp[i][j] = temp [i-1][j-1];
				else{
					// will minimum if i-1,j-1  i-1,j   j-1,i
					
					temp[i][j] = 1+ Math.min(Math.min(temp[i-1][j], temp[i][j-1]), temp[i-1][j-1]);
				}
			}
		}
		return temp[m][n];		
	}
	

}
