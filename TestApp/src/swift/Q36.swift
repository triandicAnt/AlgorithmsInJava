class Q36 {
    func isValidSudoku(_ board: [[Character]]) -> Bool {
        if board == nil || board.isEmpty || board[0].isEmpty{
            return false
        }
        var rows = Set<Character>()
        var cols = Set<Character>()
        var cube = Set<Character>()
        
        for i in 0...8{
            rows.removeAll()
            cols.removeAll()
            cube.removeAll()
            for j in 0...8{
                if board[i][j] != "." && rows.contains(board[i][j]){
                    return false
                }else{
                    rows.insert(board[i][j])
                }
                
                if board[j][i] != "." && cols.contains(board[j][i]){
                    return false
                }else{
                    cols.insert(board[j][i])
                }
                let rowIndex = 3*(i/3)
                let colIndex = 3*(i%3)
                if board[rowIndex + j/3][colIndex + j%3] != "." && cube.contains(board[rowIndex + j/3][colIndex + j%3]){
                    return false
                }else{
                    cube.insert(board[rowIndex + j/3][colIndex + j%3])
                }
            }
        }
        return true
    }
}
