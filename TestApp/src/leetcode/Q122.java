/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Sudhansu
 *
 */
public class Q122 {
	
	public static void main(String[] args) {
		Q122 q = new Q122();
		String s = "a";
		String e = "c";
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(q.ladderLength(s, e, set));
	}
	
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
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
    public List<String> getNeighbors(String str, Set<String> wordList){
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