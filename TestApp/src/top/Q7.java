public class Q7 {
    public int reverse(int x) {
        int res = 0;
        while(x!=0){
            int tail = x%10;
            int newRes = res*10 +tail;
            if(res!=(newRes-tail)/10)
                return 0;
            res = newRes;
            x/=10;
        }
        return res;
    }
}
