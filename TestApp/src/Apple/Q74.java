public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m*n-1;
        while(l!=r){
            int mid = (l+r-1)>>1;
            if(matrix[mid/n][mid%n]<target)
                l = mid+1;
            else
                r = mid;
        }
        return matrix[r/n][r%n]==target ;
    }
}
