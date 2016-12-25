/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class NumberOfIslands {
	  int [] offset = {-1,0,1};
	    public int numIslands(char[][] grid) {
	        if(grid.length==0)
	            return 0;
	        int m = grid.length;
	        int n = grid[0].length;
	        boolean [][] temp = new boolean[m][n];
	        int count = 0;
	        for(int i=0;i<m;i++){
	            for(int j = 0;j<n;j++){
	                if(grid[i][j]=='1' && temp[i][j]==false){
	                    count++;
	                    dfs(grid,temp,i,j);
	                }
	            }
	        }
	        return count;
	    }
	    
	    public boolean checkNeighbor(int i, int j, char [][]grid){
	        if((i>=0 && i<grid.length) &&(j>=0&&j<grid[0].length))
	           if(grid[i][j]=='1')
	            return true;
	        return false;
	    }
	    public void dfs(char[][]grid, boolean[][]temp,int i, int j){
	        if(temp[i][j]==true)
	            return;
	        temp[i][j] = true;
	        for(int p = 0;p<offset.length;p++){
	            for(int q=0;q<offset.length;q++){
	                int xOff = i+offset[p];
	                int yOff = j+offset[q];
	                if(Math.abs(offset[p]) ==Math.abs(offset[q]))
	                    continue;
	                if(checkNeighbor(xOff,yOff,grid)==true)
	                    dfs(grid,temp,xOff,yOff);
	            }
	        }
	    }
}
