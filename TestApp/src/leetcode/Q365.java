package leetcode;

public class Q365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z)
            return false;
        if(x==z || y==z|| (x+y)==z)
            return true;
        return z%gcdIterative(x,y)==0?true:false;
    }
    public int gcd(int x, int y){
        if(x==0 || y==0)
            return x+y;
        return gcd(y,x%y);
    }
    public int gcdIterative(int x, int y){
        if(x==0||y==0)
            return x+y;
        while(x!=0&&y!=0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x+y;
    }
}
