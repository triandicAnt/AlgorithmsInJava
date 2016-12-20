/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class GuessNumberII {
	 public int getMoneyAmount(int n) {
	        int temp [][] = new int [n+1][n+1];
	        return fillTable(temp,1,n);
	    }
	    public int fillTable(int [][] temp, int s, int e){
	        if(s>=e)
	            return 0;
	        if(temp[s][e]!=0)
	            return temp[s][e];
	        int res = Integer.MAX_VALUE;
	        for(int k=s;k<=e;k++){
	            int x = k+Math.max(fillTable(temp,s,k-1), fillTable(temp,k+1,e));
	            res = Math.min(res,x);
	        }
	        temp[s][e] = res;
	        return res;
	    }
}
