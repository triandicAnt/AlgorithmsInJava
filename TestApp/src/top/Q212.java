public class Q212 {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> list = new ArrayList<>();
        if(board == null || board.length==0 || board[0].length == 0 || words == null || words.length==0)
          return list;
    Trie root = buildTree(words);
    int m = board.length;
    int n = board[0].length;
    for(int i = 0;i<m;i++){
      for(int j = 0; j<n;j++){
        dfs(board, i,j,root, list, 0); 
      }
    }
    return list;
          
  }
  public void dfs(char[][]mat, int i, int j, Trie root, List<String> list, int index){
    char c = mat[i][j];
    if(c == '*' || root.children[c-'a'] == null)
      return;
    root = root.children[c-'a'];
    if(root.word!=null){
      list.add(root.word);
      root.word = null;
    }
    mat[i][j] = '*';
    if(i>0)
        dfs(mat, i-1,j,root,list,index+1);
    if(i<mat.length-1)
       dfs(mat, i+1,j,root, list, index+1);
    if(j>0)
        dfs(mat, i,j-1,root,list,index+1);
    if(j<mat[0].length-1)
       dfs(mat, i,j+1,root, list, index+1);
    mat[i][j] = c;
  }
  
  public Trie buildTree(String [] words){
    Trie root = new Trie();
    for(String word : words){
      Trie cur = root;
      for(char c : word.toCharArray()){
        if(cur.children[c-'a'] == null)
            cur.children[c-'a'] = new Trie();
        cur = cur.children[c-'a'];
      }
      cur.word = word;
    }
    return root;
  }
}
class Trie{
  String word;
  Trie[] children;
  
  public Trie(){
    children = new Trie[26]; 
  }
}
