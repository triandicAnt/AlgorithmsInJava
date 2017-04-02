public class Q202 {
    public boolean isHappy(int n) {
        int i1 = n;
        int i2 = next(n);
        while(i1!=i2){
            i1 = next(i1);
            i2 = next(next(i2));
        }
        return i1==1;
    }
    public int next(int n){
        int sum = 0;
        while(n!=0){
            int x = n%10; 
            sum += x*x;
            n/=10;
        }
        return sum;
    }
}
