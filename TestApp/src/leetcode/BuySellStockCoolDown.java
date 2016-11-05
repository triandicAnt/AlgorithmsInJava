/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *  Not clear
 */
public class BuySellStockCoolDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProfit(int[] prices) {
    int sold = 0, hold = Integer.MIN_VALUE, rest = 0;
    for (int i=0; i<prices.length; ++i)
    {
        int prvSold = sold;
        sold = hold + prices[i];
        hold = Math.max(hold, rest-prices[i]);
        rest = Math.max(rest, prvSold);
    }
    return Math.max(sold, rest);
    }

}
