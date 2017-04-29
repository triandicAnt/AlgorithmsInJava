public class Q227 {
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        char sign = '+';
        int num = 0;
        for(int i = 0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' ||  i == s.length()-1){
                if(sign == '+')
                    st.push(num);
                else if(sign == '-')
                    st.push(-num);
                else if(sign == '*')
                    st.push(st.pop()*num);
                else if(sign == '/')
                    st.push(st.pop()/num);
                num = 0;
                sign = s.charAt(i);
            }
           
        }
         while(!st.isEmpty())
                res+= st.pop();
        return res;
    }
}
