public class Q241 {
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length()==0)
            return new ArrayList<Integer>();
        return dfs(input, new HashMap<String, List<Integer>>());
    }
   
    private List<Integer> dfs(String input, Map<String, List<Integer>> map){
      if(map.containsKey(input))
          return map.get(input);
      List<Integer> l = new ArrayList<>();
      for(int i =0; i<input.length();i++){
        char c = input.charAt(i);
        if(c=='*'||c=='+'||c=='-'){
          List<Integer> pre = dfs(input.substring(0,i),map);
          List<Integer> post = dfs(input.substring(i+1),map);
          for(int a:pre){
            for(int b:post){
              if(c=='*')
                l.add(a*b);
              else if(c=='+')
                l.add(a+b);
              else
                l.add(a-b);
            }
          }
          
        }
      }
      if(l.size()==0)
        l.add(Integer.valueOf(input));
      map.put(input, l);
      return l;
    }
}
