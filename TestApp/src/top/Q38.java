public class Q38 {
    public String countAndSay(int n) {
        if(n<=0)
            return "";
        String res = "1";
        for(int i = 1;i<n;i++){
            String prev = res;
            res = "";
            int count = 1;
            char say = prev.charAt(0);
            for(int j = 1;j<prev.length();j++){
                if(prev.charAt(j)!=say){
                    res = res+count+say;
                    count = 1;
                    say = prev.charAt(j);
                }else
                    count++;
            }
            res = res+count+say;
        }
        return res;
    }
}
