public class Q49 {
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        int []  primes = {2, 41, 37, 47, 3, 67, 71, 23, 5, 101, 61, 17, 19, 13, 31, 43, 97, 29, 11, 7, 73, 83, 79, 89, 59, 53};
        List<List<String>> list = new ArrayList<>();
        
        if(strs.length==0)
            return list;
        HashMap<Integer,List<String>> map = new HashMap<>();
        for(String s:strs){
            int x=1;
            
            for(char c:s.toCharArray()){
              x*=primes[c-97];
            }
            if(map.containsKey(x)){
                List<String> lst = map.get(x);
                lst.add(s);
                map.put(x,lst);
            }else{
                List<String> lst = new ArrayList<>();
                lst.add(s);
                map.put(x,lst);
            }
        }
        for(int l:map.keySet()){
            list.add(map.get(l));
        }
        return list;
    }
    */
     public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs==null || strs.length == 0)
            return list;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for(String word: strs){
          char[] ca  = word.toCharArray();
          Arrays.sort(ca);
          String s = String.valueOf(ca);
          List<String> l = map.getOrDefault(s,new ArrayList<String>());
          l.add(word);
          map.put(s,l);
        }
        System.out.println(map);
        for(List<String> l : map.values())
          list.add(new ArrayList<>(l));
        return list;
      }
}
