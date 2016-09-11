package string;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverseRecur("dlrowolleh"));
		System.out.println(reverseIter("dlrowolleh"));

	}
	
	// recursive
	static String reverseRecur(String s){
		if(s==null || s.length()<2)
			return s;
		return reverseRecur(s.substring(1)) + s.charAt(0);
	}
	// iterative
	
	static String reverseIter(String s){
		char [] c = s.toCharArray();
		int n = c.length-1;
		for(int i=0;i<=n/2;i++){
			swap(c, i,n-i);
		}
		return String.valueOf(c);
	}
	
	static void swap(char[]c , int i, int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
}
