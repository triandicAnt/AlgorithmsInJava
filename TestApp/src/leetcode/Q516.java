public class Q516 {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0)
            return 0;
        int n = s.length();
        int [][] temp = new int[n][n];
        // for length 1
        for(int i = 0; i<n ;i++){
            temp[i][i] = 1;
        }
        // for lenght 2
        for(int i = 0; i<n-1 ; i++){
            if(s.charAt(i)==s.charAt(i+1))
                temp[i][i+1]=2;
            else
                temp[i][i+1]=1;
        }
        // for length 3 or more
        for(int l = 3; l<=n;l++){
            for(int i = 0; i<=n-l;i++){
                int j = i+l-1;
                if(s.charAt(i)==s.charAt(j)){
                    temp[i][j] = 2 + temp[i+1][j-1];
                }else{
                    temp[i][j] = Math.max(temp[i][j-1],temp[i+1][j]);
                }
            }
        }
        return temp[0][n-1];
    }
}
