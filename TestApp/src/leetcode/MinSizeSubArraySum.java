public class MinSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0||s==0)
            return 0;
        if(nums.length==1 && s == nums[0])
            return 1;
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(p2<nums.length){
          sum+=nums[p2++];
          while(sum>=s){
              min = Math.min(min,p2-p1);
              sum-=nums[p1++];
          }
        }
        return min>=Integer.MAX_VALUE?0:min;
    }
}
