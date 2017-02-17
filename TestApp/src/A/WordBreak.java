public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0)
            return true;
        int n = s.length();
        boolean [][] temp = new boolean[n][n];
        //for length 1
        for(int i = 0; i<n;i++){
            if(wordDict.contains(s.substring(i,i+1)))
                temp[i][i] = true;
        }
     
        
        // for len 2 to n
        for(int l = 2; l<=n;l++){
            for(int i = 0; i<=n-l;i++){
                int j = i+l-1;
                if(wordDict.contains(s.substring(i,j+1)))
                    temp[i][j] = true;
                else{
                    for(int k =0;k<l;k++){
                        if(temp[i][i+k]==true && temp[i+k+1][j]==true){
                            temp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return temp[0][n-1];
    }
}
