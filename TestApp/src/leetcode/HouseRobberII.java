package leetcode;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n =nums.length;
        if(n==0)
            return 0;
        if (n==1)
            return nums[0];
        return Math.max(robCircle(nums,0,n-1), robCircle(nums,1,n));
    }
    public int robCircle(int[] nums, int l, int h) {
        if(nums.length<=0)
        return 0;
         if(nums.length==1)
            return nums[0];
        int n = nums.length;
        int even=0,odd=0;
        for(int i=l;i<h;i++){
            if(i%2==0)
                even= Math.max(even+nums[i],odd);
            else
                odd= Math.max(odd+nums[i],even);
        }
        return Math.max(even,odd);
    }
}
