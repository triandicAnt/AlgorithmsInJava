public class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
   if(endWord == null || beginWord == null || wordList == null || wordList.size()==0)
      return res;
   
   // create ladder
   Map<String, Integer> ladder = new HashMap<>();
   for(String s : wordList)
      ladder.put(s, Integer. MAX_VALUE);
   ladder.put(beginWord, 0);
   Queue<String> q = new ArrayDeque<>();
   q.offer(beginWord);
   int min = Integer.MAX_VALUE;
   
   while(!q.isEmpty()){
      String temp = q.poll();
      int step = ladder.get(temp) +1;
     if(step>min)
        break;
     for(int i = 0 ;i <temp.length();i++){
       
       for(char c = 'a';c<='z'; c++){
        char [] ca = temp.toCharArray();
        ca[i] = c;
         String s = String.valueOf(ca);
         if(ladder.containsKey(s)){
          
           if(step> ladder.get(s))
              continue;
           else if(step<ladder.get(s)){
             q.offer(s);
             ladder.put(s, step);
           }
           
           // create adjacency list
           List<String> l = map.getOrDefault(s, new ArrayList<>());
           l.add(temp);
           map.put(s, l);
           
           // update min
           if(s.equals(endWord))
              min = step;
         }
       }
     }
   }
   //backtrack
   backtrack(endWord, beginWord, new ArrayList<>());
   return res;
 }
 
  public void backtrack(String word, String start, List<String> list){
    if(word.equals(start)){
      list.add(0,word);
      res.add(new ArrayList<>(list));
      list.remove(0);
    }else{
      list.add(0,word);
      for(String s : map.getOrDefault(word, new ArrayList<>())){
        backtrack(s, start, list);
      }
      list.remove(0);
    }
  }
  
  
}
