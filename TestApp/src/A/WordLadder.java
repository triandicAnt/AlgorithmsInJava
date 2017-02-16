
/*public class Solution {
    
   /* 
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        wordList.add(endWord);
        int d = 1;
        while(!visited.contains(endWord)){
        
            Set<String> neighbors = new HashSet<>();
            for(String s:visited){
                for(int i = 0; i<s.length();i++){
                    char[]arr = s.toCharArray();
                    for(char c = 'a';c<='z';c++){
                        arr[i] = c;
                        String temp = new String(arr);
                        if(wordList.contains(temp)){
                            neighbors.add(temp);
                            wordList.remove(temp);
                        }
                    }
                }
            }
            d++;
            if(neighbors.size()==0)
                return 0;
            visited = neighbors;
        }
        return d;
       
    }
}

  
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord==null || wordList == null)
            return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord))
                    return dist;
                List <String> list = getNeighbors(word,wordList);
                System.out.println(list);
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
*/

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        if(!wordList.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String temp = q.poll();
                if(temp.equals(endWord)){
                    System.out.println(temp + " "+endWord);
                    return count;
                }
                List<String> neighbors = getNeighbors(temp,wordList);
                for(String s : neighbors){
                    q.offer(s);
                }
            }
            count++;
        }
        return 0;
    }
    public List<String> getNeighbors(String temp, List<String> list){
        List<String> res = new ArrayList<>();
        for(int i = 0 ;i<temp.length();i++){
            char[]arr = temp.toCharArray();
            for(char c = 'a';c<='z';c++){
                arr[i]=c;
                String str = new String(arr);
                if(list.remove(str)){
                   // list.remove(str);
                    res.add(str);
                }
            }
        }
        return res;
    }
}
