public class Q189 {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return;
        k = k%nums.length;
        int h = nums.length-1;
        reverse(nums, 0,h);
        reverse(nums, 0, k-1);
        reverse(nums,k,h);
        
    }
    public void reverse(int []nums, int l, int h){
        while(l<h){
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l++;
            h--;
        }
    }
}
