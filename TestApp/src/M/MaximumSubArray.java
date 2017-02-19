public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int res = nums[0];
        int max = res;
        for(int i =1;i<nums.length;i++){
            res += nums[i];
            res = Math.max(nums[i],res);
            max = Math.max(res,max);
        }
        return max;
    }
}
