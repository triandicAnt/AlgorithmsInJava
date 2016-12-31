/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sudhansu
 *
 */
public class Q332 {
	  public List<String> findItinerary(String[][] tickets) {
	        if(tickets==null || tickets.length==0)
	            return Collections.singletonList("");
	        Map<String,PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	        for(String [] s: tickets){
	            PriorityQueue<String> pq;
	            if(map.containsKey(s[0])){
	                pq = map.get(s[0]);
	            }else{
	                pq = new PriorityQueue<String>();
	                // pq.offer(s[1]);
	                // map.put(s[0],pq);
	            }
	            pq.offer(s[1]);
	            map.put(s[0],pq);
	        }
	        System.out.println(map);
	        
	        ArrayList<String> list = new ArrayList<String>();
	    /*    String key = "JFK";
	        list.add(key);
	        while(map.containsKey(key)==true && map.get(key).size()!=0){
	            String prev = key;
	            key = map.get(key).poll();
	            if(!map.containsKey(key) && map.get(prev).size()>0){
	                String temp = key;
	                key = map.get(prev).poll();
	                map.get(prev).offer(temp);
	            }
	            list.add(key);
	        }
	        System.out.println(list);*/
	        visitDFS(map,list,"JFK");
	        return list;
	    }
	    
	    public void visitDFS(Map<String, PriorityQueue<String>> map, ArrayList<String> list, String start){
	        while(map.containsKey(start)==true && map.get(start).size()!=0){
	            visitDFS(map,list,map.get(start).poll());
	        }
	        list.add(0,start);
	    }
	}

