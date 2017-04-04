public class Q188 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        if(k>prices.length/2)
            return quickSolve(prices);
        return getMax1(prices,k);
        
    }
    public int quickSolve(int []p){
        int s = 0;
        for(int i=1;i<p.length;i++){
            if(p[i]-p[i-1] > 0)
                s+= p[i]-p[i-1];
        }
        return s;
    }
    public int getMax(int [] p, int k){
        int temp [][] = new int [k+1][p.length+1];
        for(int i = 1;i<temp.length;i++){
            for(int j = 1;j<temp[0].length;j++){
                int x = 0;
                for(int m=0;m<j;m++){
                    x = Math.max(x, p[j-1]-p[m] + temp[i-1][m]);
                }
                temp[i][j] = Math.max(temp[i][j-1], x);
            }
        }
        return temp[k][p.length];
    }
    
     public int getMax1(int [] p, int k){
        int temp [][] = new int [k+1][p.length+1];
        for(int i = 1;i<temp.length;i++){
            int maxDiff = -p[0];
            for(int j = 1;j<temp[0].length;j++){
                temp[i][j] = Math.max(temp[i][j-1], p[j-1]+maxDiff);
                maxDiff = Math.max(maxDiff, temp[i-1][j]-p[j-1]);
            }
        }
        return temp[k][p.length];
    }
}
