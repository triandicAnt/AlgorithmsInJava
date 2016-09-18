/**
 * 
 */
package dp;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class MinimumCoinsToSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] coins = new int []{1,3,5};
		System.out.println(findMinCoins(coins, 0));
		System.out.println(findMinCoins(coins, 1));
		System.out.println(findMinCoins(coins, 2));
		System.out.println(findMinCoins(coins, 3));
		System.out.println(findMinCoins(coins, 7));


	}
	/**
	 * Find minimum number of coins required for a sum 
	 * Suppose coins are 1,3,5 are sum is 11
	 * create an array with number of sum elements
	 * initialize Min[i] = 0 and others are -1
	 * set value for base case
	 * check whether can we get the values from previous cases
	 */
	
	static int findMinCoins(int [] coins, int sum){
		if(coins.length<=0)
			return -1;
		int min [] = new int [sum+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		// base case : when sum is 0 we need 0 coins 
		min[0] = 0;
		// for sum 1 to sum.. check whether we can get minimum by adding a coin to the (sum-1) or not
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < coins.length; j++) {
				// if current coin value is less than cur_sum(i)
				if(coins[j]<=i && min[i-coins[j]]+1< min[i]){
					min[i] = min[i-coins[j]]+1 ;
				}
			}
		}
		return min[sum];
	}

}
