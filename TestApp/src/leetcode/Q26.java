public class Q26 {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;
        int j = 0, i =1;
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
