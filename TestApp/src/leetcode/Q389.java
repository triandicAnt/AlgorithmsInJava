public class Q389 {
    public char findTheDifference(String s, String t) {
        if(s==null || s.length()==0)
            return t.length()>0?t.charAt(0):'a';
        if(t==null || t.length()==0)
            return s.length()>0?s.charAt(0):'a';
        int [] arr = new int [26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c : t.toCharArray()){
            arr[c-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0 || arr[i]>0)
                return (char)(i+'a');
        }
        return 'a';
    }
}
