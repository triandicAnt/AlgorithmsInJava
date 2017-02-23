public class RotateMatrix {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        // first swap up and down for clockwise
        // for anti clockwise swap left and right
        for(int i =0;i<m/2;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }
        }
        
        // swap along the symmetry diagonal
        for(int i = 0; i<m;i++){
            for(int j = 1;j<n;j++){
                if(i<j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
       
    }
}
