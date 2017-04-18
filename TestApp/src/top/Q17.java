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
        dfs(digits, map, list, 0, "");
        return list;
    }
    public void dfs(String digits, Map<Character, String> map, List<String> list, int index, String temp){
        if(digits.length()==temp.length()){
            list.add(temp);
            return;
        }
        char c = digits.charAt(index);
        String t = map.get(c);
        for(char ch : t.toCharArray()){
            dfs(digits, map, list, index+1, temp + ch);
        }
    }

    
}
