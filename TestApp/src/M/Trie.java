public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0 ;i <word.length();i++){
            char c = word.charAt(i);
            TrieNode temp = cur.map.get(c);
            if(temp == null){
                temp = new TrieNode();
                cur.map.put(c,temp);
            }
            cur = temp;
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null)
            return false;
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode temp = cur.map.get(c);
            if(temp==null)
                return false;
            cur = temp;
        }
        return cur.isEnd==true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         if(prefix==null)
            return false;
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            TrieNode temp = cur.map.get(c);
            if(temp==null)
                return false;
            cur = temp;
        }
        return true;
    }
}
class TrieNode{
    Map<Character, TrieNode> map;
    boolean isEnd;
    public TrieNode(){
        this.map = new HashMap<>();
        this.isEnd = false;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
