public class Q387 {
    public int firstUniqChar(String s) {
        int[] temp = new int[26];
        for(char c: s.toCharArray()){
            temp[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(temp[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
        
    }
}
