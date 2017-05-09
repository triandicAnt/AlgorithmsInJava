import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class StrComb {
  public static void main(String[] args) {
    String s = "abc";
    System.out.println(printCombinations(s));
    
  }
  public static List<String> printCombinations(String str){
    if(str==null || str.length()==0)
        return new ArrayList<>();
    List<String> list = new ArrayList<>();
    permute(list, "", str);
    return list;
  }
  public static void permute(List<String> list, String pre, String str){
    if(str.length()==0){
      list.add(pre);
    }else{
      int n = str.length();
      for(int i = 0;i<n;i++){
        permute(list, pre+Character.toLowerCase(str.charAt(i)), str.substring(0,i)+str.substring(i+1));
        permute(list, pre+Character.toUpperCase(str.charAt(i)), str.substring(0,i)+str.substring(i+1)); 
      }
    }
  }
  
  
}
