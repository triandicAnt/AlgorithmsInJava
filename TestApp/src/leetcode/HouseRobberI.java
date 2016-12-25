package leetcode;

public class HouseRobberI {
    /*public int rob(int[] nums) {
         if(nums.length<=0)
            return 0;
         if(nums.length==1)
            return nums[0];
        int n = nums.length;
        int even=0,odd=0;
        for(int i=0;i<n;i++){
            if(i%2==0)
                even= Math.max(even+nums[i],odd);
            else
                odd= Math.max(odd+nums[i],even);
        }
        return Math.max(even,odd);
    }*/
    public int rob(int[] nums) {
        if(nums.length<=0)
            return 0;
         if(nums.length==1)
            return nums[0];
        int n = nums.length;
        int [] temp = new int [n];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0],nums[1]);
        for(int i =2; i<n;i++){
            temp[i] = Math.max(temp[i-2]+nums[i], temp[i-1]);
        }
        return temp[n-1];
    }
}
