public class Q84 {
    public int largestRectangleArea(int[] a) {
        if(a==null || a.length==0)
            return 0;
        Stack<Integer> st = new Stack<>();
        int top = 0;
        int area = 0;
        int max = -1;
        int i =0;
        for(i=0;i<a.length;){
            if(st.isEmpty() || a[st.peek()]<=a[i]){
                st.push(i++);
            }else{
                top = st.pop();
                if(st.isEmpty()){
                    area = a[top]*i;
                }else{
                    area = a[top]*(i-st.peek()-1);
                }
                if(area>max)
                    max = area;
            }
        }
        while(!st.isEmpty()){
                top = st.pop();

             if(st.isEmpty()){
                area = a[top]*i;
            }else{
                area = a[top]*(i-st.peek()-1);
            }
            if(area>max)
                max = area;
        }
        return max;
    }
}
