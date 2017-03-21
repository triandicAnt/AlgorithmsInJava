import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
//https://www.careercup.com/question?id=5619363327508480
class MaxString {
  
  
  public static void main(String args[]){
   String wrds[] = { "abc" , "baa" , "caan" , "an" , "banc"};
   char chars[] = {'a' , 'a' , 'n' , 'c' , 'b'};
    System.out.println(findString(wrds,chars));
  }
  
  public static String findString(String[] sArr, char[] cArr){
      long [] primes = {2,3,5,7,11};
      Map<Character ,Long> map = new HashMap<>();
      for(int i=0;i<cArr.length;i++){
        if(map.containsKey(cArr[i]))
          continue;
        map.put(cArr[i],primes[i]);
      }
      long res = 1;
      for(char c: cArr){
        res*= map.get(c);
      }
      String max = "";
      int l = 0;
      
      for(String s : sArr){
        long temp = 1;
        for(char c : s.toCharArray()){
          temp*=map.get(c);
        }
       // System.out.println(temp);
        if(res%temp==0){
         l = Math.max(l, s.length());
       //  System.out.println(res + " " + l);

          if(l==s.length())
           max = s;
      }
      }
      
      return max;
  }
  
 }
