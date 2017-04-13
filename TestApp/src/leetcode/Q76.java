public class Q76 {
    public String minWindow(String s, String t) {
        if(s==null || t==null)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray())
            map.put(c, 0);
        for(char c:t.toCharArray()){
            if(!map.containsKey(c))
                return "";
            map.put(c, map.get(c)+1);
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int c=t.length();
        while(end<s.length()){
            char c1 = s.charAt(end);
            if(map.get(c1)>0)
                c--;
            map.put(c1, map.get(c1)-1);
            end++;
            while(c==0){
                if(end-start<minLen){
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2)+1);
                if(map.get(c2)>0)
                    c++;
                start++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLen);
    }
}
