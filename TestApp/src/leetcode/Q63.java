public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0 || n==0 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        //return countPaths(obstacleGrid, 0,0);
        return countPathDP(obstacleGrid);
    }
    public int countPaths(int [][] mat, int row, int col){
        if(!isValid(mat, row, col))
            return 0;
        if(row == mat.length-1 && col == mat[0].length-1)
            return 1;
        return countPaths(mat, row+1, col) + countPaths(mat, row, col+1);
    }
    public boolean isValid(int [][] mat, int i , int j){
        if(i>=mat.length || j >= mat[0].length || mat[i][j] == 1)
            return false;
        return true;
    }
    
    public int countPathDP(int [][]mat){
        int m = mat.length;
        int n = mat[0].length;
        int dp [][] = new int [m][n];
        if(isValid(mat, 0,0))
            dp[0][0] = 1;
        for(int i =1 ;i<m;i++){
            if(isValid(mat, i,0) && dp[i-1][0]!=0)
                dp[i][0] = 1;
        }
        for(int i =1 ;i<n;i++){
            if(isValid(mat, 0,i) && dp[0][i-1]!=0)
                dp[0][i] = 1;
        }
        for(int i = 1;i<m ;i++){
            for(int j = 1; j<n ;j++){
                if(isValid(mat, i,j)){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
}
