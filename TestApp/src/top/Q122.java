public class Q122 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int sum = 0;
        int x = prices[0];
        for(int i =1;i<prices.length;i++){
            if(prices[i]-x > 0)
                sum+=(prices[i]-x);
            x = prices[i];
        }
        return sum;
    }
}
