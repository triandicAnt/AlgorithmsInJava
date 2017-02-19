public class ReverseWords {
   /* public String reverseWords(String s) {
        if(s==null)
            return s;
        s = s.trim();
        if(s.length()==0)
            return "";
        int i =0;
        int n = s.length();
        int j = i;
        while(j+1<n){
            while(j+1<n && s.charAt(j+1)!=' ')
                j++;
            s = reverse(s,i,j);
            
            i = j+1;
            while(i<n && s.charAt(i)==' ')
                i++;
            j = i;    
        }
        s = reverse(s, 0, n-1);
        return s.replaceAll(" +", " ");
        
    }
    */
    
    public String reverseWords(String s) {
        if(s==null)
            return s;
        s = s.trim();
        if(s.length()==0)
            return "";
        int i =0;
        int n = s.length();
        for(int j = 0; j<n;j++){
            if(s.charAt(j) == ' '){
                s = reverse(s,i,j-1);
                i = j+1;
            }
        }
        s = reverse(s,i,n-1);
        s = reverse(s, 0, n-1);
        return s.replaceAll(" +", " ");
        
    }
    
    public String reverse(String s, int l, int r){
        if(l>=r)
            return s;
        char [] arr = s.toCharArray();
        while(l<r){
            char temp = s.charAt(l);
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(arr);
    }
}
