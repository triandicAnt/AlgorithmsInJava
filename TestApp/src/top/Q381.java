public class Q381{
}

class RandomizedCollection {
    List<Integer> list;
   Map<Integer, Set<Integer>> map;
  Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
       r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain)
            map.put(val, new LinkedHashSet<>());
       map.get(val).add(list.size());
      list.add(val);
      return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
       if(!contain)
         return false;
      int loc = map.get(val).iterator().next();
      map.get(val).remove(loc);
      if(loc!=list.size()-1){
        int temp = list.get(list.size()-1); //2
        list.set(loc, temp); //
        map.get(temp).remove(list.size()-1);
        map.get(temp).add(loc);
      }
      list.remove(list.size()-1);
      if(map.get(val).size()==0)
        map.remove(val);
      return true;
         
    }
  /**
  
  1 1 2 3 4 5 1 2 
  0 1 2 3 4 5 6 7
  2 1 2 3 4 5 1 
  1-0
  
  1 - 1,6
  2 - 2,0
  3 - 3
  4 - 4
  5 - 5
  
  
  */
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
