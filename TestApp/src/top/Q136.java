public class Q136 {
    public int singleNumber(int[] nums) {
         if(nums==null || nums.length==0)
            return 0;
        int x = nums[0];
        for(int i=1;i<nums.length;i++)
            x^=nums[i];
        return x;
    }
}
