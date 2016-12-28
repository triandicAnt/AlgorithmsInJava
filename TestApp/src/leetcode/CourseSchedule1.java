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
public class CourseSchedule1 {
	  public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int n = prerequisites.length;
	        if(numCourses==0 || n==0)
	            return true;
	        // create a adjacency list:
	        HashMap<Integer,List<Integer>> map = new HashMap<>();
	        for(int [] a:prerequisites){
	           // for(int i=0;i<2;i++){
	                if(map.containsKey(a[1])){
	                    List<Integer> l = map.get(a[1]);
	                    l.add(a[0]);
	                    map.put(a[1],l);
	                }else{
	                    List<Integer> l = new ArrayList<>();
	                    l.add(a[0]);
	                    map.put(a[1],l);
	                }
	           // }
	        }
	        // create an array for visited nodes 0- unvisited, 1- visited, -1-visiting
	        //HashSet<Integer> set = new HashSet<>();
	        int [] visited = new int [numCourses];
	        for(int i=0;i<numCourses;i++){
	            if(dfsCheck(map,i,visited)==false)
	                return false;
	        }
	        return true;
	    }
	    
	    public boolean dfsCheck(HashMap<Integer, List<Integer>> map, int i, int [] visited){
	        if(visited[i]==-1)
	            return false;
	        if(visited[i]==1)
	            return true;
	        //mark it as unvisiting
	        visited[i] = -1;
	        // for each neighbors of current node do a dfs
	        if(map.containsKey(i)){
	            for(int n :map.get(i)){
	                if(dfsCheck(map,n,visited)==false)
	                    return false;
	            }
	        }
	        // mark current node as visited
	        visited[i] = 1;
	        return true;
	    }
}
