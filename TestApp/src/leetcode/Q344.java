/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class Q344 {
    public String reverseString(String s) {
        if(s==null || s.length()<=1)
            return s;
        int l = 0 ;
        int h = s.length()-1;
        char[]c = s.toCharArray();
        while(l<h){
            char temp = c[l];
            c[l] = c[h];
            c[h] = temp;
            l++;
            h--;
        }
        return String.valueOf(c);
    }
}