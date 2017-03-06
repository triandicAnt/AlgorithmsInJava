public class Q365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z)
            return false;
        if(z==x || y==z || x+y==z)
            return true;
        return z%gcdIter(x,y)==0;
    }
    public int gcd(int a, int b){
        if(a==0|| b==0)
            return a+b;
        return gcd(b,a%b);
    }
    public int gcdIter(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
