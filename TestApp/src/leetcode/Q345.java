/**
 * 
 */
package leetcode;

import java.util.HashSet;

/**
 * @author Sudhansu
 *
 */
public class Q345 {
    public String reverseVowels(String s) {
        if(s==null || s.length()<=1)
            return s;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
         set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] arr = s.toCharArray();
        int l = 0;
        int h = s.length()-1;
        while(l<h){
            while(l<s.length()-1 && !set.contains(arr[l]) ){
                l++;
            }
            while(h>=0 && !set.contains(arr[h])){
                h--;
            }
            if(l>=h)
                break;
            char c = arr[l];
            arr[l] = arr[h];
            arr[h] = c;
            l++;
            h--;
        }
        return String.valueOf(arr);
    }
}