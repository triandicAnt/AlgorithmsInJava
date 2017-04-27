public class Q29 {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(dividend==0)
            return 0;
        if(dividend==Integer.MIN_VALUE){
        if(divisor==-1) return Integer.MAX_VALUE;
        else if(divisor==1)  return dividend;
        else return ((divisor&1)==1)?divide(dividend+1,divisor):divide(dividend>>1,divisor>>1);
    } 
    if(divisor==Integer.MIN_VALUE) return 0;
        boolean sign = ((dividend>0)^(divisor>0));
        long did = (long)Math.abs(dividend);
        long div = (long)Math.abs(divisor);
        long res = 0;
        while(did>=div){
            long temp = div;
            long mul = 1;
            while(did>=temp<<1){
                temp <<=1;
                mul<<=1;
            }
            did-=temp;
            res+=mul;
        }
        return sign?-(int)res:(int)res;
    }
}
