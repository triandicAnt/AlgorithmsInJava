package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Q71 {
    public String simplifyPath(String path) {
        if(path==null || path.length() == 0)
            return "/";
        Set<String> set = new HashSet<>();
        set.add("");
        set.add(".");
        set.add("..");
        Deque<String> stack = new LinkedList<>();
        for(String str : path.split("/")){
            if(str.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!set.contains(str)){
                stack.push(str);
            }
        }
        String absPath = "";
        for(String s: stack){
            absPath = "/" + s + absPath;
        }
        if(absPath.equals(""))
            return "/";
        else
            return absPath;
    }
}
