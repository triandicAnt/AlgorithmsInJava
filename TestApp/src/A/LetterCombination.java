public class LetterCombination {
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
        dfs(digits,0,sb,map,list);
        return list;
    }
    public void dfs(String digits, int step, StringBuffer sb, HashMap<Character, String>map, List<String>list){
        if(step==digits.length())
        {
            list.add(sb.toString());
            return;
        }
        String str = map.get(Character.valueOf(digits.charAt(step)));
        for(int i=0; i<str.length();i++){
            sb.append(str.charAt(i));
            dfs(digits,step+1,sb,map,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}
