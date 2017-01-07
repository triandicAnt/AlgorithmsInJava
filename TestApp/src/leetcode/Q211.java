public class Q211 {
    Trie root = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] arr = word.toCharArray();
        Trie current = root;
        for(int i = 0; i<arr.length;i++){
            char c = arr[i];
            if(current.children[c-'a'] == null)
                current.children[c-'a'] = new Trie();
            current = current.children[c-'a'];
        }
        current.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char [] arr = word.toCharArray();
        return searchBackTrack(arr, 0,root);
    }
    public boolean searchBackTrack(char [] arr, int n, Trie node){
        if(n== arr.length)
            return (node.word!=null);
        char c = arr[n];
        if(c!='.')
            return node.children[c-'a']!=null && searchBackTrack(arr,n+1,node.children[c-'a']); 
        else{
            for(int i =0;i<node.children.length;i++){
                if(node.children[i]!=null)
                    if(searchBackTrack(arr, n+1, node.children[i]) == true)
                        return true;
            }
        }
        return false;
    }
}
class Trie{
    Trie [] children;
    String word;
    public Trie(){
        children = new Trie[26];
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
