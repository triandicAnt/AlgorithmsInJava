import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Q418 {
  public static void main(String[] args) {
      
   
  /**
  Input:
  rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

  Output: 
  1

  Explanation:
  I-had
  apple
  pie-I
  had--
**/
    String [] s1 = {"I", "had", "apple", "pie"};
    System.out.println(new Q418().wordsTyping(s1,4,5));
    /**
    Input:
    rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

    Output: 
    2

    Explanation:
    a-bcd- 
    e-a---
    bcd-e-
    **/
     String [] s2 = {"a", "bcd", "e"};
    System.out.println(new Q418().wordsTyping(s2,3,6));
    /**
    Input:
    rows = 2, cols = 8, sentence = ["hello", "world"]

    Output: 
    1

    Explanation:
    hello---
    world---
    **/
    String [] s3 = {"hello", "world"};
    System.out.println(new Q418().wordsTyping(s3,2,8));

  }
  public int wordsTyping(String[] sentence, int rows, int cols) {
    if(sentence == null || rows==0 || cols == 0)
        return 0;
    StringBuffer sb = new StringBuffer();
    for(String s:sentence)
        sb.append( s+ " ");
    String s = sb.toString();
    int pos = 0;
    int len = s.length();
    for(int i = 0 ;i<rows;i++){
      pos += cols;
      if(s.charAt(pos%len)==' ')
        pos++;
      else{
        while(pos>0 && s.charAt((pos-1)%len)!=' ')
          pos--;
      }
    }
    return pos/len;
  }
   
}
 
