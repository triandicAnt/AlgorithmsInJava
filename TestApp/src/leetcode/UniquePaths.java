/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

	 public int uniquePaths(int m, int n) {
	        int path[][] = new int [m][n];
	        // firsr row 
	        for(int i=0;i<n;i++)
	            path[0][i] = 1;
	        // first column
	        for(int i=0;i<m;i++)
	            path[i][0] =1;
	        
	        // for rest of the cells
	        for(int i=1;i<m;i++){
	            for(int j =1; j<n;j++){
	                path[i][j] = path[i-1][j] + path[i][j-1];
	            }
	        }
	        return path[m-1][n-1];
	       // return uniquePathRec(m-1,n-1,0,0);
	    }
	    public int uniquePathRec(int m, int n, int i , int j){
	        if(i==m || j==n)
	            return 1;
	        return uniquePathRec(m,n, i+1, j) + uniquePathRec(m,n,i,j+1);
	    }
}
