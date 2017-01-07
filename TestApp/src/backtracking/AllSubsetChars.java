package backtracking;

/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;


public class AllSubsetChars
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "ABC";
        Map<Character,Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int count [] = new int [map.size()];
        char chars [] = new char[map.size()];
        int i=0;
        //int j = 0;
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            count[i] = e.getValue();
            chars[i] = e.getKey();
            i++;
        }
        List<String> list = new ArrayList();
        StringBuffer sb = new StringBuffer();
        char[] arr = new char [str.length()];
        
        dfs(chars,count,list,sb,str.length(), 0);
                //dfs(chars,count,list,arr,0);
        
        System.out.println(list);
    }
    
    public static void dfs(char[] chars, int [] count, List<String> list, StringBuffer sb ,  int level, int pos){
        System.out.println(sb.toString());
       
        for(int i=pos;i<chars.length;i++){
            if(count[i]==0)
                continue;
            //arr[level] = chars[i];
            count[i] -=1;
            sb = sb.append(chars[i]);
            dfs(chars,count,list,sb,level,i);
            count[i] +=1;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
