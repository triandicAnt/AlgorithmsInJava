public class Q70 {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
       // return climbStairs(n-1) + climbStairs(n-2);
        int [] temp = new int[n+1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        for(int i=3;i<=n;i++){
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[n];
    }
}
