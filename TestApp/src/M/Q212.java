public class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if(board==null || board.length==0 || board[0].length == 0 || words==null || words.length==0)
            return list;
        Trie root = buildTree(words);
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,root,list);
            }
        }
        return list;
    }
    public void dfs(char[][] board, int i, int j,Trie root, List<String>list){
        char c = board[i][j];
        if(c=='*' || root.next[c-'a']==null)
            return;
       root = root.next[c-'a'];

        if(root.word!=null)
        {
            list.add(new String(root.word));
            root.word = null;
            //return;
        }
        board[i][j] = '*';
        int m = board.length;
        int n = board[0].length;
        if(i>0)
            dfs(board,i-1,j,root,list);
        if(j>0)
            dfs(board,i,j-1,root,list);
        if(i<m-1)
            dfs(board,i+1,j,root,list);
        if(j<n-1)
            dfs(board,i,j+1,root,list);
        board[i][j] = c;
    }
    
    
    public Trie buildTree(String[] words){
        Trie root = new Trie();
        for(String word : words){
            Trie current = root;
            for(char c :word.toCharArray()){
                if(current.next[c-'a']==null)
                    current.next[c-'a'] = new Trie();
                current =  current.next[c-'a'];
            }
            current.word = word;
        }
return root;
    }
    
    
}
class Trie{
        String word;
        Trie[] next;
        Trie(){
            this.word = null;
            this.next = new Trie[26];
        }
    }
