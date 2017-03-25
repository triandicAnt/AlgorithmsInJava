public class Q169 {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int candidate = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(count==0)
                candidate = nums[i];
            if(nums[i]==candidate)
                count++;
            else
                count--;
        }
        count = 0;
        for(int a : nums){
            if(a==candidate)
                count++;
        }
        return count>nums.length/2?candidate:-1;
    }
}
