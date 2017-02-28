/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

public class Q348
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        TicTacToe toe = new TicTacToe(3);

        System.out.println(toe.move(0, 0, 1));  //-> Returns 0 (no one wins)
            /*
        |X| | |
        | | | | // Player 1 makes a move at (0, 0).
        | | | |

        */ 
        System.out.println(toe.move(0, 2, 2)); //-> Returns 0 (no one wins)
        /*
        |X| |O|
        | | | | // Player 2 makes a move at (0, 2).
        | | | |

        */ 
        System.out.println(toe.move(2, 2, 1)); //-> Returns 0 (no one wins)
        /*
        |X| |O|
        | | | | // Player 1 makes a move at (2, 2).
        | | |X|
         */ 

        System.out.println(toe.move(1, 1, 2)); //-> Returns 0 (no one wins)
        /*
        |X| |O|
        | |O| | // Player 2 makes a move at (1, 1).
        | | |X|

        */ 
        System.out.println(toe.move(2, 0, 1)); //-> Returns 0 (no one wins)
        /* 
        |X| |O|
        | |O| | // Player 1 makes a move at (2, 0).
        |X| |X|

        */ 
        System.out.println(toe.move(1, 0, 2)); //-> Returns 0 (no one wins)
        /*
        |X| |O|
        |O|O| | // Player 2 makes a move at (1, 0).
        |X| |X|
        */ 
        System.out.println(toe.move(2, 1, 1)); //-> Returns 1 (player 1 wins)
        /*
        |X| |O|
        |O|O| | // Player 1 makes a move at (2, 1).
        |X|X|X|

        */
    }
    
   
     
}

class TicTacToe{
    int []rows;
    int []cols;
    int diagonal;
    int antiDiagonal;
    
    TicTacToe(int n){
        this.rows = new int[n];
        this.cols = new int[n];
    }
    
     public int move(int row, int col, int player){
        int toAdd = player==1?1:-1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        
        if(row==col){
            diagonal += toAdd;
        }
         if(col == (cols.length-row-1)){
             antiDiagonal += toAdd;
        }
        int n = rows.length;
        if(Math.abs(rows[row])==n || 
           Math.abs(cols[col])==n || 
           Math.abs(diagonal) ==n ||
           Math.abs(antiDiagonal) == n)
                return player;
        return 0;
    }
}
