/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class CountUniqueDigitNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int countNumbersWithUniqueDigits(int n) {
	       /* if(n==0)
	            return 1;
	        else if (n==1)
	            return 10;
	        else    
	            return ((9*fact(9))/fact(10-n));
	            */
	        if (n == 0)
	            return 1;
	        int rst = 10, count = 9;
	        for (int i = 2; i <= n; i++) {
	            count *= (10 - i + 1);
	            rst += count;
	        }
	        return rst;
	        
	    }
	    /*public int fact(int num){
	        if(num == 0 || num ==1)
	            return 1;
	        int a = 1;
	        int b = 1;
	        int c = 0;
	        for(int i = 2; i<= num; i++){
	            int temp = c;
	            c = a+b;
	            a = b;
	            b = temp;
	        }
	        return c;
	        
	    }
	    */
	     public int fact(int n) {
	        int fact = 1; // this  will be the result
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }
}
