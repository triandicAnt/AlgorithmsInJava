public class Q221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int temp[][] = new int [m+1][n+1];
        int max = 0;
        for(int i = 1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    temp[i][j] = Math.min(Math.min(temp[i-1][j],temp[i][j-1]),temp[i-1][j-1]) +1;
                    if(max<temp[i][j])
                        max = temp[i][j];
                }
            }
        }
        return max*max;
    }
}
