public class Q36 {
    /**
     * Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2, and resets back. So this covers horizontal traversal for each block by 3 steps.
    Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
**/
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0)
            return false;
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();
        Set<Character> cube = new HashSet<>();
        
        for(int i =0;i<9;i++){
            rows.clear();
            cols.clear();
            cube.clear();
            for(int j =0;j<9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !cols.add(board[j][i]))
                    return false;
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                if(board[rowIndex + j/3][colIndex + j%3]!='.' && !cube.add(board[rowIndex + j/3][colIndex+j%3]))
                    return false;
            }
        }
        return true;
    }
}
