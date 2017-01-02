public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0)
            return list;
        int dir = 0; // right, 1, down // 2, left, 3, up
        int m = matrix.length;
        int n = matrix[0].length;
        int topRow = 0;
        int bottomRow = m-1;
        int topCol = 0;
        int bottomCol = n-1;
        
        while(topRow<=bottomRow && topCol<=bottomCol){
            if(dir==0 && topRow<m && bottomRow<m && topCol<n && bottomCol<n){// right
                for(int i = topCol;i<=bottomCol;i++){
                    list.add(matrix[topRow][i]);
                }
                topRow++;
                dir = 1;

            }else if(dir ==1 && topRow<m && bottomRow<m && topCol<n && bottomCol<n){// down
                for(int i = topRow;i<=bottomRow;i++){
                    list.add(matrix[i][bottomCol]);
                }
                    bottomCol--;
                    dir = 2;

            }else if(dir ==2 && topRow<m && bottomRow<m && topCol<n && bottomCol<n) {// left
                for(int i = bottomCol;i>=topCol;i--){
                    list.add(matrix[bottomRow][i]);
                }
                    bottomRow--;
                    dir = 3;

            }else if(dir ==3 && topRow<m && bottomRow<m && topCol<n && bottomCol<n){// left
                for(int i = bottomRow;i>=topRow;i--){
                    list.add(matrix[i][topCol]);
                }
                    topCol++;
                    dir = 0;

            }
        }
        return list;
        
    }
}
