public class Q91 {
    public int numDecodings(String s) {
        if(s==null|| s.length()==0)
            return 0;
        int n = s.length();
        int[] temp = new int[n+1];
        temp[n] = 1;
        temp[n-1] = s.charAt(n-1)!='0'?1:0;
        for(int i = n-2;i>=0;i--){
            if(s.charAt(i)=='0')
                continue;
            temp[i] = Integer.parseInt(s.substring(i, i+2))<=26?temp[i+1]+temp[i+2]:temp[i+1];
        }
        return temp[0];
    }
}
