package string;

public class MinimumSplitForPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("aabaa"));
		System.out.println(minimumSplit("abbab"));
	}
	/**
	 * String = "abba"
	 */
	
	static int minimumSplit(String s){
		if(s==null || s.length()<1){
			return 0;
		}
		/**
		 * f(i) = 0 if str[0,i+1] is palindrome
		 * f(i) = Min(f(j)) (0<=j<i
		 */
		int n = s.length();
		int[] min = new int[s.length()];
		for(int i=0; i<min.length;i++){
			min[i] = i;
		}
		
		for(int i =1; i<s.length();i++){
			if(isPalindrome(s.substring(0, i+1))){
				min[i] = 0;
			}
			for(int j =0; j<i; j++){
				if(isPalindrome(s.substring(j+1,i+1)) && min[i]> min[j]+1){
					min[i] = min[j] +1; 
				}
			}
		}
		
		return min[n-1];
	}
	static boolean isPalindrome(String s){
		int n = s.length()-1;
		for(int i=0; i<=n/2;i++){
			if(s.charAt(i)!=s.charAt(n-i))
				return false;
		}
		return true;
	}
}
