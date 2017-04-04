public class Q123 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        // int [] profit = new int[prices.length];
        // int x = prices[0];
        // for(int i = 1;i<prices.length;i++){
        //     if(prices[i]-x > 0)
        //         profit[i] = prices[i]-x;
        //     x = prices[i];
        // }
        // int [] s = find(profit);
        // return s[0]+s[1];
        return getMax1(prices,2);
    }
    
    public int getMax(int [] p, int k){
        int n = p.length;
        int[][]temp = new int[k+1][n+1];
        /**
         * T[i][j] = Math.max( T[i][j-1]
         *                      
         *                      p[j] - p[m] + T[i-1][m]
         *                      for m = 0-j-1)
         * 
         **/
         for(int i = 1;i<temp.length;i++){
             for(int j = 1;j<temp[0].length;j++){
                 int x = 0;
                 for(int m = 0;m<j;m++){
                     x = Math.max(x, p[j-1]-p[m]+temp[i-1][m]);
                 }
                 temp[i][j] = Math.max(x,temp[i][j-1]);
             }
         }
        return temp[k][n];
         
    }
    
     public int getMax1(int [] p, int k){
        int n = p.length;
        int[][]temp = new int[k+1][n+1];
        /**
         * T[i][j] = Math.max( T[i][j-1], prices[j]+maxDiff)
         *                      
         *  maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j])
         * 
         **/
         for(int i = 1;i<temp.length;i++){
             int maxDiff = -p[0];
             for(int j = 1;j<temp[0].length;j++){
                 temp[i][j] = Math.max(p[j-1] + maxDiff,temp[i][j-1]);
                 maxDiff = Math.max(maxDiff, temp[i-1][j] - p[j-1]);
             }
         }
        return temp[k][n];
         
    }
    
    
    
    
    int[] find(int[]a){
        int first = 0;
        int second = 0;
        for(int i : a){
            if(i>first && i>second){
                second = first;
                first = i;
            }else if(i>second){
                second = i;
            }
        }
        int s[] = new int[2];
        s[0] = first;
        s[1] = second;
        return s;
    }
}
