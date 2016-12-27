/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class UniquePathII {
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if(obstacleGrid.length==0)
	            return 0;
	       /* if(obstacleGrid.length==1 && obstacleGrid[0][0]==0)
	            return 1;
	        if(obstacleGrid.length==1 && obstacleGrid[0][0]==1)
	            return 0;
	        int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	        return countPaths(m,n,obstacleGrid);
	        */
	        // int m = obstacleGrid.length;
	        int n = obstacleGrid[0].length;
	                
	        int [] temp = new int [n];
	        temp[0] = 1;
	        for(int [] row : obstacleGrid){
	            for(int j=0;j<n;j++){
	                if(row[j]==1)
	                    temp[j]=0;
	                else if(j>0)
	                    temp[j] += temp[j-1];
	            }
	        }
	        return temp[n-1];

	    }
	    public boolean isValid(int i,int j, int m, int n, int [][]grid){
	        if((i>=0 &&i<m) && (j>=0 && j<n)){
	            if(grid[i][j]==0)
	                return true;
	            
	        }
	        return false;
	    }
	    public int countPaths(int m, int n , int [][]grid){
	        int [][] temp = new int [m+1][n+1];
	        for(int i=0;i<m;i++){
	            temp[i][0] =1;
	        }
	        for(int i=0;i<n;i++){
	            temp[0][i]=1;
	        }
	        for(int i=1;i<m;i++){
	            for(int j=1;j<n;j++){
	                if(isValid(i,j,m,n,grid)==true)
	                    temp[i][j] = temp[i-1][j] + temp[i][j-1];
	                else
	                    temp[i][j] = 0;
	            }
	        }
	        return temp[m][n];
	    }
}
