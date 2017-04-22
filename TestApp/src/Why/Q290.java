public class Q290 {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length()==0 || str==null || str.length()==0)
            return false;
        Map<Object, Integer> map = new HashMap<>();
        String [] s = str.split("\\s+");
        if(s.length!=pattern.length())
            return false;
        Integer i = 0;
        for(char c : pattern.toCharArray()){
            if(map.put(c, i)!=map.put(s[i],i))
                return false;
            i=i+1;
        }
        return true;
    }
}
