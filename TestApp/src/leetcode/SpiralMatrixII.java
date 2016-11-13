/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(Arrays.deepToString(generateMatrix(2)));

	}

	  public static int[][] generateMatrix(int n) {
	        int [][] arr = new int[n][n];
	        if(n<=0)
	            return arr;

	        int topRow = 0;
	        int bottomRow = n-1;
	        int topColumn = 0;
	        int bottomColumn = n-1;
	        Dir dir = Dir.r;
	        int x = 1;
	        while(topRow <= bottomRow && topColumn <= bottomColumn){
	            if(dir == Dir.r){
	                for(int i = topColumn; i<=bottomColumn;i++){
	                    arr[topRow][i] = x++;
	                }
	                topRow++;
                    dir = Dir.d;
	            }

	             if(dir == Dir.d){
	                for(int i = topRow; i<=bottomRow;i++){
	                    arr[i][bottomColumn] = x++;
	                }
                    bottomColumn--;
                    dir = Dir.l;

	            }

	             if(dir == Dir.l){
	                for(int i = bottomColumn; i>=topColumn;i--){
	                    arr[bottomRow][i] = x++;
	                }
                    bottomRow--;
                    dir = Dir.u;

	            }

	             if(dir == Dir.u){
	                for(int i = bottomRow; i>=topRow;i--){
	                    arr[i][topColumn] = x++;
	                }
	            }
                 topColumn++;
                 dir = Dir.r;

	        }
	        return arr;
	        
	    }
	}
	enum Dir{
	        r,
	        d,
	        l,
	        u
	    }