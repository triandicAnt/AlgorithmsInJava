public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if(s==null || s.length()==0)
            return list;
        backtrack(list, s, new ArrayList<String>(), 0);
        return list;
    }
    public void backtrack(List<List<String>> list, String s, List<String> temp, int index){
        if(index == s.length()){
            list.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = index; i<s.length();i++){
            if(isPalindrome(s,index, i)){
                temp.add(s.substring(index, i+1));
                backtrack(list, s, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int l, int h){
        while(l<h){
            if(s.charAt(l)!=s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
}
