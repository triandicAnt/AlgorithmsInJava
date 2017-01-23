public class Q459 {
    public boolean repeatedSubstringPattern(String str) {
        if(str==null || str.length()==0)
            return true;
        int l = str.length();
        for(int i = l/2; i>=1;i--){
            if(l%i==0){
                int n = l/i;
                int j=0;
                String sub = str.substring(0,i);
                for(j=1;j<n;j++){
                    if(!str.substring(j*i, j*i+i).equals(sub))
                        break;
                }
                if(j==n)
                    return true;
            }
        }
        return false;
    }
}
