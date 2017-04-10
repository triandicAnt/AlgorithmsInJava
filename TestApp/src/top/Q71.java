public class Q71 {
   public String simplifyPath(String path) {
    if(path==null || path.length()==0)
        return path;
    Set<String> s = new HashSet<>();
    s.add(".");
    s.add("..");
    s.add("");
    Stack<String> st = new Stack<>();
    String [] arr = path.split("/");
    for(String str: arr){
      if(str.equals("..") && !st.isEmpty())
          st.pop();
      else if(!s.contains(str))
        st.push(str);
    }
    String res = "";
    while(!st.isEmpty()){
      res = "/"+st.pop()+res;
    }
    return res.length()==0?"/":res;
  }
}
