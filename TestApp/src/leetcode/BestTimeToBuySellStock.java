/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuySellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int maxProfit(int[] prices) {
	        int profit = 0;
	        if(prices == null || prices.length <1)
	            return profit;
	        for(int i =1; i<prices.length; i++){
	            if(prices[i] > prices[i-1]){
	                profit += prices[i] - prices[i-1];
	            }
	        }
	        return profit;
	    }

}
