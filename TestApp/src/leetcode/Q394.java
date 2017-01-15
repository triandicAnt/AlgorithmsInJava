public class Q394 {
    public String decodeString(String s) {
        if(s==null || s.length()<=1)
            return s;
        Stack<Integer> intStk = new Stack<>();
        Stack<StringBuffer> sbStk = new Stack<>();
        StringBuffer cur = new StringBuffer();
        int k=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                k = k*10+c-'0';
                
            }else if(c=='['){
                intStk.push(k);
                sbStk.push(cur);
                cur = new StringBuffer();
                k=0;
            }else if(c==']'){
                StringBuffer temp = cur;
                cur = sbStk.pop();
                for(k = intStk.pop(); k > 0; --k){
                    cur.append(temp);
                }
            }else{
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
