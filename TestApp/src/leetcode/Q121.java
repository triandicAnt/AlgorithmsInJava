public class Q121 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int min  = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                int p = prices[i] - min;
                if(p>max)
                    max = p;
            }
            if(prices[i]<min)
                min = prices[i];
        }
        return max;
    }
}
