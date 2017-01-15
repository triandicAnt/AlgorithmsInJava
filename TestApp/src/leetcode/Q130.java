public class Q130 {
    int dir[][] = new int [][]{{1,0},{0,1},{-1,0},{0,-1}}; 
    public void solve(char[][] board) {
        if(board==null || board.length<2 || board[0].length<2)
            return;
        int m = board.length;
        int n = board[0].length;
        for(int i =0;i<m;i++){
            if(board[i][0]=='O')
                dfs(board, i,0);
            if(board[i][n-1]=='O')
                dfs(board,i,n-1);
        }
        for(int i =0;i<n;i++){
            if(board[0][i]=='O')
                dfs(board, 0,i);
            if(board[m-1][i]=='O')
                dfs(board,m-1,i);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n ; j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='*')
                    board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] matrix, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
            matrix[i][j] = '*';
        for(int[] d:dir){
            int x = i+d[0];
            int y = j+d[1];
             if (x > 0 && x < m - 1 && y > 0 && y < n - 1 && matrix[x][y] == 'O') {
                dfs(matrix, x, y);
            }
        }
    }
}
