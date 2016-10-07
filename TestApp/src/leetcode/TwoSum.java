package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Given nums = [2, 7, 11, 15], target = 9,

			Because nums[0] + nums[1] = 2 + 7 = 9,
			return [0, 1].
		 */
		int [] a = {2,7,11,15};
		System.out.println(Arrays.toString(twoSum(a, 9)));

	}
	   public static int[] twoSum(int[] nums, int target) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i=0; i<nums.length; i++){
	            map.put(nums[i], i);
	        }
	        for(int j=0; j<nums.length;j++){
	            if(map.containsKey(target-nums[j]) && j !=map.get(target-nums[j]) ){
	                return new int [] {j,map.get(target-nums[j])};
	            }
	        }
	        return new int [] {};
	        
	    }
}
