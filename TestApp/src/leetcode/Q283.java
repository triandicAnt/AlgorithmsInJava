public class Q283 {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(nums[i]!=0){
                i++;
                j++;
            }else{
                if(nums[j]==0)
                    j++;
                else{
                    swap(nums,i,j);
                    if(nums[i]!=0)
                    {
                        i++;
                    }
                    if(nums[j]!=0){
                        j++;
                    }
                }
            }
        }
        
    }
    public void move(int [] nums){
        int i = 0;
        int j = nums.length-1;
        while(j>=0 && nums[j]==0){
            j--;
        }
        // if(j<0)
        //     return;
        while(i<j){
            if(nums[i]==0){
                swap(nums,i,j);
            }
            if(nums[i]!=0){
                i++;
            }
            if(nums[j]==0){
                j--;
            }
        }
    }
    public void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
