public class Q210 {
    Stack<Integer> s = new Stack<>();
   // boolean cycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] topo = new int [numCourses];
        int n = prerequisites.length;
        if(numCourses==0)
            return topo;
        // create a adjacency list:
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int [] a: prerequisites){
            List<Integer> l;
            if(map.containsKey(a[1])){
                l = map.get(a[1]);
            }else{
                 l = new ArrayList<Integer>();
            }
            l.add(a[0]);
            map.put(a[1], l);
        }
        int [] visited = new int [numCourses];
        boolean [] cycle = new boolean [numCourses];
        for(int i = 0; i<numCourses;i++){
            if(dfs(map, visited, i, cycle)==false)
                return new int[0];
        }
        // System.out.println(s);
        // if(this.cycle == true)
        //     return topo;
        int i = 0;
        while(!s.isEmpty()){
            topo[i++] = s.pop();
        }
        return topo;
    }
    public boolean dfs(HashMap<Integer,List<Integer>> map, int []visited, int u, boolean[] cycle){
        if(visited[u]==1){
            return true;
        }
        if(cycle[u]==true){
            return false;
        }
        cycle[u] = true;
        if(map.containsKey(u)){
            for(int v : map.get(u)){
                   if(dfs(map,visited,v, cycle)==false)
                        return false;
            }
        }
        visited[u] = 1;

        s.push(u);
        return true;
    }
}
