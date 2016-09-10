package array;

public class ToeplizMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{6, 7, 8, 9, 2},
				  		  {4, 6, 7, 8, 9},
				          {1, 4, 6, 7, 8},
				          {0, 1, 4, 6, 7}};
		System.out.println(isToepliz(matrix));

	}
	/**
	 * If diagonal from left to right are same numbers
	 * @param mat
	 * @return
	 */
	static boolean isToepliz(int [][] mat){
		for(int i = 0; i<mat.length-1;i++){
			for(int j = 0; j<mat[0].length-1;j++){
				if(mat[i][j]!=mat[i+1][j+1]){
					System.out.println("("+i+","+j+")");
					return false;
				}
					
			}
		}
		return true;
	}
}
