public class Q80 {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length<=2)
            return 2;
        int p = 1;
        int c = 2;
        while(c<nums.length){
            if(nums[c]==nums[p] && nums[c] == nums[p-1])
                c++;
            else{
                p++;
                nums[p] = nums[c];
                c++;
            }
        }
        return p+1;
    }
}
