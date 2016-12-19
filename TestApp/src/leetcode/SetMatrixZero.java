/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class SetMatrixZero {
public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;
        for(int i=0;i<n;i++){
        
            if(matrix[0][i] == 0)
                flag = true;
        }
        boolean flagCol = false;
        for(int i=0;i<m;i++){
        
            if(matrix[i][0] == 0)
                flagCol = true;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    // set the first row element to zero
                    matrix[0][j]=0;
                    // set entire row to 0
                    matrix[i][0] = 0;
                    //setRowsZero(matrix, i,n);
                }
            }
        }
        
        System.out.println(Arrays.deepToString(matrix));
        for(int i=1;i<n;i++){
            if(matrix[0][i]==0){
                setColsZero(matrix,i,m);
            }
        }
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                setRowsZero(matrix,i,n);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        if(flag==true){
             for(int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
         if(flagCol==true){
             for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }
    public void setRowsZero(int [][] matrix,int r, int n){
        for(int i=0;i<n;i++){
            matrix[r][i] = 0;
        }
    }
     public void setColsZero(int [][] matrix,int c, int m){
        for(int i=0;i<m;i++){
            matrix[i][c] = 0;
        }
    }
}
