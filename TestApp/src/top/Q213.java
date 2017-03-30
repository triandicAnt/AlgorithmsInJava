public class Q213 {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(robHouse(nums,0,n-2), robHouse(nums,1,n-1));
    }
    public int robHouse(int nums[], int l, int r){
        int a = 0;
        int b = 0;
        for(int i = l;i<=r;i++){
            if(i%2==0)
                a = Math.max(b, a+nums[i]);
            else
                b = Math.max(a, b + nums[i]);
        }
        return Math.max(a,b);
    }
}
