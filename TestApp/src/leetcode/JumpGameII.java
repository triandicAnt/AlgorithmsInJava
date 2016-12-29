public class JumpGameII {
    public int jump(int[] nums) {
        int steps =0;
        int last_max = 0;
        int max = 0;
        for(int i=0;i<nums.length-1;i++){
            max = Math.max(i+nums[i],max);
            if(i==last_max){
                steps++;
                last_max = max;
            }
        }
        return steps;
        
    }
}
