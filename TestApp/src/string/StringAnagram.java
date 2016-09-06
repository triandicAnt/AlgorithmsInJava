package string;
/**
 * Check whether two strings are Anagram or not
 * @author Sudhansu
 *
 */
public class StringAnagram
{
  static int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
  public static void main(String[] args)
  {
    String str1 = "aab";
    String str2 = "aba";
    checkAnagram(str1, str2);
    System.out.println(arr.length);
  }
  
  public static void checkAnagram(String str1, String str2){
    if (primeHash(str1) == primeHash(str2)){
      System.out.println("anagram");
    }
    else{
            System.out.println("not anagram");
    }
  }
  
  public static long primeHash(String str){
   	long hash = 1;
    for(char c: str.toCharArray()){
      hash = hash*arr[c-'a'];
   }
    return hash;
  }
}
