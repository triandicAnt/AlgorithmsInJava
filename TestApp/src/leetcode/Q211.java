package leetcode;

public class Q211 {
    Trie1 root = new Trie1();
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] arr = word.toCharArray();
        Trie1 current = root;
        for(int i = 0; i<arr.length;i++){
            char c = arr[i];
            if(current.children[c-'a'] == null)
                current.children[c-'a'] = new Trie1();
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
    public boolean searchBackTrack(char [] arr, int n, Trie1 node){
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
class Trie1{
    Trie1 [] children;
    String word;
    public Trie1(){
        children = new Trie1[26];
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
