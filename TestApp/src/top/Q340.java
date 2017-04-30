class Q340 {
 
  public static void main(String[] args) {
   //System.out.println(getNextPowOf2(6));
   System.out.println(lengthOfLongestSubstringKDistinct("abaabcc",3));

  }
  
 public static int getNextPowOf2(int n){
        if(n==0)
            return 1;
        if((n&(n-1))==0)
            return n;
        while((n&(n-1))>0){
            n = (n&(n-1));
          System.out.println(n);
        }
        return n<<1;
    }
  
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    if(s==null || s.length()==0 || s.length()<k)
        return 0;
    int[] temp = new int[256];
    int i = 0;
    int res = 0;
    int num = 0;
    for(int j=0;j<s.length();j++){
      if(temp[s.charAt(j)]++ == 0){
        num++; 
      }
      while(num>k && i<s.length()){
        temp[s.charAt(i)]--;
        if(temp[s.charAt(i)]==0)
            num --;
        i++;
      }
      res = Math.max(res, j-i+1);
    }
    return res;
  }
}
