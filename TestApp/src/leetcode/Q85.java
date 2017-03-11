public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int temp[] = new int[n];
        int max = 0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0')
                    temp[j]=0;
                else
                    temp[j] += 1;
            }
            //System.out.println(Arrays.toString(temp));
            int x = histogramArea(temp);
            //System.out.println(x);
            max = Math.max(max, x);
        }
        return max;
    }
    public int histogramArea(int [] a){
        Stack<Integer> st = new Stack<>();
        int top = 0;
        int area = 0;
        int max = -1;
        int i =0;
        for(i=0;i<a.length;){
            if(st.isEmpty() || a[st.peek()]<=a[i])
                st.push(i++);
            else{
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
