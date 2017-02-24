public class NoOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n==0 || n==1)
            return n;
        int c = 0;
      while(n!=0){
          if((n&1)==1)
            c++;
          n= n>>>1;
      }
        return c;
    }
}
