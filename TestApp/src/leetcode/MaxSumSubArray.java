/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSumSubArray {

	  public int maxSubArray(int[] nums) {
	        int sumSoFar = nums[0];
	        int maxSum = nums[0];
	        for(int i =1; i<nums.length; i++){
	            sumSoFar = Math.max(nums[i], sumSoFar+nums[i]);
	            maxSum = Math.max(sumSoFar, maxSum);
	        }
	        return maxSum;
	        
	    }
}
