public class Q476 {
    public int findComplement(int num) {
        if(num==1) return 0;
        else if(num==0) return 0;
        int x = (Integer.highestOneBit(num)<<1)-1;
        System.out.println(x);
        return x^num;
    }
}
