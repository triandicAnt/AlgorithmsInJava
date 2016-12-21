/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class PerfectSquare {

	public int numSquares(int n) {
        
        int root = (int)Math.sqrt(n);
        int temp [] = new int [n+1];
        for(int i=1; i<=n;i++){
            temp[i] = Integer.MAX_VALUE;
            for(int j=1;j<=root;j++){
                if(i==j*j)
                    temp[i]=1;
                else if(i>j*j)
                    temp[i] = Math.min(temp[i], temp[i-j*j]+1);
            }
        }
        return temp[n];
    }
}
