public class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random r ;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if(!contains)
            map.put(val, new LinkedHashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contains = map.containsKey(val);
        if(!contains)
            return false;
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if(loc!=list.size()-1){
            int temp = list.get(list.size()-1);
            list.set(loc, temp);
            map.get(temp).remove(list.size()-1);
            map.get(temp).add(loc);
        }
        list.remove(list.size()-1);
        if(map.get(val).size()==0)
            map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
