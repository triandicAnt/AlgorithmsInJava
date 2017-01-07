package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        
        if(board.length==0)
            return res;
        TrieNode1 root = buildTree(words);
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                dfs(board,root,i,j,res);
            }
        }
        return res;
    }
    public void dfs(char[][]board, TrieNode1 root,int i, int j, List<String> res){
        char c = board[i][j];
        if(c=='*'||root.next[c-'a']==null)
            return;
        root = root.next[c-'a'];
        if(root.word!=null){
            res.add(root.word);
            //remove from trie to avoid duplicates
            root.word=null;
        }
        board[i][j] = '*';
        if(i>0)
            dfs(board,root,i-1,j,res);
        if(j>0)
            dfs(board,root,i,j-1,res);
        if(i<board.length-1)
            dfs(board,root,i+1,j,res);
        if(j<board[0].length-1)
            dfs(board,root,i,j+1,res);
        board[i][j] = c;    
            
    }
    
    public TrieNode1 buildTree(String [] words){
        TrieNode1 root = new TrieNode1();
        for(String word : words){
            TrieNode1 current = root;
            for(char c :word.toCharArray()){
                if(current.next[c-'a']==null)
                    current.next[c-'a'] = new TrieNode1();
                current =  current.next[c-'a'];
            }
            current.word = word;
        }
        return root;
    }
    
}
class TrieNode1{
    TrieNode1 next[];
    String word;
    TrieNode1(){
        this.next = new TrieNode1[26];
    }
}
