public class Q84 {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        int max = 0;
        int area = 0;
        int top = -1;
        int i = 0;
        /**
         * if s is empty
         *      area = i*h[top]
         * else
         *      area = h[top]*(i-top-1)
         **/
        Stack<Integer> s = new Stack<>();
        for(i = 0;i<heights.length;){
            if(s.isEmpty() || heights[s.peek()]<=heights[i]){
                s.push(i++);
            }else{
                top = s.pop();
                if(s.isEmpty())
                    area = i*heights[top];
                else
                    area = (i-s.peek()-1)*heights[top];
                if(area>max)
                    max = area;
            }
        }
         while(!s.isEmpty()){
              top = s.pop();
                if(s.isEmpty())
                    area = i*heights[top];
                else
                    area = (i-s.peek()-1)*heights[top];
                if(area>max)
                    max = area;
         }       
        return max;
    }
}
