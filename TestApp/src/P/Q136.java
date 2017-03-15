public class Q136 {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int a:nums){
            x^=a;
        }
        return x;
    }
}
