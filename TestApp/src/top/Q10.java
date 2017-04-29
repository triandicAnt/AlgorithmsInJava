public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p == null)
            return false;
        int m = s.length();
        int n = p.length();
        boolean [][]temp = new boolean[m+1][n+1];
        temp[0][0] = true;
        for(int i = 2; i<=n;i++){
            if(p.charAt(i-1)=='*')
                temp[0][i] = temp[0][i-2];
        }
        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    temp[i][j] = temp[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    boolean flag = false;
                    if(j>1){
                        flag = temp[i][j-2];
                        if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                        flag |= temp[i-1][j];
                    }
                    temp[i][j] = flag;
                }
            }
        }
        return temp[m][n];
    }
}
