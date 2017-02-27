public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return;
            k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int [] a, int i , int j){
        while(i<j){
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
            i++;
            j--;
        }
    }
}
