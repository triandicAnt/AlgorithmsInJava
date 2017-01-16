public class Q191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n==0|| n==1)
            return n;
        int sum  = 0;
        while(n!=0){
            if((n&1)==1)
                sum++;
            n=n>>>1;
        }
        // for(int i=0;i<32;i++){
        //     System.out.println(((1<<i)&n));
        //     if(((1<<i)&n)>0){
        //         sum++;
                   
        //     }
        // }
        return sum;
    }
}
