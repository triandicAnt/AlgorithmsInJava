public class Q28 {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null || haystack.length()<needle.length())
            return -1;
        if(needle.length()==0)
            return 0;
            
        String s= haystack;
        String prefix = needle;
        int []preArr = prefixArray(prefix);
        int m = s.length();
        int n = preArr.length;
        int i=0,j=0;
        int start=0;
        while(i<m && j<n){
            if(s.charAt(i)==prefix.charAt(j)){
                i++;
                j++;
            }else{
                if(j>0)
                    j = preArr[j-1];
                else 
                    i++;
                if(j==0 && i<m)
                    start = i;
                else
                    start = i-j;
            }
        }
        return start<m && j==n?start:-1;
    }
    
    public int[]prefixArray(String s){
        int n = s.length();
        int []arr = new int [n];
        int j =0;
        for(int i =1;i<n;){
            if(s.charAt(i)==s.charAt(j)){
                arr[i] = j+1;
                i++;
                j++;
            }else{
                if(j>0)
                    j = arr[j-1];
                else
                    i++;
            }
        }
        return arr;
    }
    
}
