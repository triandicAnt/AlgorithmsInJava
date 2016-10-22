/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int integerBreak(int n) {
	        if(n==0)
	            return 0;
	        else if(n==2 || n==3)
	            return n-1;
	        else if(n==4)
	            return 4;
	        else{
	            int result = 1;
	            while(n>4){
	                result *= 3;
	                n -= 3;
	            }
	            result *= n;
	            return result;
	        }
	        
	    }

}
