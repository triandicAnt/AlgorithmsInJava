package leetcode;

public class SuperPow {
    public int superPow(int a, int[] b) {
        int n = b.length-1;
        return getPower(a,b,n,1337);
    }
    public int getPower(int a, int [] b, int n,int k){
        if(n==0){
            return powMod(a,b[0],1337);
        }else{
            return powMod(getPower(a,b,n-1,k),10,k)*powMod(a,b[n],k)%k;
        }
    }
    // calculate x^y%k {ab%k = (a%k)*(b%k)%k}
    public int powMod(int x, int y, int k){
        x = x%k;
        int power = 1;
        for(int i=1;i<=y;i++){
            power = (power*x)%k;
        }
        return power%k;
    }
}
