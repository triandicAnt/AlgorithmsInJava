public class Q139 {
  

   public boolean wordBreak(String s, List<String> wordDict) {
   
       if(s==null || s.length()==0)
            return true;
        int n = s.length();
        boolean[] temp = new boolean[n+1];
        temp[0] = true;
        for(int i = 1;i<=n;i++){
            for(int j = 0; j<i ; j++){
                if(temp[j] && wordDict.contains(s.substring(j,i))){
                    temp[i] = true;
                    break;
                }
            }
        }
       return temp[n];
   } 
   /*
 public boolean wordBreak(String s, List<String> wordDict) {
   
       if(s==null || s.length()==0)
            return true;
       int n = s.length();
       boolean temp [][] = new boolean[n][n];
       // 1
       for(int i = 0;i<n;i++){
           if(wordDict.contains(String.valueOf(s.charAt(i))))
            temp[i][i] = true;
       }
        for(int l =2;l<=n;l++){
            for(int i = 0; i<=n-l;i++){
                int j = i+l-1;
                if(wordDict.contains(s.substring(i,j+1)))
                    temp[i][j] = true;
                else{
                    for(int k = i;k<j;k++){
                        if(temp[i][k] && temp[k+1][j]){
                            temp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
       return temp[0][n-1];
   }*/
}
