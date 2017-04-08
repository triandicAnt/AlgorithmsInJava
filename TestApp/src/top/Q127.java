public class Q127 {
   /*  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
  
    if(wordList == null || !wordList.contains(endWord))
        return 0;
    int count = 1;
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    wordList.remove(beginWord);
    while(!q.isEmpty()){
      int size = q.size();
      for(int i = 0;i <size;i++){
          String s = q.poll();
          if(s.equals(endWord))
            return count;
          List<String> ne = getNeighbors(s, wordList);
          //System.out.println(ne);
          for(String n : ne)
              q.offer(n);
      }
      count++;
    }
    return 0;
  }
  public List<String> getNeighbors(String s, List<String> list){
    List<String> res = new ArrayList<>();
    for(int i = 0; i<s.length();i++){
      for(char c = 'a'; c<='z';c++){
        char[] a = s.toCharArray();
        a[i] = c;
        if(list.remove(String.valueOf(a)))
            res.add(String.valueOf(a));
      }
    }
    return res;
  }
  */
public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if(beginWord == null || endWord==null || wordList == null || !wordList.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
       // wordList.add(endWord);
        wordList.remove(beginWord);
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord))
                    return dist;
                List <String> list = getNeighbors(word,wordList);
               // System.out.println(list);
                for(String s : list){
                    q.offer(s);
                }
            }
            dist++;
        }
        return 0;
    }
    public List<String> getNeighbors(String str, List<String> wordList){
        List<String> list = new ArrayList<>();
        for(int i = 0 ;i<str.length();i++){
            char [] arr = str.toCharArray();
            for(char c = 'a';c<='z';c++){
                arr[i] = c;
                String s = new String(arr);
                if(wordList.remove(s)){
                    list.add(s);
                }
            }
         }
         return list;
    }
}
