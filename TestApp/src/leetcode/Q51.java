public class Q51 {
    class Position{
        int row;
        int col;
        Position(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if(n==0)
            return list;
        Position [] pos = new Position[n];
        solve(list, n, 0, pos);
        return list;
    }
    public void solve(List<List<String>> list, int n, int row, Position[] pos){
        if(row == n){
            List<String> l = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            for(Position p: pos){
                for(int i = 0; i<n;i++){
                    if(p.col == i){
                        sb.append("Q");
                    }else
                        sb.append(".");
                }        
                l.add(sb.toString());
                sb = new StringBuffer();
            }
            list.add(new ArrayList<>(l));
            return;
        }
        for(int col = 0;col<n;col++){
            boolean foundFlag = true;
            for(int q = 0;q<row;q++){
                if(pos[q].col == col || pos[q].row+pos[q].col==row+col || pos[q].row-pos[q].col==row-col){
                    foundFlag = false;
                    break;
                }
                    
            }
            if(foundFlag){
                Position p = new Position(row,col);
                pos[row] = p;
                solve(list,n,row+1,pos);
            }
        }
    }
}
