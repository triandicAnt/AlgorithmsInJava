public class Q453 {
    public int minMoves(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int a : nums){
            min = Math.min(min,a);
        }
        int count = 0;
        for(int a : nums){
            count += a-min;
        }
        return count;
    }
}
