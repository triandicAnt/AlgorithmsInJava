public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0)
            return new int [0];
        int n = nums.length;
        int [] res = new int[n];
        int left = 1;
        for(int i=0;i<n;i++){
            if(i>0)
                left = left*nums[i-1];
            res[i] = left;
        }
        int right = 1;
        for(int i =n-1;i>=0;i--){
            if(i<n-1)
                right = right*nums[i+1];
            res[i] = res[i]*right;
        }
        return res;
    }
}
