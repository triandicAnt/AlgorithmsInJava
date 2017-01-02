public class Q402 {
    public String removeKdigits(String num, int k) {
     if(num==null || num.length() == 0 || k>num.length())
            return num;
        int digits = num.length()-k;
        char[] stack = new char[num.length()];
        int top = 0;
        for(int i=0;i<num.length();i++){
            char c= num.charAt(i);
            while(top>0 && stack[top-1]>c && k>0){
                top-=1;
                k-=1;
            }
            stack[top++] = c;
        }
        int index = 0;
        while(index<digits && stack[index]=='0'){
            index++;
        }
        if(index == digits)
            return "0";
        else
            return new String(stack, index, digits-index); 

    }
}
