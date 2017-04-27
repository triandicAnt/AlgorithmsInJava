public class Q395 {
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0 || k==0 || s.length()<k)
            return 0;
        int n = s.length();
        if(k==1)
            return n;
        int []count = new int [26];
        for(char c: s.toCharArray()){
            count[c-'a'] += 1;
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i<n;i++){
            if(count[s.charAt(i)-'a']<k)
                l.add(i);
        }
        int max = 0;
        if(l.size()==0)
            return n;
        l.add(0, -1);
        l.add(n);
        for(int i = 1; i<l.size();i++){
            int start = l.get(i-1)+1;
            int end = l.get(i);
            max = Math.max(max, longestSubstring(s.substring(start, end),k));
        }
        return max;
    }
}
