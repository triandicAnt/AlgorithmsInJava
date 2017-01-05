public class Q79 {
    public boolean exist(char[][] board, String word) {
        if(board.length==0)
            return false;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i<m;i++){
            for(int j =0;j<n;j++){
                if(dfsCheck(board,word,i,j,0)==true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfsCheck(char[][]board,String word, int i, int j, int index){
        if(index == word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index))
            return false;
        board[i][j] ^= 256;
        boolean result = dfsCheck(board,word,i-1,j,index+1) ||
                         dfsCheck(board,word,i,j-1,index+1) ||
                         dfsCheck(board,word,i+1,j,index+1) ||
                         dfsCheck(board,word,i,j+1,index+1) ;
        board[i][j] ^= 256;
        return result;
    }
}
