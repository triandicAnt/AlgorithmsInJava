/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author Sudhansu
 *
 */
public class Q456 {
	public boolean find132pattern(int[] nums) {
        if(nums==null || nums.length<3)
            return false;
        Stack<Integer> st = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
             if( nums[i] < s3 ) return true;
            else {
            	while( !st.empty() && nums[i] > st.peek() ){ 
            		s3 = st.peek();
            		st.pop(); 
            	}
            }
            st.push(nums[i]);
        }
        return false;
    }
}
