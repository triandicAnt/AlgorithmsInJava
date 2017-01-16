public class Q463 {
    public int islandPerimeter(int[][] grid) {
        if(grid==null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        int neighs = 0;
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    islands++;
                    if(i+1<m && grid[i+1][j]==1)
                        neighs++;
                    if(j+1<n && grid[i][j+1]==1)
                        neighs++;
                }
            }
        }
        return 4*islands-2*neighs;
    }
}
