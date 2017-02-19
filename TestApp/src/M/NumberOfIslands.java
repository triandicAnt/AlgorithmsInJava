public class NumberOfIslands {
    int[] offset = new int[] {-1,0,1};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    dfs(visited, grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(boolean[][] visited, char[][] grid, int i ,int j){
        if(visited[i][j]==true)
            return;
        visited[i][j]  = true;
        for(int x = 0;x<this.offset.length;x++){
            for(int y = 0;y<this.offset.length;y++){
                if(Math.abs(this.offset[x]) == Math.abs(this.offset[y]))
                    continue;
                int xOff = i+offset[x];
                int yOff = j+offset[y];
                if(isValid(grid, xOff, yOff, visited)==true){
                    dfs(visited,grid, xOff, yOff);
                }
            }   
        }
    }
    public boolean isValid(char[][] grid, int i, int j , boolean[][]visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1' || visited[i][j] == true)
            return false;
        return true;
    }
}
