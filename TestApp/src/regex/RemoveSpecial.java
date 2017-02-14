import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

interface Word{
    String[] words(String s);
}

public class RemoveSpecial implements Word
{
    public static void main(String[] args) {
    String s = "Hey there,\tthis is a very \"good\" example! Some say' it's \"great.\"";
    
    // ["Hey", "there", "this", "is", "a", "very", "good", "example", "Some", "say", "it's", "great"]
    Solution sol = new Solution();
    System.out.println(Arrays.toString(sol.words(s)));
        
  }
  // mandatory to implement 
 public String[] words(String s){
    ArrayList<String> results = new ArrayList<>(); 
    String [] tempArray = s.split("\\s+");
    Pattern myPattern = Pattern.compile("[^A-Za-z]");
    Matcher match;
    for(String str : tempArray){
       match = myPattern.matcher(str);
       while(match.find()){
          String sTemp = match.group();
           str=str.replaceAll("\\"+sTemp, "");
         results.add(str);
       }
    }
  // System.out.println(results);
    return results.toArray(new String[0]);
   //return null;
  }
}
