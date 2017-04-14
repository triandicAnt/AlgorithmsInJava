public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        if(s==null || s.length()==0 || p==null || p.length()==0)
            return l;
        int []hash = new int[256];
        for(char c: p.toCharArray())
            hash[c]++;
        int start = 0;
        int end =0;
        int counter = p.length();
        int len = s.length();
        while(end<len){
            char c = s.charAt(end);
            if(hash[c]>0)
                counter--;
            hash[c]--;
            end++;
            if(counter==0)
                l.add(start);
            if(end-start == p.length()){
                char c1 = s.charAt(start);
                if(hash[c1]>=0)
                    counter++;
                hash[c1]++;
                start++;
            }
        }
        return l;
    }
}
