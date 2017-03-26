public class Q11 {
    public int maxArea(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int l = 0;
        int r = height.length-1;
        int area = 0;
        while(l<r){
            area = Math.max(area, (r-l)*Math.min(height[l],height[r]));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return area;
    }
}
