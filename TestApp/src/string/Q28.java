/**
 * 
 */
package string;

import java.util.Arrays;

/**
 * @author Sudhansu
 *
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        if(haystack==null || haystack.length()==0){
            if(needle == null || needle.length()==0)
                return 0;
            return -1;
        }
        if(needle == null || needle.length()==0)
            return 0;
        if(haystack.length()<needle.length())
            return -1;
            
        String prefix = needle;
        String str = haystack;
        int [] prefixArray = prefixArray(prefix);
        System.out.println(Arrays.toString(prefixArray));
        int start = 0;
        int i = 0, j = 0;
        while(i<str.length() && j<prefix.length()){
            if(str.charAt(i) == prefix.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = prefixArray[j-1];
                }else{
                    i++;
                }
                if(j==0 && i<str.length())
                    start = i;
                else
                    start = i-j;
            }
        }
        return (start<str.length() && j == prefix.length())?start:-1;
    }
    public int [] prefixArray(String prefix){
        int [] arr = new int [prefix.length()];
        int j = 0;
        for(int i = 1; i<prefix.length();){
            if(prefix.charAt(i) == prefix.charAt(j)){
                arr[i] =  j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j = arr[j-1];
                }else{
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return arr;
    }
}