package backtracking;

// ref : http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
public class RatInMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        int maze[][] = {{1, 0, 0, 0},
	        				{1, 1, 0, 1},
	        				{0, 1, 0, 0},
	        				{1, 1, 1, 1}
	        			   };
	        solveMaze(maze);

	}
	
	// check if the current block is safe or not
	
	private static void solveMaze(int[][] maze) {
		int sol[][] = {{0, 0, 0, 0},
	            	   {0, 0, 0, 0},
	                   {0, 0, 0, 0},
	                   {0, 0, 0, 0}
	                  };
		
		if(mazeUtil(maze, sol, 0, 0)){
			// print solution
			printSolution(sol);
		}else{
			System.out.println("No solution exist!");
		}
		
	}

	private static boolean mazeUtil(int[][] maze, int[][] sol, int i, int j) {
		
		// check if x,y is the goal or not
		
		int m = maze.length;
		int n = maze[0].length;
		// if dest reached, return true
		if(i == m-1 && j == n-1){
			sol[i][j] = 1;
//			return (maze[i][j] == 1);
			return true;
		}
		
		// if the current block is safe then proceed 
		if(isSafe(i, j, maze)){
			sol[i][j] = 1;
			//check while moving right
			if(mazeUtil(maze, sol, i, j+1)){
				return true;
			}
			
			// check while moving left
			if(mazeUtil(maze, sol, i+1, j)){
				return true;
			}
			
			// backtrack
			sol[i][j] = 0;
			return false;
		}
		
		return false;
	}

	static boolean isSafe(int x, int y, int mat[][]){
		int m = mat.length;
		int n = mat[0].length;
		return (x>=0 && x< m &&
				y>=0 && y<n &&
				mat[x][y] == 1);
	}
	
	static void printSolution(int sol[][])
	    {
		int m = sol.length;
		int n = sol[0].length;
	        for (int i = 0; i < m; i++)
	        {
	            for (int j = 0; j < n; j++)
	                System.out.print(" " + sol[i][j] +
	                                 " ");
	            System.out.println();
	        }
	    }

}
