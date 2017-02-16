public class ValidParanthesis {
    public boolean isValid(String s) {
        if(s==null || s.length()==0)
            return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.size()>0 && (map.containsKey(st.peek()) && map.get(st.peek())==c)){
                st.pop();
                continue;
            }
            st.push(c);
        }
        return st.size()==0;
    }
}
