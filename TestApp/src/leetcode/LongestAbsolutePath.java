/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author Sudhansu
 *
 */
public class LongestAbsolutePath {

public int lengthLongestPath(String input) {
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int maxLen = 0;
        for(String str:input.split("\n")){
            // find number of tabs in string
            int level = str.lastIndexOf("\t")+1;
            // find parent
            while(level+1<stack.size())
                stack.pop();
            int len = stack.peek()+str.length()-level+1; // parent len + string length - tabs+ /
            stack.push(len);
            //if it is a file calculate max length
            if(str.contains("."))
                maxLen = Math.max(maxLen,stack.peek()-1); // remove extra /
        }
        return maxLen;
    }
}
