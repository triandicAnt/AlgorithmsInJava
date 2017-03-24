public class Q13 {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        int n = s.length()-1;
        int res = 0;
        for(int i = n;i>=0;i--){
            if(s.charAt(i)=='I')
                res += (res>=5)?-1:1;
            else if(s.charAt(i)=='V')
                res += 5;
             else if(s.charAt(i)=='X')
                res += 10*(res>=50?-1:1);
             else if(s.charAt(i)=='L')
                res += 50;
             else if(s.charAt(i)=='C')
                res += 100*(res>=500?-1:1);
            else if(s.charAt(i)=='D')
                res += 500;
             else if(s.charAt(i)=='M')
                res += 1000;
        }
        return res;
    }
}
