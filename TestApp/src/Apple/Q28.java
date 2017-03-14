public class Q28 {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null || haystack.length()<needle.length())
            return -1;
        if(needle.equals(""))
            return 0;
        else if(haystack.equals("") && !needle.equals(""))
            return -1;
        else if(haystack.equals(needle))
            return 0;
        int []temp = prefixArray(needle);
        System.out.println(Arrays.toString(temp));
        int start = 0;
        int i = 0;
        int j = 0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                if(j>0)
                    j = temp[j-1];
                else{
                    i++;
                }
                start = i-j;
            }
        }
        return j==needle.length()?start:-1;
    }
    public int [] prefixArray(String s){
        if(s==null || s.length()==0)
            return new int[0];
        int []temp = new int[s.length()];
        int j = 0;
        int i = 1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                temp[i] = j+1;
                i++;
                j++;
            }else{
                if(j>0)
                    j = temp[j-1];
                else
                    i++;
            }
        }
        return temp;
    }
}
