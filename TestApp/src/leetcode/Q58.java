public class Q58 {
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()<=0)
            return 0;
        String[] sarr = (s).split("\\s+");
        return sarr.length==0?0:sarr[sarr.length-1].length();
    }
}
