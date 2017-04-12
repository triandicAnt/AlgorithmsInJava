public class Q322 {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0 || amount ==0 )
            return 0;
        if(coins.length==1)
            return amount%coins[0]==0?amount/coins[0]:-1;
        int []t = new int [amount+1];
        for(int i =1;i<=amount;i++){
            t[i] = Integer.MAX_VALUE -1;
        }
        for(int i = 1 ; i<=amount;i++){
            for(int j= 0;j<coins.length;j++){
                if(i>=coins[j])
                    t[i] = Math.min(t[i], 1 + t[i-coins[j]]);
            }
        }
        return t[amount]== Integer.MAX_VALUE-1?-1:t[amount];
    }
}
