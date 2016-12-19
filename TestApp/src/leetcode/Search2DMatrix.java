/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class Search2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix==null)
	            return false;
	        int m = matrix.length-1;
	        int n = matrix[0].length-1;
	        int c = matrix[0].length-1;
	        int r = matrix.length-1;
	        int i = 0;
	        int j = 0;
	        while(c>=0 && i<=m){
	            if(matrix[i][c]==target)
	                return true;
	            else if(matrix[i][c]<target)
	                c--;
	            else
	                i++;
	        }
	        while(r>=0 && j<=n){
	             if(matrix[r][j]==target)
	                return true;
	            else if(matrix[r][j]>target)
	                r--;
	            else
	                j++;
	        }
	        return false;
	    }
}
