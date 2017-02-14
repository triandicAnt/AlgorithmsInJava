public class NumberOfIslands {
    int offset[] ={-1,0,1};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0)
            return 0;
        int count = 0;
        boolean [][]temp = new boolean [grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j =0 ; j<grid[0].length;j++){
                if(grid[i][j] == '1' && temp[i][j]==false){
                    count ++;
                    dfs(grid,temp,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid, boolean [][]temp, int i , int j){
        if(temp[i][j]==true)
            return ;
        temp[i][j] = true;
        for(int x=0;x<this.offset.length;x++){
            for(int y = 0; y<this.offset.length;y++){
                int xOff = i+offset[x];
                int yOff = j+offset[y];
                if(Math.abs(offset[x]) == Math.abs(offset[y]))
                    continue;
                if(isValid(grid, xOff, yOff)==true)
                    dfs(grid,temp,xOff,yOff);
            }
        }
    }
    public boolean isValid(char[][]grid,int x,int y){
        if((x>=0 && x<grid.length) &&(y>=0 && y<grid[0].length) && grid[x][y]=='1')
            return true;
        return false;
    }
}
