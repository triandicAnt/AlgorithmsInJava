public class Q42 {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int maxSoFar = 0;
        int n = height.length;
        int [] rightMax = new int [n];
        for(int i = n-1;i>=0;i--){
            if(height[i]>maxSoFar)
                maxSoFar = height[i];
            rightMax[i] = maxSoFar;
        }
        int total = 0;
        int leftMax = 0;
        for(int i = 0; i<n;i++){
            total += Math.max(Math.min(leftMax, rightMax[i])-height[i],0);
            if(height[i]>leftMax)
                leftMax = height[i];
        }
        return total;
    }
}
