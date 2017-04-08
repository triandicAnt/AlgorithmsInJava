public class Q151 {
   public static String reverseWords(String s) {
     if(s==null)
        return s;
      s = s.trim();
    int i = 0;
    char [] a = s.toCharArray();
    int j = i+1;
   while(j<a.length){
     while(j<a.length && a[j]!=' ')
      j++;
     reverse(a,i,j-1);
     while(j<a.length&& a[j]== ' ')
       j++;
     i = j;
   }
   reverse(a,i,j-1);
   reverse(a,0,a.length-1);
  return String.valueOf(a).replaceAll(" +", " ");
  }
  public static void reverse(char [] a , int i, int j ){
    while(i<j){
      a[i]^=a[j];
      a[j]^=a[i];
      a[i]^=a[j];
      i++;
      j--;
    }
  }
}
