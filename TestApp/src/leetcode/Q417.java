/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class Q417 {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list= new ArrayList<>(); 
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean atlantic[][] = new boolean[m][n];
        boolean pacific[][] = new boolean[m][n];
        
      int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i = 0;i<m;i++){
            dfs(matrix,pacific,Integer.MIN_VALUE,i,0,dir);
            dfs(matrix,atlantic,Integer.MIN_VALUE,i,n-1,dir);
        }
        for(int i = 0;i<n;i++){
            dfs(matrix,pacific,Integer.MIN_VALUE,0,i,dir);
            dfs(matrix,atlantic,Integer.MIN_VALUE,m-1,i,dir);
        }
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(new int[] {i,j});
                }
            }
        }
        return list;
            
    }
    public void dfs(int matrix[][],boolean ocean[][], int height, int x, int y, int [][] dir){
        int m = matrix.length;
        int n = matrix[0].length;
        if(x<0 || x>=m || y<0 || y>=n || ocean[x][y]==true || height > matrix[x][y])
            return;
        ocean[x][y] = true;
        for(int []d:dir){
            dfs(matrix,ocean, matrix[x][y], x+d[0],y+d[1],dir);
        }
    }
  
}