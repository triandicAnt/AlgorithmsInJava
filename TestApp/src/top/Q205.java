public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null)
            return s==t;
        if(s.length()!=t.length())
            return false;
        //return isomore(s).equals(isomore(t));
        int [] a1 = new int[256];
        int a2[] = new int[256];
        for(int i = 0; i<s.length();i++){
            if(a1[s.charAt(i)]!=a2[t.charAt(i)])
                return false;
            a1[s.charAt(i)] = i+1;
            a2[t.charAt(i)] = i+1;
        }
        return true;
        
    }
    public String isomore(String s){
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        String str = "";
        for(char c: s.toCharArray()){
            if(map.containsKey(c))
                str+=map.get(c);
            else{
                map.put(c, count++);
                str+=map.get(c);
            }
        }
        return str;
    }
}
