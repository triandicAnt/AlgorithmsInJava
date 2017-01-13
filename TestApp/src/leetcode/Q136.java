package leetcode;

public class Q136 {
    public int singleNumber(int[] nums) {
          int n = nums.length;
          if(n==1)
            return nums[0];
        int x = nums[0];
        for(int i = 1;i<n;i++){
            x^=nums[i];
        }
        // int y = 1;
        // for(int i = 2;i<=n;i++){
        //     y^=i;
        // }
        return x;
    }
}
