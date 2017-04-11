public class Q332 {
     public List<String> findItinerary(String[][] tickets) {
   if(tickets==null || tickets.length==0)
      return new ArrayList<String>();
   Map<String, PriorityQueue<String>> map = new HashMap<>();
   for(String[]s: tickets){
      PriorityQueue<String> pq = map.getOrDefault(s[0], new PriorityQueue<String>());
      pq.add(s[1]);
      map.put(s[0],pq);
   }
   List<String> l = new ArrayList<>();
   dfs("JFK", map,l);
   return l;
  }
  public void dfs(String start,Map<String, PriorityQueue<String>> map, List<String> l){
    while(map.containsKey(start) && map.get(start).size()>0)
        dfs(map.get(start).poll(),map,l);
    l.add(0,start);
  }
}
