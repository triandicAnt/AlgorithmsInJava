public class Q283 {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return ;
        int i =0;
        for(int a : nums){
            if(a!=0)
                nums[i++] = a;
        }
        while(i<nums.length){
            nums[i++]=0;
        }
    }
}
