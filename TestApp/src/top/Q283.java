public class Q283 {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if(nums[j]!=0){
                nums[i++] = nums[j];
            }
            j++;
        }
        while(i>0 && i<nums.length){
            nums[i++] = 0;
        }
    }
}
