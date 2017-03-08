import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  int [] offset = {-1,1,0}; // {1,0, }{0, 1}
  int temp;
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    // for (String string : strings) {
    //   System.out.println(string);
    // }
    
    int [][] a = {{ 1, 0, 1 },
                  { 1, 0, 1 },
                  { 0, 1, 0 }};
    int [][] b = {{ 1, 0, 1, 1 },
                  { 1, 1, 0, 1 },
                  { 1, 0, 1, 1 }};
    
    Solution s = new Solution ();
    System.out.println(Arrays.deepToString(a));
    System.out.println(s.getInput(a));
    System.out.println(s.getInput(b));

    
  }
  public int getInput(int [][] matrix){
     if(matrix == null || matrix.length==0 || matrix[0].length == 0)
       return 0;
     int m = matrix.length;
    int n = matrix[0].length;
    int count = 0 ;
    
    boolean visited[][] = new boolean [m][n];
    
    for(int i=0;i<m;i++){
      
      for(int j = 0 ;j<n ; j++){
        if(!visited[i][j] && matrix[i][j]==1){
           temp = 1;
          dfs(visited, matrix, i, j);
          count = Math.max(temp, count);
        }
      }
    }
    return count;
    
  }
  public void dfs(boolean [][] visited, int[][]matrix, int i , int j){
       //System.out.println("here");

    if(visited[i][j])
        return;
    visited[i][j] = true;
    for(int x = 0; x<offset.length;x++){
      
     for(int y = 0; y<offset.length;y++){
         if(Math.abs(offset[x]) == Math.abs(offset[y])){
           continue;
         }
       
       int xOff = i + offset[x];
       int yOff = j + offset[y];
       // 

       if(isValid(matrix,visited, xOff, yOff)){
         //return;
         temp ++;
        // System.out.println(xOff + " " + yOff);
        dfs(visited, matrix, xOff, yOff); 
         
       }
     }
    }
  }
  
  public boolean isValid(int[][]matrix, boolean [][]visited, int i , int j){
    if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j] || matrix[i][j]!=1) 
      return false;
    return true;
  }
  
}


/* 
Your previous Plain Text content is preserved below:

Question: 
Given a matrix as input (a list of lists) of 1's and 0's, find the size of the biggest island of 1's. Two 1's are considered connected if they are touching along the x or the y axis. Example:

[ [ 1, 0, 1 ],
  [ 1, 0, 1 ],
  [ 0, 1, 0 ]] => 2

[ [ 1, 0, 1, 1 ],
  [ 1, 1, 0, 1 ],
  [ 1, 0, 1, 1 ]] => 5

[ [ 1, 1, 0, ]
  [ 1, 1, 0, ]
  [ 1, 1, 0, ] ] => 6
 */
