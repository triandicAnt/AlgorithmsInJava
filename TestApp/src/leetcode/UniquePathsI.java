package leetcode;

public class UniquePathsI {
    public int uniquePaths(int m, int n) {
        //return findPaths(m-1,n-1,0,0);
        return countPaths(m-1,n-1);
    }
    public int findPaths(int m, int n, int i, int j){
        if(i==m || j==n)
            return 1;
        return findPaths(m,n,i+1,j) + findPaths(m,n,i,j+1);
    }
    public int countPaths(int m , int n){
        int [][]path = new int [m+1][n+1];
        for(int i=0;i<=m;i++){
            path[i][0] =1;
        }
        for(int i=0;i<=n;i++){
            path[0][i] =1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m][n];
    }
}
