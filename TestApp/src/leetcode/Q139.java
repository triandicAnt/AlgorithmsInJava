/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Sudhansu
 *
 */
public class Q139 {
	    public boolean wordBreak(String s, Set<String> wordDict) {
	        if(s==null || s.length()==0 || wordDict.size()==0)
	            return false;
	        int n = s.length();
	        boolean [][]temp = new boolean[n][n];
	        // update values for length =1
	        for(int i=0;i<n;i++){
	            if(wordDict.contains(Character.toString(s.charAt(i))))
	                temp[i][i] = true;
	        }
	        // for length 2 to n
	        for(int l =2; l<=n;l++){
	            for(int i=0;i<=n-l;i++){
	                int j = i+l-1;
	                // check if we can get partition string and get words
	                for(int k = i; k<i+l-1;k++){
	                    if(wordDict.contains(s.substring(i,i+l))||(temp[i][k]==true && temp[k+1][i+l-1]==true)){
	                        temp[i][j] = true;
	                        break;
	                    }
	                }
	            }
	        }
	        // System.out.println(Arrays.deepToString(temp));
	        //print(temp);
	        return temp[0][n-1];
	    }
	    public void print(boolean [][]temp){
	        for(boolean []b:temp){
	            System.out.println(Arrays.toString(b));
	        }
	    }
	 public boolean wordBreak(String s, List<String> wordDict) {
   
       if(s==null || s.length()==0)
            return true;
       int n = s.length();
       boolean[]temp = new boolean[n+1];
       temp[0] = true;
       for(int i = 1; i<=n;i++){
           for(int j = 0;j<i;j++){
               if(temp[j] && wordDict.contains(s.substring(j,i))){
                   temp[i] = true;
                   break;
               }
           }
       }
       return temp[n];
   }
}
