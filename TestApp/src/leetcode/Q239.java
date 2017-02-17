public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return new int[0];
     // number of windows = n-k+1
     int n = nums.length;
     int w = n-k+1;
     int []res = new int[w];
     int[]left = new int[n];
     int[]right = new int[n];
     for(int i = 0; i<n;i++){
         if(i%k==0)
            left[i] = nums[i];
        else
            left[i] = Math.max(left[i-1],nums[i]);
     }
     for(int i=n-1;i>=0;i--){
         if(i==n-1)
            right[i] = nums[i];
        else if(i%k==0)
            right[i] = nums[i];
        else
            right[i] = Math.max(right[i+1],nums[i]);
     }
     for(int i =0;i<w;i++){
         res[i] = Math.max(right[i],left[i+k-1]);
     }
     return res;
    }
}
