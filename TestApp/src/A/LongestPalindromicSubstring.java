public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return s;
        int n = s.length();
        boolean [][]temp = new boolean[n][n];
        int start = 0;
        int max = 0;
        for(int i = 0; i<n;i++){
            temp[i][i] = true;
            start = i;
            max = 1;
        }
        for(int i = 0; i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                temp[i][i+1] = true;
                start = i;
                max = 2;
            }
        }
        for(int l = 3; l<=n;l++){
            for(int i = 0; i<=n-l;i++){
                int j = i+l-1;
                if(s.charAt(i)==s.charAt(j) && temp[i+1][j-1]==true){
                    temp[i][j]=true;
                    start = i;
                    max = l;
                }
            }
        }
        System.out.println(start + " " + max);
        return s.substring(start,start+max);
    }
}
