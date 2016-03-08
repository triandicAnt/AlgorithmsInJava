/**
 * 
 */
package random;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class LCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = new String("ABCA");
		String s2 = new String("ACAB");
		System.out.println(findLCS(s1, s2));
		System.out.println(findLCSLength(s1, s2));

	}
	/**
	 * Find longest common subsequence in two strings X and Y
	 * @param X
	 * @param Y
	 * @return string with longest subsequence
	 */
	static String findLCS(String X, String Y){
		if(X.length()==0 || Y.length() == 0){
			return "";
		}
		int l1 = X.length();
		int l2 = Y.length();
		char x = X.charAt(l1-1);
		char y = Y.charAt(l2-1);
		if(x==y)
			return findLCS(X.substring(0, l1-1), Y.substring(0, l2-1))+x;
		else{
			String s1 = findLCS(X.substring(0, l1-1), Y.substring(0, l2));
			String s2 = findLCS(X.substring(0, l1),Y.substring(0, l2-1));
			if(s1.length()>s2.length())
				return s1;
			else return s2;

		}
		
	}
	/**
	 * Find length of largest common subsequence using DP
	 * @param X
	 * @param Y
	 * @return
	 */
	static int findLCSLength(String X, String Y){
		int l1 = X.length();
		int l2 = Y.length();
		if(X.length()==0 || Y.length() == 0){
			return 0;
		}
		int [][] a = new int[l1+1][l2+1];
		for (int i = 1; i <= X.length(); i++) {
			for (int j = 1; j <= Y.length(); j++) {
				if(X.charAt(i-1)==Y.charAt(j-1)){
					a[i][j] = a[i-1][j-1]+1;
				}
				else{
					//a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
					if(a[i-1][j]>a[i][j-1]){
						a[i][j] = a[i-1][j];
					}
					else{
						a[i][j] = a[i][j-1];
					}
				}
			}
		}
		return a[l1][l2];

	}
}
