public class WordBreakII {
    HashMap<String, List<String>> map = new HashMap<>();
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null || wordList.size()==0)
            return results;
        Queue<String> q= new ArrayDeque<String>();
        q.offer(beginWord);
        // ladder
        Map<String, Integer> ladder = new HashMap<>();
        for(String s : wordList){
            ladder.put(s, Integer.MAX_VALUE);
        }
        ladder.put(beginWord,0);
        wordList.add(endWord);
        int min = Integer.MAX_VALUE;
        
        // bfs
        while(!q.isEmpty()){
            String temp = q.poll();
            int step = ladder.get(temp)+1;
            if(step>min)
                break;
            for(int i =0; i<temp.length();i++){
                char [] arr = temp.toCharArray();
                for(char c = 'a';c<='z';c++){
                    arr[i] = c;
                    String s = String.valueOf(arr);
                    if(ladder.containsKey(s)){
                        if(step>ladder.get(s)){
                            continue;
                        }else if(step<ladder.get(s)){
                            q.offer(s);
                            ladder.put(s,step);
                        }else;
                        
                        // add to adjacency list
                        if(map.containsKey(s)){
                            map.get(s).add(temp);
                        }else{
                            List<String> l = new ArrayList<>();
                            l.add(temp);
                            map.put(s,l);
                        }
                        if(s.equals(endWord))
                            min = step;
                    }
                }
            }
            
        }
        List<String> res = new ArrayList<>();
        backtrack(endWord,beginWord,res);
        return results;
    }
    public void backtrack(String word, String start, List<String> list){
        if(word.equals(start)){
            list.add(0,word);
            this.results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if(this.map.get(word)!=null){
            for(String s : map.get(word)){
                backtrack(s,start,list);
            }
        }
        list.remove(0);
    }
}
