package leetcode;

import java.util.Arrays;

public class Q221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] temp = new int [m+1][n+1];
        // fill first row and first column
        int max = Character.getNumericValue(matrix[0][0]);
        // for(int i=0;i<n;i++){
        //     temp[0][i] = Character.getNumericValue(matrix[0][i]);
        //     if(temp[0][i]>max){
        //             max = temp[0][i];
        //         }
        // }
        // for(int i=0;i<m;i++){
        //     temp[i][0] = Character.getNumericValue(matrix[i][0]);
        //     if(temp[i][0]>max){
        //             max = temp[i][0];
        //         }
        // }
        // System.out.println(Arrays.deepToString(temp));
        
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                // if(matrix[i][j]=='1' && matrix[i-1][j]=='1' && matrix[i][j-1]=='1' && matrix[i-1][j-1]=='1'){
                //     temp[i][j] = temp[i-1][j-1]+1;
                // }else if(matrix[i][j]=='1' || matrix[i-1][j]=='1' || matrix[i][j-1]=='1' || matrix[i-1][j-1]=='1'){
                //     temp[i][j] = 1;
                // }
                if(matrix[i-1][j-1]=='0')
                    temp[i][j] = 0;
                else{
                    temp[i][j] = Math.min(Math.min(temp[i-1][j],temp[i][j-1]),temp[i-1][j-1]) +1 ;
                }
                if(temp[i][j]>max){
                    max = temp[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(temp));
        return max*max;
    }
}
