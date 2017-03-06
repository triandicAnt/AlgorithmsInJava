public class Q213 {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        return Math.max(rob(0,nums.length-2,nums), rob(1,nums.length-1,nums));
    }
    public int rob(int l, int h, int []nums){
        int even = 0;
        int odd = 0;
        for(int i = l;i<=h;i++){
            if(i%2==0)
                even = Math.max(nums[i] + even, odd);
            else
                odd = Math.max(nums[i] + odd, even);
        }
        return Math.max(even,odd);
    }
}
