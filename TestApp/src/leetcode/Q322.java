public class Q322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount==0)
            return 0;
        if(n==0 || (n==1 && coins[0]>amount))
            return -1;
        
        int total[] = new int [amount+1];
        int loc[] = new int [amount+1];
        Arrays.fill(total, Integer.MAX_VALUE-1);
        total[0] = 0;
        Arrays.fill(loc, -1);
        for(int j=0;j<n;j++){
            for(int i = 1;i<=amount;i++){
                if(i>=coins[j]){
                    total[i] = Math.min(total[i], 1 + total[i-coins[j]]);
                    loc[i] = j;
                }
            }
        }
        return total[amount]==Integer.MAX_VALUE-1?-1:total[amount];
        
    }
}
