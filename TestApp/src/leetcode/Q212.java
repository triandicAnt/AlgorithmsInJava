public class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        
        if(board.length==0)
            return res;
        TrieNode root = buildTree(words);
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                dfs(board,root,i,j,res);
            }
        }
        return res;
    }
    public void dfs(char[][]board, TrieNode root,int i, int j, List<String> res){
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
    
    public TrieNode buildTree(String [] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode current = root;
            for(char c :word.toCharArray()){
                if(current.next[c-'a']==null)
                    current.next[c-'a'] = new TrieNode();
                current =  current.next[c-'a'];
            }
            current.word = word;
        }
        return root;
    }
    
}
class TrieNode{
    TrieNode next[];
    String word;
    TrieNode(){
        this.next = new TrieNode[26];
    }
}
