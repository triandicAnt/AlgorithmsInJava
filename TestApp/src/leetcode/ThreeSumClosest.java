package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] S  = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(S, -1));

	}
	 public static int threeSumClosest(int[] nums, int target) {
		 int n = nums.length;
	        int i=0, j=1,k=n-1;
	        Arrays.sort(nums);
         int abs = Integer.MAX_VALUE;
         int result = 0;
	        for(i=0;i<n-2;i++){
	            j = i+1;
	            k=n-1;
	            while(j<k){
	                int diff = Math.abs(target - (nums[i]+nums[j]+nums[k]));
	                int sum = nums[i]+nums[j]+nums[k];
	                if(diff == 0){
                     return sum;
	                }
	                if(diff<abs){
	                    abs = diff;
	                    result = sum;
	                }
	                if(sum<=target){
	                    j++;
	                }else{
	                    k--;
	                }
	            }
	        }
	        return result;
	    }

}

//https://leetcode.com/problems/3sum-closest/