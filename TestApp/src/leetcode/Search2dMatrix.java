/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class Search2dMatrix {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = {{1,1}};
		
		System.out.println(searchMatrix(a, 2));
		System.out.println(Integer.MIN_VALUE);

	}
	  public static boolean searchMatrix(int[][] matrix, int target) {
	      int m =  matrix.length-1;
	      int n = matrix[0].length-1;
		  int c = n;
	        int r = m;
	        int row = 0;
	        int column = 0;
	        
	        while(column<=c && column <=n || row<=r && row <=m){
	        	//System.out.println(row + " "+ c);
	             if(row >=0 && row <=m && c >=0  && matrix[row][c] == target){
	                    return true;
	               }
	                if(r>=0 && column >=0 && column <=n &&  matrix[r][column]  == target){
	                	return true;
	            }
	            //start searching from top right corner
	            
	            if(row >=0 && row <=m && c>= 0 && matrix[row][c]>target){
	                c--;
	                continue;
	            }
	          //  c--;
	            if(r>=0 && column >=0 && column <=n && matrix[r][column]>target){
	                r--;
	                continue;
	            }
	          //  r--;
	            if(row >=0 && row <=m && c >=0 && matrix[row][c]<target){
	                row++;
	                continue;
	            }
	            if(r>=0 && column >=0 && column <=n && matrix[r][column]<target){
	                column++;
	                continue;
	            }
	           
	        }
	        return false;
	    }

}
