public class TrapWater {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int [] maxRight = new int[height.length];
        int max = 0;
        for(int i = height.length-1;i>=0;i--){
            if(height[i]>max){
                max = height[i];
            }
            maxRight[i] = max;
        }
        int maxLeft = 0;
        int total = 0;
        for(int i =0 ;i<height.length;i++){
            total += Math.max(0, Math.min(maxRight[i],maxLeft)-height[i]);
            if(height[i]>maxLeft)
                maxLeft = height[i];
        }
        return total;
    }
}
