package leetcode;

public class PalindromicNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1234321));
		System.out.println(isPalindrome(12345));

	}
	  public static boolean isPalindrome(int x) {
	        String s = ""+x;
	        int i=0, j= s.length()-1;
	        while(i<j){
	            if(s.charAt(i)!=s.charAt(j)){
	                return false;
	            }else{
	                i++;
	                j--;
	            }
	        }
	        return true;
	        
	    }

}
