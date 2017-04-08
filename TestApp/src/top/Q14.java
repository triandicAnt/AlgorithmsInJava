public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
        return "";
        if(strs.length==1)
            return strs[0];
       String max = "";
       for(int i = 1;i<strs.length;i++){
         String pre = longest(strs[i],strs[i-1]);
         if(i==1)
            max = pre;
         if(pre.length()<max.length())
            max = pre;
       }
       return max;
 }
  public String longest(String a, String b){
    int n = Math.min(a.length(), b.length());
    for(int i = 0;i<n;i++){
      if(a.charAt(i)!=b.charAt(i))
        return a.substring(0,i);
    }
    return a.substring(0,n);
  }
}
