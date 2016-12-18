/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class MinimumPathSumGrid {
    public int minPathSum(int[][] grid) {
        // return dfs(0,0,grid);
        return usingDFP(grid);
     }
     
     public int dfs(int i,int j , int [][]grid){
         
         // if the destination is reached
         if(i==grid.length-1 && j==grid[0].length-1){
             return grid[i][j];
         }
         //if the robot is in middle of the grid/ not the edge
         else if(i<grid.length-1 && j<grid[0].length-1){
             // check for both right and down
             int d1 = grid[i][j] + dfs(i+1,j,grid);
             int d2 = grid[i][j] + dfs(i,j+1,grid);
             return Math.min(d1,d2);
         }
         
         // if right border is reached
         else if(i<grid.length-1){
             return(grid[i][j] + dfs(i+1,j,grid));
         }
         
         // if bottom border is reached
         else if(j<grid[0].length-1){
             return (grid[i][j] + dfs(i,j+1,grid));
         }
         return 0;
     }
     
     public int usingDFP(int [][]grid){
         int m = grid.length;
         int n = grid[0].length;
         int [][]temp = new int [m][n];
         temp[0][0] = grid[0][0];
         // the first row is the sum of its previous cell
         for(int i=1;i<n;i++){
             temp[0][i] = temp[0][i-1] + grid[0][i];
         }
         // the first column is the sum of its previous cell
         for(int i=1;i<m;i++){
             temp[i][0] = temp[i-1][0] + grid[i][0];
         }
         
         // for the rest of the cell fill the minimum of left and bottom + grid[i][j]
         for(int i = 1;i<m;i++){
             for(int j =1;j<n;j++){
                 // if top is greater than left // use left value 
                 if(temp[i-1][j]>temp[i][j-1]){
                     temp[i][j] = temp[i][j-1]+grid[i][j];
                 }else{
                     temp[i][j] = temp[i-1][j]+grid[i][j]; 
                 }
             }
         }
         //return the last cell value
         return temp[m-1][n-1];
     }
}
