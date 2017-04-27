public class Q289 {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
      for(int i =0;i<m;i++){
        for(int j = 0; j<n;j++){
          int x = getNeighbors(board, m, n , i, j);
          if(board[i][j]==1 && x>=2 && x<=3){
            board[i][j] = 3;
          }
          if(board[i][j]==0 && x == 3){
            board[i][j] = 2;
          }
        }
      }
      for(int i = 0; i<m;i++){
        for(int j = 0;j<n;j++){
          board[i][j]>>=1;
        }
      }
      System.out.println("Herer");
    }
  
 
  public int getNeighbors(int[][]board, int m ,int n ,int i, int j){
   int l = 0;
    for(int x = Math.max(i-1, 0); x<= Math.min(i+1,m-1);x++){
      for(int y = Math.max(j-1, 0); y<= Math.min(j+1, n-1); y++){
        l += board[x][y]&1;
      }
    }
    l -= board[i][j]&1;
    return l;
  }
  
 
}
