public class Q5 {
   public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return s;
        int n = s.length();
        int start = 0;
        int maxLen = 0;
        boolean temp[][] = new boolean[n][n];
        for(int i = 0;i<n;i++){
            temp[i][i] = true;
             start = i;
            maxLen = 1;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                temp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        for(int l=3;l<=n;l++){
            for(int i = 0; i<=n-l;i++){
                int j = i+l-1;
                if(s.charAt(i) == s.charAt(j) && temp[i+1][j-1]==true){
                    start = i;
                    maxLen = l;
                    temp[i][j] = true;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
    public String longestPalindromeRec(String s){
    
     int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
    }

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

}
