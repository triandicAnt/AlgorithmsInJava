/**
 * 
 */
package interviews;

/**
 * @author Sudhansu
 *
 */
import java.io.*;
import java.util.*;

public class PrintSpiral {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        // Read from stdin
         BufferedReader br = null;
        // Store input String to an array
        List<String> inputStringList = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = br.readLine();
                if(input == null)
                    break;
                inputStringList.add(input);
            }
            if(inputStringList == null)
                return;
            // store in a 2 D character array of N*M
            // find N and M
            int n = 0;
            int m = 0;
            if(inputStringList!=null && inputStringList.size()>0){
                String[] inputStringArray = inputStringList.get(0).trim().split("\\s");
                m = inputStringArray.length;
            }
            n = inputStringList.size();
            
            // if n == 0 or m ==0
            if(n == 0 || m == 0){
                System.out.print("");
                return;
            }
            
            // if there is only one string (n==1)
            if(n==1){
                String[] inputStringArray = inputStringList.get(0).trim().split("\\s");
                for(int j =0; j<inputStringArray.length;j++){
                   System.out.print(inputStringArray[j].charAt(0));
               }
               return;
            }
            // if only one column (m==1)
            if(m==1){
                for(String str: inputStringList){
                    System.out.print(inputStringList.get(0).trim().charAt(0));
                }
                return;
            }
            // populate 2D array
            //String [][] stringArray = new String [n][m];
            char [][] charArray = new char [n][m];
            for(int i = 0; i<n;i++){
                if(inputStringList.get(i)!=null || inputStringList.get(i)!=""){
                   String[] strTempArray = inputStringList.get(i).split("\\s");
                   for(int j =0; j<strTempArray.length;j++){
                       charArray[i][j] = strTempArray[j].charAt(0); 
                   }
                }
            }
            // iterate over the array to print the characters in spiral order
            
            // set directions
            
            int right = 0;
            int down = 1;
            int left = 2;
            int up = 3;
            
            // set initial coordinates
            int top_row = 0;
            int bottom_row = n-1;
            int top_col=0;
            int bottom_col=m-1;
            
            // initial direction is right
            int dir = right;
            
            while(bottom_row>=top_row && bottom_col>=top_col){
                // go right
                if(dir==right){
                    for(int i =top_col; i<=bottom_col;i++){
                        System.out.print(charArray[top_row][i]);
                    }
                    dir = down;
                    top_row++;
                }
                // go down
                if(dir==down){
                    for(int i =top_row; i<=bottom_row;i++){
                         System.out.print(charArray[i][bottom_col]);

                    }
                    dir = left;
                    bottom_col--;
                }
                // go left
                if(dir==left){
                    for(int i =bottom_col; i>=top_col;i--){
                        System.out.print(charArray[bottom_row][i]);
                    }
                    dir = up;
                    bottom_row--;
                }
                //go up
                if(dir==up){
                    for(int i =bottom_row; i>=top_row;i--){
                        System.out.print(charArray[i][top_col]);
                    }
                    dir = right;
                    top_col++;
                }
		  }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}