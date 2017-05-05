import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LongestSubString {
  public static void main(String[] args) {
   String s = "eceba";
   System.out.println(maxSunstringWith2DistinctChars(s));
    /**
     For example, Given s = “eceba” and k = 2,
      T is "ece" which its length is 3.
      "abcadcacacaca" and 3, it returns "cadcacacaca".
      */
    String s1 = "aabacbebebe";
    
    System.out.println(lengthOfLongestSubstringTwoDistinct(s1,3));
     System.out.println(lengthOfLongestSubstringKDistinct(s1,3));

  }
  
 static int maxSunstringWith2DistinctChars(String s){
   
   if(s==null || s.length()==0)
      return 0;
   int start = 0;
   int end = 0;
   Map<Character, Integer> map = new HashMap<>();
   int counter = 0;
   int len = 0;
   int head = 0;
   while(end<s.length()){
     char c = s.charAt(end);
       map.put(c, map.getOrDefault(c,0)+1);
       if(map.get(c)==1)
         counter++;
     end++;
     while(counter>2){
       char c1 = s.charAt(start);
         map.put(c1, map.get(c1)-1);
         if(map.get(c1)==0)
           counter --;
       start++;
     }
     head = start;
     len = Math.max(len, end-start);
   }
   System.out.println(s.substring(start,start+len-1));
   return len;
 }
  
   public static int lengthOfLongestSubstringKDistinct(String s,int k) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;//new char
            end++;
            while(counter > k){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
  
  
}
