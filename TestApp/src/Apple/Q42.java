public class Q42 {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int n = height.length;
        int []right = new int [height.length];
        int max = Integer.MIN_VALUE;
        
        for(int i = n-1;i>=0;i--){
            max = Math.max(height[i], max);
            right[i] = max;
        }
        int water = 0;
        int left = height[0];
        for(int i=0;i<n;i++){
            water += Math.max(Math.min(left, right[i])-height[i], 0);
            left = Math.max(left, height[i]);
        }
        return water;
    }
}
