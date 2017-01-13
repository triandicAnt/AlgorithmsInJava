package leetcode;

public class Q151 {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
            return s;
        if(s.trim().equals(""))
            return s.trim();
        s = s.trim();
        String [] sarr = s.split("\\s+");
        int i = 0;
        for(String a: sarr){
            sarr[i++] = reverseString(a.toCharArray(), 0, a.length()-1);
        }
        StringBuffer sb = new StringBuffer();
        for(String str:sarr){
            sb.append(str);
            sb.append(" ");
        }
        int n = sb.length()-1;
        return reverseString(sb.toString().substring(0,n).toCharArray(),0,n-1);
        // char[] arr = s.toCharArray();
        // int a = 0;
        // int b = 0;
        // while(b<arr.length){
        //     if(arr[b]==' ')
        //     {
        //         a++;
        //         b++;
        //         continue;
        //     }
        //     while(b<arr.length && arr[b]!=' '){
        //         b++;
        //     }
        //     //temp = b;
        //   // b = b-1;
        //     reverseString(arr, a, b-1);
        //     a=b;
        // }
      //  reverseString(arr, 0, arr.length-1);
        //return  String.valueOf(arr);
    }
    
    public String reverseString(char[] s, int low, int high){
        while(low<high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(s);
    }
}
