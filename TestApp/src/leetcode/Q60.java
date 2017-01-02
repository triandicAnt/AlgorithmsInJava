/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class Q60 {
	  public String getPermutation(int n, int k) {
	        if(n<=0 || k<=0)
	            return null;
	        List<Integer> list = new ArrayList<>();
	        // boolean [] visited = new boolean[n];
	        // dfs(n,list,visited,"");
	        //System.out.println(list);
	        // return ""+list.get(k-1);
	        
	        for(int i=1;i<=n;i++)
	            list.add(i);
	        int fact [] = new int [n];
	        fact[0] = 1;
	        for(int i=1;i<n;i++){
	            fact[i] = i*fact[i-1];
	        }
	        k--;
	        StringBuffer sb = new StringBuffer();
	        for(int i=n;i>0;i--){
	            int ind = k/fact[i-1];
	            k = k%fact[i-1];
	            sb.append(list.get(ind));
	            list.remove(ind);
	        }
	        return sb.toString();
	    }
	    public void dfs(int n, List<Integer>list, boolean[] visited, String str){
	        if(str.length()==n){
	            int x = Integer.parseInt(str);
	            //if(list.contains(x)==false)
	                list.add(x);
	            return;
	        }
	        for(int i = 1;i<=n; i++){
	            if(visited[i-1]==false){
	                visited[i-1] = true;
	                //str+= ""+i;
	                dfs(n,list,visited,str+""+i);
	                // str = str.substring(0,str.length()-1);
	                visited[i-1]=false;
	            }
	        }
	    }
}
