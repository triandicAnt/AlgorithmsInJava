/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {0};
		System.out.println(missingNumber(arr));

	}
	public static int missingNumber(int[] nums) {
        int x = 0;
        int y = 0;
        int z = 0;
        for(int a : nums){
            x = x^a;
        }
        int max = Integer.MIN_VALUE;
        for(int b : nums){
            if(b>max)
                max = b;
        }
        for(int i=0;i<=max;i++){
            y = y^i;
        }
        System.out.println(x + " " + y);
        return x^y;
        
    }
	  public int missingNumber1(int[] nums) {
	       int x =0;
	       for(int i=0; i<nums.length; i++){
	           x ^=(i+1)^nums[i];
	       }
	       return x;
	        
	    }
}
