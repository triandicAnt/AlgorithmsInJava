public class Q31 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
       int i = nums.length-1;
       while(i>0 && nums[i-1]>=nums[i])
            i--;
        if(i<=0){
            reverse(nums, 0,nums.length-1);
            return;
        }
        int j = nums.length-1;
        while(nums[i-1]>=nums[j])
            j--;
        swap(nums, i-1, j);
        reverse(nums, i, nums.length-1);
        
        
    }
    public void swap(int [] a, int i , int j){
        a[i]^=a[j];
        a[j]^=a[i];
        a[i]^=a[j];
    }
    public void reverse(int a[], int i, int j){
        while(i<j){
            swap(a,i++,j--);
        }
    }
}
