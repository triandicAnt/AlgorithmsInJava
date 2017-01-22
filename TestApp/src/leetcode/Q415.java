public class Q415 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        int i = 0;
        int j = 0;
        int carry = 0;
        int n1 = num1.length();
        int n2 = num2.length();
       // System.out.println(num1 + " " + num2);
        while(i<n1 && j<n2){
            int x = num1.charAt(i)-'0';
            int y = num2.charAt(j) - '0';
            int sum = x+y+carry;
            //System.out.println(sum);
            sb.append(sum%10);
            carry = sum/10;
            i++; j++;
            //sum=0;
        }
        if(i<n1){
            while(i<n1){
                int x = num1.charAt(i)-'0';
                x+=carry;
                sb.append(x%10);
                carry = x/10;
                i++;
            }
        }
        if(j<n2){
            while(j<n2){
                int x = num2.charAt(j)-'0';
                x+=carry;
                sb.append(x%10);
                carry = x/10;
                j++;
            }
        }
        if(carry!=0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
