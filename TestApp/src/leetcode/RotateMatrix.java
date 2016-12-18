/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class RotateMatrix {
	 public void rotate(int[][] matrix) {
	        // reverse the mat from top to bottom
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        for(int j=0;j<n;j++){
	            for(int i=0;i<m/2;i++){
	               // swap(matrix[i][j],matrix[m-i-1][j]);
	               int temp = matrix[i][j];
	               matrix[i][j] = matrix[m-i-1][j];
	               matrix[m-i-1][j] = temp;
	            }
	        }
	        // swap along the symmetry
	        for(int i =0;i<m;i++){
	            for(int j=i;j<n;j++){
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
	       // return matrix;
	    }
}
