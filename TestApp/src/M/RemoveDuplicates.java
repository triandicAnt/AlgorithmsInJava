public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums==null)
            return 0;
        if(nums.length<=1)
            return nums.length;
        int j=0, i = 1;
        
        while(i<nums.length){
            if(nums[i]==nums[j])
                i++;
            else{
                j++;
                nums[j] = nums[i];
                i++;
            }
        }
        return j+1;
    }
}
