public class Q409 {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()){
            if(set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        int l = set.size();
        return s.length()-(l==0?0:l-1);
    }
}
