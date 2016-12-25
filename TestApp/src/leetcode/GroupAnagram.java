/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class GroupAnagram {
	 public List<List<String>> groupAnagrams(String[] strs) {
	        int []  primes = {2, 41, 37, 47, 3, 67, 71, 23, 5, 101, 61, 17, 19, 13, 31, 43, 97, 29, 11, 7, 73, 83, 79, 89, 59, 53};
	        List<List<String>> list = new ArrayList<>();
	        
	        if(strs.length==0)
	            return list;
	        HashMap<Integer,List<String>> map = new HashMap<>();
	        for(String s:strs){
	            int x=1;
	            
	            for(char c:s.toCharArray()){
	              x*=primes[c-97];
	            }
	            if(map.containsKey(x)){
	                List<String> lst = map.get(x);
	                lst.add(s);
	                map.put(x,lst);
	            }else{
	                List<String> lst = new ArrayList<>();
	                lst.add(s);
	                map.put(x,lst);
	            }
	        }
	        for(int l:map.keySet()){
	            list.add(map.get(l));
	        }
	        return list;
	 }
}
