public class Q44 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)
            return true;
        int m = s.length();
        p = p.replaceAll("\\*+","\\*");
        int n = p.length();
        boolean t[][] = new boolean[m+1][n+1];
        t[0][0] = true;
        if(n>0 && p.charAt(0) == '*')
            t[0][1] = true;
        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    t[i][j] = t[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    t[i][j] = t[i-1][j] || t[i][j-1];
            }
        }
        return t[m][n];
    }
}
