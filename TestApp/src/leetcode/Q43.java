package leetcode;

import java.util.Arrays;

public class Q43 {
    public String multiply(String num1, String num2) {
        if(num1=="0" || num2 == "0")
            return "0";
        int m = num1.length();
        int n = num2.length();
        
        int result[] = new int [m+n];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1 ;j>=0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + result[p2];
                result[p2] = sum%10;
                result[p1] += sum/10;
            }
        }
        System.out.println(Arrays.toString(result));
        StringBuffer sb = new StringBuffer();
        int x = 0;
        while(x<m+n && result[x]== 0){
                x++;
            }
        if(x<m+n){
            for(int i=x;i<m+n;i++){
                sb.append(result[i]);
            }
        }
        return sb.length()==0?"0":sb.toString();
    }
}
