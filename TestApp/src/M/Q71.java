public class Q71 {
    public String simplifyPath(String path) {
        if(path == null || path.length()==0)
            return path;
        Set<String> set = new HashSet<>();
        set.add("");
        set.add(".");
        set.add("..");
        Deque<String> stack = new LinkedList<>();
        for(String s : path.split("/")){
            if(s.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!set.contains(s))
                stack.push(s);
        }
        String absPath  = "";
        while(!stack.isEmpty()){
            absPath = "/"+ stack.pop() + absPath;
        }
        if(absPath.length()==0)
            return "/";
        return absPath;
    }
}
