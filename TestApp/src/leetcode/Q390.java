package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q390 {
    List<Integer>[] adjList;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n==1 || edges.length==0)
            return Collections.singletonList(0);
        adjList = new List[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<>();
        // fill adjacency list
        for(int [] arr: edges){
            int u = arr[0];
            int v = arr[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        // create distance and previous arrays
        int []d1 = new int [n];
        int []d2 = new int [n];
        int []prev = new int [n];
        
        int u = 0;
        bfs(d1,prev,u);
        for(int i=0;i<n;i++){
            if(d1[i]>d1[u])
                u=i;
        }
        int v = 0;
        //Arrays.fill(prev,0);
        bfs(d2,prev,u);
        for(int i=0;i<n;i++){
            if(d2[i]>d2[v])
                v=i;
        }
        List<Integer> list = new ArrayList<>();
        while(v!=-1){
            list.add(v);
            v = prev[v]; 
        }
        List<Integer> l=  new ArrayList<>();

        if(list.size()%2==1){
            l.add(list.get(list.size()/2));
        }else{
            l.add(list.get(list.size()/2));
            l.add(list.get(list.size()/2-1));
        }
        return l;
    }
    
    public void bfs(int dist[], int prev [], int start){
        int n = dist.length;
        boolean[] visited = new boolean [n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        prev[start] = -1;
        visited[start] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v: adjList[u]){
                if(visited[v]==false){
                    visited[v] = true;
                    prev[v] = u;
                    q.add(v);
                    dist[v] = dist [u]+1;
                }
                visited[v] = true;
            }
        }
    }
}
