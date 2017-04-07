public class Q17 {
    public List<String> letterCombinations(String digits) {
        
        List<String> list = new ArrayList<String>();
        HashMap<Character, String> map = new HashMap<>();
        if(digits == null || digits.length()<1)
            return list;
        map.put('0', " ");
        map.put('2',"abc");
        map.put('1', "");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuffer sb = new StringBuffer();
        // dfs
        dfs(digits,sb,list,0,map);
        return list;
    }
    public void dfs(String digits, StringBuffer sb, List<String> list, int step, Map<Character, String> map){
        if(step == digits.length()){
            list.add(sb.toString());
            return;
        }
        char c = digits.charAt(step);
        String s = map.get(c);
        for(int i = 0;i<s.length();i++){
            sb.append(s.charAt(i));
            dfs(digits,sb,list,step+1,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    
}
