package leetcode;

public class Q29 {
    public int divide(int dividend, int divisor) {
        if(divisor==0)
            return Integer.MAX_VALUE;
        if(dividend == 0)
            return 0;
        if(dividend==Integer.MIN_VALUE){
            if(divisor==-1) return Integer.MAX_VALUE;
        }
        
        boolean a = (dividend>=0)?true:false;
        boolean b = (divisor>=0)?true:false;
        /*
        int c = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend>=divisor){
            dividend-=divisor;
            c++;
        }
        return (x^y)?-c:c;*/
        long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);
        int res = half(x,y,1);
        return (a^b)?-res:res;
    }
    
    public int half(long x, long y , int count){
        if(x<=0 || count == 0)
            return 0;
        if(y>x)
            return half(x, y>>>1, count >>>1);
        else{
            return half(x-y, y+y, count + count) + count;
        }
    }
}
