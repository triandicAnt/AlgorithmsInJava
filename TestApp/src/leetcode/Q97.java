package leetcode;

public class Q97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1+n2!=n3)
            return false;
        if(n1==0 && !s2.equals(s3))
            return false;
       if(n2==0 && !s1.equals(s3))
            return false; 
        boolean temp [][] = new boolean [n1+1][n2+1];
        temp[0][0] = true;
        for(int i = 1 ;i<temp.length;i++){
            temp[i][0] = temp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for(int i = 1 ;i<temp[0].length;i++){
            temp[0][i] = temp[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int i = 1; i<temp.length;i++){
            for(int j = 1; j<temp[0].length;j++){
                temp[i][j] = (temp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1))) || 
                                (temp[i][j-1] &&(s2.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        return temp[n1][n2];
    }
}
