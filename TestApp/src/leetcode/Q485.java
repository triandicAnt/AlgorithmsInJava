public class Q485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int max = 0;
        int c = 0;
        for(int a: nums){
            if(a==1){
                c++;
            }else{
                max = Math.max(c,max);
                c=0;
            }
        }
        max = Math.max(c,max);
        return max;
    }
}
