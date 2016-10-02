package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossiblePathsInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] mat = {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}
		};
		System.out.println(Arrays.deepToString(findPaths(mat)));
		System.out.println(findPathCount(mat));
		System.out.println(printAllPaths(mat));
	}
	
	/**
	 * can move right and left only
	 * 1  2  3  4
	 * 5  6  7  8   
	 * 9 10 11 12
	 */
	
	static int [][] findPaths(int [][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int path [][] = new int [m][n];
		// first row
		for(int i=0;i<n;i++){
			path[0][i] = 1;
		}
		// first column
		for(int i=0;i<m;i++){
			path[i][0] = 1;
		}
		for(int i=1;i<m;i++){
			for(int j =1; j<n;j++){
				path[i][j] = path[i-1][j] + path[i][j-1];
			}
		}
		return path;
	}
	
	static int findPathCount(int [][]matrix){
		return pathRecursive(matrix.length-1, 0,0);
	}
	static int pathRecursive(int n, int i, int j){
		if(i== n || j==n)
			return 1;
		return pathRecursive(n, i+1, j) + pathRecursive(n, i, j+1);
	}
	
	static List<String> printAllPaths(int [][]matrix){
		List<String> pathList = new ArrayList<String>();
		getPath(matrix.length-1, 0,0,pathList,"");
		return pathList;
	}
	
	static void getPath(int n, int i, int j, List<String> pathList, String path){
		// add i,j to path
		path+= String.format("(%d,%d)", i,j);
		if(i==n || j==n){
			pathList.add(path);
		}
		// getting outside the boundary
		else if(i>n || j>n){
			return;
		}
		else{
			getPath(n, i+1, j, pathList, path);
			getPath(n, i, j+1, pathList, path);
		}
	}

}
