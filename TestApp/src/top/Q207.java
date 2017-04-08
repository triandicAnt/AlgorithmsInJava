public class Q207 {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
     if(numCourses==0 || prerequisites == null || prerequisites.length==0 || prerequisites[0].length == 0)
        return true;
     HashMap<Integer, List<Integer>> map = new HashMap<>();
     // create adjacency list
     for(int [] p: prerequisites){
       List<Integer> l = map.getOrDefault(p[1], new ArrayList<Integer>());
       l.add(p[0]);
       map.put(p[1], l);
     }
     
     int visited[] = new int [numCourses];
     // 0 - unvisited
     // 1 visited
     // -1 visiting
     for(int i = 0; i<numCourses; i++){
         if(visited[i]==0){
            if(!dfs(i,map,visited))
                return false;
         }
     }
     return true;
   }
  
  public boolean dfs(int i , Map<Integer, List<Integer>> map, int []visited)   {
    if(visited[i]==-1)
        return false;
    if(visited[i] == 1)
      return true;
    visited[i] = -1;
    for(int n: map.getOrDefault(i, new ArrayList<Integer>())){
      if(!dfs(n, map,visited))
          return false;
   }
    visited[i] = 1;
    return true;

  }
}
