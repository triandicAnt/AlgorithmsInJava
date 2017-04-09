public class Q10 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)
            return true;
        int m = s.length();
        int n = p.length();
        boolean [][] T = new boolean [m+1][n+1];
        T[0][0] = true;
        // handle a*, a*b*
        for(int i = 1; i<=n;i++){
            if(p.charAt(i-1) == '*')
            T[0][i] = T[0][i-2];
        }
        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.')
                    T[i][j] = T[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    boolean flag = T[i][j-2];
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) == '.')
                        flag = flag || T[i-1][j];
                    T[i][j] = flag;
                }
            }
        }
        return T[m][n];
    }
}
