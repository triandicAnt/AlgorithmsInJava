public class Q79 {

    public boolean exist(char[][]mat, String word){
    if(mat == null || mat.length == 0 || mat[0].length == 0 || word == null || word.length() ==0)
      return true;
    int m = mat.length;
    int n = mat[0].length;
    for(int i = 0;i<m;i++){
      for(int j = 0;j<n;j++){
        if(dfs(mat, i,j,0, word))
            return true;
      }
    }
    return false;
  }
  public boolean dfs(char [][] mat, int i, int j ,int index, String word){
    if(index == word.length())
        return true;
    if(!isValid(i,j,mat,word, index))
        return false;
    mat[i][j]^=255;
    boolean result = dfs(mat, i-1,j,index+1,word)||
                      dfs(mat, i, j-1,index+1,word) ||
                    dfs(mat, i+1, j,index+1,word) ||
                    dfs(mat, i, j+1,index+1,word);
    mat[i][j]^=255;
    return result;
  }
  public boolean isValid(int i, int j , char[][]mat, String word, int index){
    if(i<0 || i>=mat.length || j<0 || j>= mat[0].length || mat[i][j]!=word.charAt(index))
        return false;
    return true;
  }
}
