public class Q329 {
            int dir[][] = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int visited[][] = new int [m][n];
        int max = 1;
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                int d = dfs(matrix, visited, i , j);
                max = Math.max(d,max);
            }
        }
        return max;
    }
    public int dfs(int [][]matrix, int [][] visited, int i,int j){
        if(visited[i][j]>0)
            return visited[i][j];
        int m = matrix.length;
        int n = matrix[0].length;
        int max =1;
        for(int[]d:dir){
            int x = i + d[0];
            int y = j+ d[1];
            if(x<0 || x>=m || y<0 || y>=n  || matrix[x][y] <= matrix[i][j])
                continue;
            int dist = 1+dfs(matrix,visited,x,y);
            max = Math.max(dist,max);
        }
        visited[i][j] = max;
        return max;
    }
}
