public class Q168 {
    public String convertToTitle(int n) {
        if(n<=0)
            return "";
        StringBuffer sb = new StringBuffer();
        while(n>0){
            n--;
            sb.insert(0, (char)('A'+n%26));
            n/=26;
        }
        return sb.toString();
    }
}
