public class Q79 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length==0 || board[0].length==0 || word == null || word.length()==0)
            return false;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }
    public boolean isValid(int i , int j , int index, char[][] board, String word){
        if(i<0 || i>=board.length || j<0 || j>= board[0].length || board[i][j]!=word.charAt(index))
            return false;
        return true;
    }
    public boolean dfs(char [][] board, int i, int j, int index, String word){
        if(index == word.length())
            return true;
        if(!isValid(i,j,index,board,word))
            return false;
        board[i][j]^=256;
        boolean result = dfs(board, i+1, j, index+1, word) ||
                    dfs(board, i, j+1, index+1, word) ||
                    dfs(board, i-1, j, index+1, word) ||
                    dfs(board, i, j-1, index+1, word) ;
        board[i][j]^=256;
        return result;
    }
}
