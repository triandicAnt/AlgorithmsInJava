public class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int r = 0;
        int m = matrix.length-1;
        int c = matrix[0].length-1;
        while(r<=m && c>=0){
            if(matrix[r][c]==target)
                return true;
            if(matrix[r][c]>target)
                c--;
            else
                r++;
        }
        return false;
    }
}
