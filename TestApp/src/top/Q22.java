public class Q22 {
     public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        if(n<=0)
            return l;
        dfs(l,"",n,n);
        return l;
    }
    public void dfs(List<String> list, String s, int l, int r){
      if(l>r)
          return;
        if(l==0 && r==0)
            list.add(s);
        if(l>0)
            dfs(list, s+"(",l-1,r);
        if(r>0)
            dfs(list,s+")", l, r-1);
    }
   
}
