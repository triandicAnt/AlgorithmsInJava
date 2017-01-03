public class Q150 {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0)
            return 0;
        if(tokens.length==1)
            return Integer.parseInt(tokens[0]);
        HashSet<String> set = new HashSet<>();
        set.add("*");
        set.add("/");
        set.add("+");
        set.add("-");
        
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int n = tokens.length;
        while(i<n){
            if(set.contains(tokens[i])==false){
                s.push(Integer.parseInt(tokens[i]));
                i++;
            }else{
                int x = s.pop();
                int y = s.pop();
                int z= 0;
                if(tokens[i].equals("*"))
                    z = x*y;
                else if(tokens[i].equals("/"))
                    z = y/x;
                else if(tokens[i].equals("+"))
                    z = x+y;
                else
                    z = y-x;
                s.push(z);
                i++;
            }
           // System.out.println(s);
        }
        return s.peek();
    }
}
